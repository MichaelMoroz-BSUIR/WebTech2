package task2.main;

import task2.entity.Appliance;
import task2.entity.OperatingSystem;
import task2.entity.criteria.Criteria;
import task2.entity.criteria.SearchCriteria;
import task2.entity.criteria.SearchCriteriaType;
import task2.service.ApplianceService;
import task2.service.ServiceFactory;

/**
 * Main class of a console program
 */
public class Main {

    /**
     * Main method
     * @param args console arguments
     */
    public static void main(String[] args) {
        ServiceFactory sf = ServiceFactory.getInstance();
        ApplianceService service = sf.getApplianceService();

        /*------------------------------------------------------------*/

        Criteria ovenCriteria = new Criteria(SearchCriteria.NAME, SearchCriteriaType.EQ.name(), "oven");
        Criteria[] criteria1 = new Criteria[]{ovenCriteria}; // find all ovens
        Appliance[] found1 = service.find(criteria1);

        System.out.println("All ovens:");
        PrintApplianceInfo.print(found1);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria costCriteria = new Criteria(SearchCriteria.Common.COST.name(), SearchCriteriaType.LT.name(), 200);
        Criteria[] criteria2 = new Criteria[]{costCriteria};
        Appliance[] found2 = service.find(criteria2); // cost < 200

        System.out.println("All appliances of cost less than 200:");
        PrintApplianceInfo.print(found2);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria smartphoneCriteria = new Criteria(SearchCriteria.NAME, SearchCriteriaType.EQ.name(), "smartphone");
        Criteria processorCriteria = new Criteria(SearchCriteria.Smartphone.PROCESSOR.name(), SearchCriteriaType.GT.name(), "APPLE");
        Criteria costCriteria2 = new Criteria(SearchCriteria.Common.COST.name(), SearchCriteriaType.LT.name(), 1000);
        Criteria[] criteria3 = new Criteria[]{smartphoneCriteria, processorCriteria, costCriteria2};
        Appliance[] found3 = service.find(criteria3);

        System.out.println("All smartphones cost < 100:");
        PrintApplianceInfo.print(found3);
        System.out.println();

        /*------------------------------------------------------------*/

        Criteria linuxCriteria = new Criteria(SearchCriteria.Smartphone.OS.name(), SearchCriteriaType.EQ.name(), OperatingSystem.ANDROID.name());
        Criteria[] criteria4 = new Criteria[]{smartphoneCriteria, processorCriteria, costCriteria2, linuxCriteria}; // laptop AND battery > 1500
        Appliance[] found4 = service.find(criteria4);

        System.out.println("All cost < 100:");
        PrintApplianceInfo.print(found4);
    }

}
