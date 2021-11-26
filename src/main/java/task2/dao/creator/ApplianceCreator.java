package task2.dao.creator;

import task2.entity.Appliance;
import org.w3c.dom.NodeList;

/**
 * Represents factory of an appliance from
 * xml values
 */
public abstract class ApplianceCreator {
    /**
     * Holds xml node name for cost field
     */
    protected static final String COST_NAME = "cost";

    /**
     * Creates the appliance of a correct type from
     * attributes saved in nodes of xml file
     * @param nodes attributes and nodes of appliance from xml file
     * @return appliance of a correct type
     */
    public abstract Appliance create(NodeList nodes);
}
