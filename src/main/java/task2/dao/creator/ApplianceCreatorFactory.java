package task2.dao.creator;

import task2.dao.creator.impl.OvenCreator;
import task2.dao.creator.impl.SmartphoneCreator;
import task2.dao.creator.impl.TeapotCreator;

/**
 * Factory of appliance creator
 */
public class ApplianceCreatorFactory {
    private static final ApplianceCreatorFactory instance = new ApplianceCreatorFactory();

    private ApplianceCreatorFactory() {

    }

    /**
     * Gets the instance of a factory
     * @return factory instance
     */
    public static ApplianceCreatorFactory getInstance() {
        return instance;
    }

    /**
     * Gets the creator of a correct type appliance from its name
     * @param applianceName name of an appliance
     * @return appliance creator
     * @throws IllegalArgumentException if appliances name matches no creators
     */
    public ApplianceCreator getCreator(String applianceName) {
        return switch (applianceName) {
            case "oven" -> new OvenCreator();
            case "smartphone" -> new SmartphoneCreator();
            case "teapot" -> new TeapotCreator();
            default -> throw new IllegalArgumentException("No such appliance creator exists");
        };
    }
}
