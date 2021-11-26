package task2.dao.creator.impl;

import task2.dao.creator.ApplianceCreator;
import task2.entity.Appliance;
import task2.entity.Oven;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Creator of an oven appliance
 */
public class OvenCreator extends ApplianceCreator {

    private static final String POWER_NAME = "power";
    private static final String WEIGHT_NAME = "weight";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(NodeList nodes) {
        int cost = 0;
        int power = 0;
        int weight = 0;

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case COST_NAME -> cost = Integer.parseInt(text);
                    case POWER_NAME -> power = Integer.parseInt(text);
                    case WEIGHT_NAME -> weight = Integer.parseInt(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }

        if (cost == 0 || power == 0 || weight == 0) {
            throw new IllegalArgumentException("Not enough fields in appliance");
        }

        return new Oven(cost, power, weight);
    }
}
