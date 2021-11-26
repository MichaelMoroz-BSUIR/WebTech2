package task2.service.impl;

import task2.dao.DAOFactory;
import task2.entity.Appliance;
import task2.entity.criteria.Criteria;
import task2.service.ApplianceService;
import task2.service.validation.Validator;

import java.util.Arrays;

/**
 * Implementation of appliance service that works with
 * appliance dao impl
 */
public class ApplianceServiceImpl implements ApplianceService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance[] find(Criteria[] criteria) {
        if (!Arrays.stream(criteria).allMatch(Validator::criteriaValidator)) return null;

        return DAOFactory.getInstance().getApplianceDAO().find(criteria);
    }
}
