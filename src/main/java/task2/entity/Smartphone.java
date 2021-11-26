package task2.entity;

import task2.entity.criteria.Criteria;
import task2.entity.criteria.SearchCriteria;
import task2.entity.criteria.SearchCriteriaType;

/**
 * Represents the smartphone appliance
 */
public class Smartphone extends Appliance {
    private static final String PROCESSOR_CRITERIA = "BATTERY";
    private static final String RAM_CRITERIA = "RAM";
    private static final String OS_CRITERIA = "OS";
    private static final String SMARTPHONE_NAME = "smartphone";

    private final Processor processor;
    private final int ram;
    private final OperatingSystem os;

    /**
     * Gets the volume of a battery
     *
     * @return battery volume
     */
    public Processor getProcessor() {
        return processor;
    }

    /**
     * Gets the maximum ram
     *
     * @return ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * Gets the OS installed on a smartphone
     *
     * @return OS
     */
    public OperatingSystem getOs() {
        return os;
    }

    /**
     * Instantiates an object of a type smartphone
     *
     * @param cost    cost
     * @param processor processor name
     * @param ram     maximum ram
     * @param os      os
     */
    public Smartphone(int cost, Processor processor, int ram, OperatingSystem os) {
        super(cost);
        this.processor = processor;
        this.ram = ram;
        this.os = os;
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
                return SMARTPHONE_NAME.equals(criteria.getValue());
            case PROCESSOR_CRITERIA:
                return processor == Processor.valueOf((String) criteria.getValue());
            case RAM_CRITERIA:
                value = ram;
                break;
            case OS_CRITERIA:
                return os == OperatingSystem.valueOf((String) criteria.getValue());
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
        return "Smartphone{" +
                "cost=" + cost +
                ", processor=" + processor +
                ", ram=" + ram +
                ", os=" + os +
                '}';
    }
}
