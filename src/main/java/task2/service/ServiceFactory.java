package task2.service;

import task2.service.impl.ApplianceServiceImpl;

/**
 * Factory of an appliance service
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    /**
     * Gets the appliance service
     * @return appliance service
     */
    public ApplianceService getApplianceService() {

        return applianceService;
    }

    /**
     * Gets the instance of a factory
     * @return instance of a factory
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

}
