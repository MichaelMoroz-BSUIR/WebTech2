package task2.entity.criteria;

/**
 * Encapsulates all constants associated with search criteria
 */
public final class SearchCriteria {
    /**
     * Searches by appliance name
     */
    public static final String NAME = "NAME";

    /**
     * Searches by appliances common fields
     */
    public enum Common {
        COST
    }

    /**
     * Searches by oven appliance field
     */
    public enum Oven {
        POWER, WEIGHT
    }

    /**
     * Searches by smartphone appliance field
     */
    public enum Smartphone {
        PROCESSOR, RAM, OS
    }

    /**
     * Searches by teapot appliance field
     */
    public enum Teapot {
        MATERIAL, TYPE
    }

    /**
     * Private constructor to remove the ability of instantiating search criteria
     */
    private SearchCriteria() {
    }
}

