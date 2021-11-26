package task2.main;

import task2.entity.Appliance;

/**
 * Helper class of printing laboratory work results
 */
public class PrintApplianceInfo {

    /**
     * Prints the information about all found appliances.
     * If array is empty "No appliances found" is printed.
     * If object is null "Find error" is printed
     * @param appliances return value appliance service find method
     */
    public static void print(Appliance[] appliances) {
        if (appliances == null) {
            System.out.println("Find error");
        } else if (appliances.length == 0) {
            System.out.println("No appliances found");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance.toString());
            }
        }
    }
}
