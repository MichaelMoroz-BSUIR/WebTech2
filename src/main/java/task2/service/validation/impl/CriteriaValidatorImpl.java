package task2.service.validation.impl;

import task2.service.validation.CriteriaValidator;
import task2.service.validation.ValueValidator;

import java.util.Arrays;

/**
 * Implementation of a criteria validator
 */
public class CriteriaValidatorImpl implements CriteriaValidator {
    private final String[] allowedTypes;
    private final ValueValidator valueValidator;

    /**
     * Creates criteria validator in a simpler way with varargs
     * @param valueValidator value validator for search value
     * @param allowedTypes allowed search types
     * @return criteria validator implementation with this parameters
     */
    public static CriteriaValidator create(ValueValidator valueValidator, String... allowedTypes) {
        return new CriteriaValidatorImpl(allowedTypes, valueValidator);
    }

    /**
     * Instantiates criteria validator object
     * @param allowedTypes array of all allowed search types for this search criteria
     * @param valueValidator correct validator for this search value
     */
    public CriteriaValidatorImpl(String[] allowedTypes, ValueValidator valueValidator) {
        this.allowedTypes = allowedTypes;
        this.valueValidator = valueValidator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(String searchType, Object value) {
        return Arrays.asList(allowedTypes).contains(searchType) && valueValidator.validate(value);
    }
}
