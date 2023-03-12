package Model;
/**
 * @author Mike Gillotti
 * Country class
 */
public class Country {
    private int id;
    private String name;

    /**
     * Country class constructor
     * @param id
     * @param name
     */
    public Country(int id, String name) {
        /**
         * Country ID
         */
        this.id = id;
        /**
         * Country name
         */
        this.name = name;
    }

    /**
     *
     * @return country ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id country ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return country name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name country name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
