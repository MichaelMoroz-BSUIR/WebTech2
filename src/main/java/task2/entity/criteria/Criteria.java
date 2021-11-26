package task2.entity.criteria;

/**
 * The Criteria class represents search criteria
 * on a single field of an appliance. It consists of
 * the criteria itself (field), search type (either EQUALS,
 * LESS THAN or GREATER THAN) and the value to compare with
 */
public class Criteria {
    /**
     * Backing field of search criteria
     */
    private final String searchCriteria;

    /**
     * Backing field of search type
     */
    private final String searchType;

    /**
     * Backing field of search value
     */
    private final Object value;

    /**
     * Gets the search criteria
     *
     * @return search criteria
     */
    public String getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Gets the search type
     *
     * @return search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Gets the search value
     *
     * @return search value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Instantiates object of a type Criteria
     *
     * @param searchCriteria criteria to search for in an appliance
     * @param searchType     search type (EQ, GT, LT)
     * @param value          value to search
     */
    public Criteria(String searchCriteria, String searchType, Object value) {
        this.searchCriteria = searchCriteria;
        this.searchType = searchType;
        this.value = value;
    }
}
