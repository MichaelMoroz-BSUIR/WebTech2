package task2.entity;

import task2.entity.criteria.Criteria;
import task2.entity.criteria.SearchCriteria;

/**
 * Represents the teapot appliance
 */
public class Teapot extends Appliance {
    private static final String MATERIAL_CRITERIA = "MATERIAL";
    private static final String TYPE_CRITERIA = "TYPE";
    private static final String TEAPOT_NAME = "teapot";

    private final Material material;
    private final ButtonType type;

    /**
     * Gets the outside material of a teapot
     *
     * @return outside material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Gets the location of a button on a teapot
     *
     * @return location of a button
     */
    public ButtonType getType() {
        return type;
    }

    /**
     * Instantiates the object of a type teapot
     *
     * @param cost     cost
     * @param material outside material
     * @param type     button location
     */
    public Teapot(int cost, Material material, ButtonType type) {
        super(cost);
        this.material = material;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(Criteria criteria) {
        if (super.matches(criteria)) return true;

        return switch (criteria.getSearchCriteria()) {
            case SearchCriteria.NAME -> TEAPOT_NAME.equals(criteria.getValue());
            case MATERIAL_CRITERIA -> material == Material.valueOf((String) criteria.getValue());
            case TYPE_CRITERIA -> type == ButtonType.valueOf((String) criteria.getValue());
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "Teapot{" +
                "cost=" + cost +
                ", material=" + material +
                ", type=" + type +
                '}';
    }
}
