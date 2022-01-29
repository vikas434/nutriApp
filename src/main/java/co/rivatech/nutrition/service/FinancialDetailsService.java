package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.FinancialDetails;
import co.rivatech.nutrition.repository.FinanceDetailsRepository;

/**
 * @author vranjan
 * created 19/08/2021
 */
@Service
public class FinancialDetailsService {
    @Autowired
    private FinanceDetailsRepository financeDetailsRepository;

    public FinancialDetails getFinancialDetailsByFamilyId(final int familyId) {
        return financeDetailsRepository.findByFamilyId(familyId)
                                       .orElseThrow(() -> new ResourceNotFoundException(String.format(
                                               "No Financial details found for familyId %s",
                                               familyId)));
    }

    public FinancialDetails save(final FinancialDetails financialDetails) {
        return financeDetailsRepository.save(financialDetails);
    }
}
