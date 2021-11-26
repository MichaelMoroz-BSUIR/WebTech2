package task2.entity;

import task2.entity.criteria.Criteria;
import task2.entity.criteria.SearchCriteria;
import task2.entity.criteria.SearchCriteriaType;

/**
 * Represents the oven appliance
 */
public class Oven extends Appliance {
    private static final String POWER_CRITERIA = "POWER";
    private static final String WEIGHT_CRITERIA = "WEIGHT";
    private static final String OVEN_NAME = "oven";

    private final int power;
    private final int weight;

    /**
     * Gets power of an oven
     *
     * @return power
     */
    public int getPower() {
        return power;
    }

    /**
     * Gets weight of an oven
     *
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Instantiates an object of the type oven
     *
     * @param cost   cost
     * @param power  power
     * @param weight weight
     */
    public Oven(int cost, int power, int weight) {
        super(cost);
        this.power = power;
        this.weight = weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(Criteria criteria) {
        if (super.matches(criteria)) return true;

        int value;
        switch (criteria.getSearchCriteria()) {
            case SearchCriteria.NAME:
                return OVEN_NAME.equals(criteria.getValue());
            case POWER_CRITERIA:
                value = power;
                break;
            case WEIGHT_CRITERIA:
                value = weight;
                break;
            default:
                return false;
        }

        return switch (SearchCriteriaType.valueOf(criteria.getSearchType())) {
            case LT -> value < (Integer) criteria.getValue();
            case GT -> value > (Integer) criteria.getValue();
            case EQ -> value == (Integer) criteria.getValue();
        };
    }

    @Override
    public String toString() {
        return "Oven{" +
                "cost=" + cost +
                ", power=" + power +
                ", weight=" + weight +
                '}';
    }
}
