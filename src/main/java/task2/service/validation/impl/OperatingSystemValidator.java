package task2.service.validation.impl;

import task2.entity.OperatingSystem;
import task2.service.validation.ValueValidator;

/**
 * Simple OS validator
 */
public class OperatingSystemValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(Object obj) {
        try {
            OperatingSystem.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
