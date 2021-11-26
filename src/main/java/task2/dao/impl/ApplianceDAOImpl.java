package task2.dao.impl;

import task2.dao.ApplianceDAO;
import task2.dao.creator.ApplianceCreator;
import task2.dao.creator.ApplianceCreatorFactory;
import task2.entity.Appliance;
import task2.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of an appliance dao that reads
 * the information from xml file in resources folder
 */
public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String RESOURCES_APPLIANCES_XML = "./src/main/resources/appliances.xml";

    /**
     * {@inheritDoc}
     * Assumes that XML file is in the correct format
     */
    @Override
    public Appliance[] find(Criteria[] criteria) {
        List<Appliance> matches = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(RESOURCES_APPLIANCES_XML));
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    ApplianceCreator ac = ApplianceCreatorFactory.getInstance().getCreator(node.getNodeName());
                    Appliance appliance = ac.create(node.getChildNodes());
                    if (Arrays.stream(criteria).allMatch(appliance::matches)) {
                        matches.add(appliance);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }

        return matches.toArray(new Appliance[0]);
    }
}