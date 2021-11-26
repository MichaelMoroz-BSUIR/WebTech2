package task2.service.validation;

/**
 * Interface of a simple value validator
 */
public interface ValueValidator {
    /**
     * Validates single value
     * @param obj value to validate
     * @return true is value is valid, false otherwise
     */
    boolean validate(Object obj);
}
