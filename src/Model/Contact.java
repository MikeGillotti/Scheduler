package Model;

/**
 * @author Mike Gillotti
 * Contact class
 */
public class Contact {
    /**
     * contact ID
     */
    private int id;
    /**
     * contact name
     */
    private String name;
    /**
     * contact email
     */
    private String email;

    /**
     * Contact class constructor
     * @param id
     * @param name
     * @param email
     */
    public Contact(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     *
     * @return contact ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id contact ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return contact name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name contact name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return contact email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email contact email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
