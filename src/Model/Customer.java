package Model;

import java.util.Date;
/**
 * @author Mike Gillotti
 * Customer class
 */
public class Customer {
    /**
     *Customer ID
     */
    private int id;
    /**
     *Customer name
     */
    private String name;
    /**
     *Custoemr address
     */
    private String address;
    /**
     *Customer postal code
     */
    private String postal;
    /**
     *Customer phone number
     */
    private String phone;
    /**
     *Customer record create date and time
     */
    private String date;
    /**
     *Customer record created by
     */
    private String created;
    /**
     *Customer record update date and time
     */
    private String update;
    /**
     *Customer record updated by
     */
    private String updatedBy;
    /**
     *Customer high level division ID
     */
    private int division;
    /**
     * Customer high level division name
     */
    private String divisionName;

    /**
     * Customer class constructor
     * @param id
     * @param name
     * @param address
     * @param postal
     * @param phone
     * @param date
     * @param created
     * @param update
     * @param updatedBy
     * @param division
     * @param divisionName
     */
    public Customer(int id, String name, String address, String postal, String phone, String date, String created, String update, String updatedBy, int division, String divisionName){
        this.id=id;
        this.name=name;
        this.address=address;
        this.postal=postal;
        this.phone=phone;
        this.date=date;
        this.created=created;
        this.update=update;
        this.updatedBy=updatedBy;
        this.division=division;
        this.divisionName = divisionName;
    }

    /**
     *
     * @return customer ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id customer ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name customer name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return customer address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address customer address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return customer postal code
     */
    public String getPostal() {
        return postal;
    }

    /**
     *
     * @param postal customer postal code to set
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     *
     * @return customer phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone customer phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return customer record create date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date customer record create date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return customer record created by
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created customer record created by to set
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return customer record update date
     */
    public String getUpdate() {
        return update;
    }

    /**
     *
     * @param update customer record update date to set
     */
    public void setUpdate(String update) {
        this.update = update;
    }

    /**
     *
     * @return customer record updated by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     *
     * @param updatedBy customer record updated by to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     *
     * @return customer first level division ID
     */
    public int getDivision() {
        return division;
    }

    /**
     *
     * @param division customer first level division ID to set
     */
    public void setDivision(int division) {
        this.division = division;
    }

    /**
     *
     * @return customer first level division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     *
     * @param divisionName first level division name to set
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
