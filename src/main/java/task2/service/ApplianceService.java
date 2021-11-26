package task2.service;

import task2.entity.Appliance;
import task2.entity.criteria.Criteria;

/**
 * Interface of an appliance service
 */
public interface ApplianceService {

    /**
     * Validates criteria and finds all the appliances
     * that match all given criteria
     * @param criteria criteria to match for
     * @return appliance array that matched the criteria or null if criteria is invalid
     */
    Appliance[] find(Criteria[] criteria);

}
