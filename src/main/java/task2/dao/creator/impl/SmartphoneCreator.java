package task2.dao.creator.impl;

import task2.dao.creator.ApplianceCreator;
import task2.entity.Appliance;
import task2.entity.OperatingSystem;
import task2.entity.Processor;
import task2.entity.Smartphone;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents creator of a smartphone appliance
 */
public class SmartphoneCreator extends ApplianceCreator {

    private static final String PROCESSOR_NAME = "processor";
    private static final String RAM_NAME = "ram";
    private static final String OS_NAME = "os";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(NodeList nodes) {
        int cost = 0;
        Processor processor = null;
        int ram = 0;
        OperatingSystem os = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case COST_NAME -> cost = Integer.parseInt(text);
                    case PROCESSOR_NAME -> processor = Processor.valueOf(text);
                    case RAM_NAME -> ram = Integer.parseInt(text);
                    case OS_NAME -> os = OperatingSystem.valueOf(text);
                    default -> throw new IllegalArgumentException("No such appliance exists");
                }
            }
        }

        if (cost == 0 || processor == null || ram == 0 || os == null) {
            throw new IllegalArgumentException("Not enough fields in appliance");
        }

        return new Smartphone(cost, processor, ram, os);
    }
}
