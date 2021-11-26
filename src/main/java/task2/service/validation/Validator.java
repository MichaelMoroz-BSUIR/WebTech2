package task2.service.validation;

import task2.entity.criteria.Criteria;

/**
 * Validator class for single criteria
 */
public class Validator {

    /**
     * Validates the criteria by its search criteria
     * E.g. search type of NAME criteria cannot be anything
     * but EQUALS
     * @param criteria criteria to validate
     * @return true if criteria is valid, false otherwise
     */
    public static boolean criteriaValidator(Criteria criteria) {
        if (criteria == null ||
                criteria.getSearchCriteria() == null ||
                criteria.getSearchType() == null ||
                criteria.getValue() == null) return false;

        CriteriaValidator validator = CriteriaValidatorFactory.getInstance().getValidator(criteria.getSearchCriteria());
        return validator.validate(criteria.getSearchType(), criteria.getValue());
    }
}