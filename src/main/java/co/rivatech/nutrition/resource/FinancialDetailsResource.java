package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.FinancialDetails;
import co.rivatech.nutrition.service.FinancialDetailsService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/finance")
public class FinancialDetailsResource {

    @Autowired
    private FinancialDetailsService financialDetailsService;


    @GetMapping("/findFinanceByFamilyId/{familyId}")
    @ApiOperation(value = "Get details of finance or throw exception")
    public FinancialDetails getFinanceByFamilyId(@Nonnull @PathVariable int familyId) {
        return financialDetailsService.getFinancialDetailsByFamilyId(familyId);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a financial details to a family.")
    public FinancialDetails addFinancialDetails(@Nonnull @RequestBody FinancialDetails financialDetails) {
        return financialDetailsService.save(financialDetails);
    }

}
