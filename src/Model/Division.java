package Model;

/**
 * @author Mike Gillotti
 * First level division class
 */
public class Division {
    /**
     * First level division ID
     */
    private int id;
    /**
     * First level division name
     */
    private String name;
    /**
     * First level division Country ID
     */
    private int countryID;

    /**
     * High level division class constructor
     * @param id
     * @param name
     * @param countryID
     */
    public Division(int id, String name, int countryID) {
        this.id = id;
        this.name = name;
        this.countryID = countryID;
    }

    /**
     *
     * @return first level division ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id first level division ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return first level division name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name first level division name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return first level division country ID
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     *
     * @param countryID first level division country ID to set
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
}
