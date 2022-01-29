package co.rivatech.nutrition.service;

import co.rivatech.nutrition.enums.SortBy;
import co.rivatech.nutrition.exception.NoticeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import co.rivatech.nutrition.model.Notice;
import co.rivatech.nutrition.repository.NoticeRepository;

/**
 * @author vranjan
 * created 29/08/2021
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public Notice save(final Notice notice) {
        return noticeRepository.save(notice);
    }

    public Page<Notice> findAll(final Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }


    public List<Notice> getNoticeByRole(final String role, final SortBy sortBy) {
        switch (role) {
            case "ROLE_DISTRICT":
                if (SortBy.ASC == sortBy) {
                    noticeRepository.findByEnabledTrueAndForDistrictTrueOrderByCreatedAtAsc();
                } else {
                    return noticeRepository.findByEnabledTrueAndForDistrictTrueOrderByCreatedAtDesc();
                }

            case "ROLE_BLOCK":
                if (SortBy.ASC == sortBy) {
                    return noticeRepository.findByEnabledTrueAndForBlockTrueOrderByCreatedAtAsc();
                } else {
                    return noticeRepository.findByEnabledTrueAndForBlockTrueOrderByCreatedAtDesc();
                }
            case "ROLE_ANGANWADI":
                if (SortBy.ASC == sortBy) {
                    return noticeRepository.findByEnabledTrueAndForAnganwadiTrueOrderByCreatedAtAsc();
                } else {
                    return noticeRepository.findByEnabledTrueAndForAnganwadiTrueOrderByCreatedAtDesc();
                }

            case "ROLE_SURVEYOR":
                if (SortBy.ASC == sortBy) {
                    return noticeRepository.findByEnabledTrueAndForSurveyorTrueOrderByCreatedAtAsc();
                } else {
                    return noticeRepository.findByEnabledTrueAndForSurveyorTrueOrderByCreatedAtDesc();
                }
            case "ROLE_SUPER_ADMIN":
            default:
                if (SortBy.ASC == sortBy) {
                    return noticeRepository.findByEnabledTrueOrderByCreatedAtAsc();
                } else {
                    return noticeRepository.findByEnabledTrueOrderByCreatedAtDesc();
                }
        }
    }

    public List<Notice> findNoticeByTitleKeyword(final String keyword) {
        return noticeRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public void deleteById(final int noticeId) {
        if (noticeRepository.existsById(noticeId)) {
            noticeRepository.deleteById(noticeId);
        } else {
            throw new NoticeNotFoundException(String.format("No notice found for the id %d", noticeId));
        }
    }
}
