package Model;

/**
 * @author Mike Gillotti
 * Appointment class
 */
public class Appointment {
    /**
     * Appointment ID
     */
    private int id;
    /**
     * Appointment title
     */
    private String title;
    /**
     * Appointment description
     */
    private String description;
    /**
     * Appointment location
     */
    private String location;
    /**
     * Appointment type
     */
    private String type;
    /**
     * Appointment start date and time
     */
    private String start;
    /**
     * Appointment end date and time
     */
    private String end;
    /**
     * Appointment record created date and time
     */
    private String create;
    /**
     * Appointment record created by
     */
    private String createdBy;
    /**
     * Appointment record update date and time.
     */
    private String update;
    /**
     * Appointment record updated by
     */
    private String updatedBy;
    /**
     * Appointment customer ID
     */
    private int customer;
    /**
     * Appointment user ID
     */
    private int user;
    /**
     * Appointment contact ID
     */
    private int contact;
    /**
     * Appointment contact name
     */
    private String contactName;


    /**
     * Appointment class constructor
     * @param id
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param create
     * @param createdBy
     * @param update
     * @param updatedBy
     * @param customer
     * @param user
     * @param contact
     * @param contactName
     */
    public Appointment(int id, String title, String description, String location, String type, String start, String end, String create, String createdBy, String update, String updatedBy, int customer, int user, int contact, String contactName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.create = create;
        this.createdBy = createdBy;
        this.update = update;
        this.updatedBy = updatedBy;
        this.customer = customer;
        this.user = user;
        this.contact = contact;
        this.contactName = contactName;
    }

    /**
     *
     * @return appointment ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id appointment ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return appointment title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title appointment title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return appointment description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description appointment description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return appointment location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location appointment location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return appointment type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type appointment type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return appointment start date and time
     */
    public String getStart() {
        return start;
    }

    /**
     *
     * @param start appointment start date and time to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     *
     * @return appointment end date and time
     */
    public String getEnd() {
        return end;
    }

    /**
     *
     * @param end appointment end date and time to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     *
     * @return appointment record create date
     */
    public String getCreate() {
        return create;
    }

    /**
     *
     * @param create appointment record create date to set
     */
    public void setCreate(String create) {
        this.create = create;
    }

    /**
     *
     * @return appointment record created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy appointment record created by to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return appointment record update date and time
     */
    public String getUpdate() {
        return update;
    }

    /**
     *
     * @param update appointment record update date and time to set
     */
    public void setUpdate(String update) {
        this.update = update;
    }

    /**
     *
     * @return appointment record updated by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     *
     * @param updatedBy appointment record updated by to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     *
     * @return appointment customer ID
     */
    public int getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer appointment customer ID to set
     */
    public void setCustomer(int customer) {
        this.customer = customer;
    }

    /**
     *
     * @return appointment User ID
     */
    public int getUser() {
        return user;
    }

    /**
     *
     * @param user appointment User ID to set
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     *
     * @return appointment contact ID
     */
    public int getContact() {
        return contact;
    }

    /**
     *
     * @param contact appointment contact ID to set
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     *
     * @return appointment contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     *
     * @param contactName appointment contact name to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
