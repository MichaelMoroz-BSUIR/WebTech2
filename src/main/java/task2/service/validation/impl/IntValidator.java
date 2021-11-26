package task2.service.validation.impl;

import task2.service.validation.ValueValidator;

/**
 * Simple positive integer validator
 */
public class IntValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(Object obj) {
        try {
            return (Integer) obj > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
