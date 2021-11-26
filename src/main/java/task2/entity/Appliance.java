package task2.entity;

import task2.entity.criteria.Criteria;
import task2.entity.criteria.SearchCriteria;
import task2.entity.criteria.SearchCriteriaType;

/**
 * Represents a single object of appliance of the shop
 */
public class Appliance {
    /**
     * Represents cost of an appliance
     */
    protected final int cost;

    /**
     * Gets the cost
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Instantiates an object of a type appliance
     *
     * @param cost cost
     */
    public Appliance(int cost) {
        this.cost = cost;
    }

    /**
     * Returns true if appliance matches the given search criteria. For specific
     * search criteria this method should be overridden in child class
     *
     * @param criteria criteria to match for
     * @return true if appliance matches the given criteria, false otherwise
     * (if criteria is not made for this type of appliance method shall return false)
     */
    public boolean matches(Criteria criteria) {
        if (!criteria.getSearchCriteria().equals(SearchCriteria.Common.COST.name())) return false;

        return switch (SearchCriteriaType.valueOf(criteria.getSearchType())) {
            case LT -> cost < (Integer) criteria.getValue();
            case GT -> cost > (Integer) criteria.getValue();
            case EQ -> cost == (Integer) criteria.getValue();
        };
    }
}