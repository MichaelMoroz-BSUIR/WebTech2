package task2.service.validation;

import task2.entity.criteria.SearchCriteria;
import task2.entity.criteria.SearchCriteriaType;
import task2.service.validation.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class of a criteria validator
 */
public class CriteriaValidatorFactory {
    private static final CriteriaValidatorFactory instance = new CriteriaValidatorFactory();

    private final Map<String, CriteriaValidator> map = new HashMap<>();

    /**
     * Instantiates a map of search criteria to allowed search type and value validator
     */
    private CriteriaValidatorFactory() {
        map.put(SearchCriteria.NAME, CriteriaValidatorImpl.create(new NameValidator(), SearchCriteriaType.EQ.name()));
        map.put(SearchCriteria.Common.COST.name(), CriteriaValidatorImpl.create(new IntValidator(), SearchCriteriaType.EQ.name(), SearchCriteriaType.GT.name(), SearchCriteriaType.LT.name()));
        map.put(SearchCriteria.Oven.WEIGHT.name(), CriteriaValidatorImpl.create(new IntValidator(), SearchCriteriaType.EQ.name(), SearchCriteriaType.GT.name(), SearchCriteriaType.LT.name()));
        map.put(SearchCriteria.Oven.POWER.name(), CriteriaValidatorImpl.create(new IntValidator(), SearchCriteriaType.EQ.name(), SearchCriteriaType.GT.name(), SearchCriteriaType.LT.name()));
        map.put(SearchCriteria.Smartphone.OS.name(), CriteriaValidatorImpl.create(new OperatingSystemValidator(), SearchCriteriaType.EQ.name()));
        map.put(SearchCriteria.Smartphone.PROCESSOR.name(), CriteriaValidatorImpl.create(new IntValidator(), SearchCriteriaType.EQ.name(), SearchCriteriaType.GT.name(), SearchCriteriaType.LT.name()));
        map.put(SearchCriteria.Smartphone.RAM.name(), CriteriaValidatorImpl.create(new IntValidator(), SearchCriteriaType.EQ.name(), SearchCriteriaType.GT.name(), SearchCriteriaType.LT.name()));
        map.put(SearchCriteria.Teapot.TYPE.name(), CriteriaValidatorImpl.create(new ButtonTypeValidator(), SearchCriteriaType.EQ.name()));
        map.put(SearchCriteria.Teapot.MATERIAL.name(), CriteriaValidatorImpl.create(new MaterialValidator(), SearchCriteriaType.EQ.name()));
    }

    /**
     * Gets the instance of a factory
     * @return instance of a factory
     */
    public static CriteriaValidatorFactory getInstance() {
        return instance;
    }

    /**
     * Gets the correct validator for a specific search criteria
     * @param searchCriteria search criteria to get validator for
     * @return validator for criteria or null if criteria is invalid
     */
    public CriteriaValidator getValidator(String searchCriteria) {
        if (map.containsKey(searchCriteria)) return map.get(searchCriteria);
        return null;
    }
}
