package task2.service.validation.impl;

import task2.service.validation.ValueValidator;

/**
 * Simple string validator
 */
public class NameValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(Object obj) {
        try {
            String value = (String) obj;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
