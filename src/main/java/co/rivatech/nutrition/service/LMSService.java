package co.rivatech.nutrition.service;

import co.rivatech.nutrition.exception.ResourceAlreadyExistsException;
import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.exception.UserDataMissingException;
import co.rivatech.nutrition.model.LMS;
import co.rivatech.nutrition.model.LMSEvaluation;
import co.rivatech.nutrition.model.LMSQnA;
import co.rivatech.nutrition.repository.LMSEvaluationRepository;
import co.rivatech.nutrition.repository.LMSQnARepository;
import co.rivatech.nutrition.repository.LMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author vranjan
 * created 18/08/2021
 */
@Service
public class LMSService {

    @Autowired
    private LMSRepository lmsRepository;

    @Autowired
    private LMSEvaluationRepository lmsEvaluationRepository;

    @Autowired
    private LMSQnARepository lmsQnARepository;

    public LMS addLMS(final LMS lms) {
        return lmsRepository.save(lms);
    }

    public List<LMS> getPaginatedLMS(final Integer pageNo, final Integer pageSize, final String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LMS> pagedResult = lmsRepository.findAll(paging);
        if (!pagedResult.isEmpty()) {
            return pagedResult.getContent();
        } else {
            return Collections.emptyList();
        }
    }

    public List<LMSEvaluation> getLmsEvaluationsForAUser(final int userId) {
        final List<LMSEvaluation> lmsEvaluations = lmsEvaluationRepository.findByUserId(userId);
        if (lmsEvaluations.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No LMS evaluation found for the user id %s", userId));
        }
        final int lmsId = lmsEvaluations.get(0).getLmsId();
        final LMS lms = lmsRepository.findById(lmsId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(
                        "No LMS found with the LMS id %s",
                        lmsId)));
        lmsEvaluations.stream().forEach(l -> {
            l.setThumbnailUrl(lms.getThumbnailUrl());
            l.setTitle(lms.getTitle());
            l.setVideoUrl(lms.getVideoUrl());
        });
        return lmsEvaluations;
    }

    public LMSEvaluation saveLmsEvaluation(final LMSEvaluation lmsEvaluation) {
        final Integer userId = lmsEvaluation.getUserId();
        final int lmsId = lmsEvaluation.getLmsId();
        if (null == userId || userId.equals(0)) {
            throw new UserDataMissingException(String.format("User details not available here for lmsId, %d", lmsId));
        }
        if (!getByLmsIdAndUserId(lmsId, userId).isEmpty()) {
            throw new ResourceAlreadyExistsException(String.format("There is already an entry with user id %d for lms id %d ", userId, lmsId));
        }
        return lmsEvaluationRepository.save(lmsEvaluation);
    }

    public List<LMSEvaluation> getByLmsIdAndUserId(int lmsId, int userId) {
        return lmsEvaluationRepository.findByLmsIdAndUserId(lmsId, userId);
    }

    public LMSQnA saveLmsQnA(final LMSQnA lmsQnA, final boolean edit) {
        if (lmsQnA.getUserId() == 0) {
            throw new UserDataMissingException(String.format("No user id given for the user lms id %d", lmsQnA.getLmsId()));
        }
        if (!edit && lmsQnARepository.findByLmsId(lmsQnA.getLmsId()) != null) {
            throw new ResourceNotFoundException(String.format("There is already a Q&A with lmsId %d", lmsQnA.getLmsId()));
        }
        return lmsQnARepository.save(lmsQnA);
    }

    public LMSQnA geLMSQnAByLmsId(final int lmsId) {
         LMSQnA lmsQnA = lmsQnARepository.findByLmsId(lmsId);
        if(null == lmsQnA) {
            lmsQnA = LMSQnA.builder().id(0).userId(0).lmsId(lmsId).questionList(Collections.emptyList()).build();
        }
        return lmsQnA;
    }

    public List<LMS> searchLMSByTitle(final String title) {
        return lmsRepository.findByTitleContainingIgnoreCase(title);
    }
}
