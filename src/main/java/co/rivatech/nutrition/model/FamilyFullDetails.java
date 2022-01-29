package co.rivatech.nutrition.model;

import java.util.List;

import lombok.Data;

/**
 * @author vranjan
 * created 16/09/2021
 */
@Data
public class FamilyFullDetails {
    private List<ChildDetails> childFullDetailsJson;

    private List<WomanDetailsWithFamilyName> womanFullDetailsJson;
}
