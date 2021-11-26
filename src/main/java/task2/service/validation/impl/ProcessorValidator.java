package task2.service.validation.impl;

import task2.entity.Processor;
import task2.service.validation.ValueValidator;

/**
 * Simple processor validator
 */
public class ProcessorValidator implements ValueValidator {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(Object obj) {
        try {
            Processor.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
