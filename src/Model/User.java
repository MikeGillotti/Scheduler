package Model;
/**
 * @author Mike Gillotti
 * User class
 */
public class User {
    /**
     * User id
     */
    private int id;
    /**
     * User name
     */
    private String name;
    /**
     * User password
     */
    private String password;

    /**
     * User class constructor
     * @param id
     * @param name
     * @param password
     */
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     *
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id user id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password user password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
