package task2.service.validation;

/**
 * Interface of a criteria validator, that validates
 * criteria search type and value
 */
public interface CriteriaValidator {
    /**
     * Validate search type and value of a criteria
     * @param searchType search type of criteria
     * @param value search value of a criteria
     * @return true if both values are valid, false otherwise
     */
    boolean validate(String searchType, Object value);
}
