package DAO;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Scheduler.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces customer records in the sql database.
 */
public class CustomerDao{
DivisionDao division = new DivisionDao();


    /**
     * Check if a customer has appointments.
     * @param index customer ID
     * @return true if customer has appointments.
     */
    public boolean hasAppointments(Integer index){
        try{
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM appointments WHERE Customer_ID=" + index);
            ResultSet rs = sql.executeQuery();

            if (rs.next()){
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){

            return false;
        }

    }


    /**
     * Gets customer based on ID
     * @param index Customer ID
     * @return customer
     */
    public Customer getCustomer(Integer index){

        try{
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM customers WHERE Customer_ID="+index);
            ResultSet rs = sql.executeQuery();

           if (rs.next()){
            return new Customer(
                    rs.getInt("Customer_ID"),
                    rs.getString("Customer_Name"),
                    rs.getString("Address"),
                    rs.getString("Postal_Code"),
                    rs.getString("Phone"),
                    rs.getString("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getString("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Division_ID"),
                    division.getDivisionName(rs.getInt("Division_ID"))
                );} else{
               return null;
           }

        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    /**
     * Delete customer by ID
     * @param index customer ID
     */
    public void removeCustomer(Integer index){

        try{
            PreparedStatement sql = JDBC.getConnection().prepareStatement("DELETE FROM customers WHERE Customer_ID="+index);
            sql.execute();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Update customer by ID
     * @param index customer ID
     * @param customer customer data to update
     */
    public void updateCustomer(Integer index, Customer customer){

        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("UPDATE customers SET Customer_Name='"+customer.getName()+"', Address='"+customer.getAddress()+"', Postal_Code='"+customer.getPostal()+"', Phone='"+customer.getPhone()+"', Last_Update=CURRENT_TIMESTAMP, Division_ID='"+customer.getDivision()+"', Last_Updated_By='" +customer.getUpdatedBy()+"' WHERE Customer_ID="+index);
            sql.execute();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Add customer record to database.
     * @param customer customer data to add
     */
    public void addCustomer(Customer customer) {

        try {
            PreparedStatement addCustomerSQL = JDBC.getConnection().prepareStatement("INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Last_Update, Division_ID, Last_Updated_By, Created_By) VALUES ('" + customer.getName() + "', '" + customer.getAddress() + "', '" + customer.getPostal() + "', '" + customer.getPhone() +"',  CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '"+customer.getDivision()+"', '"+customer.getUpdatedBy()+"', '"+customer.getCreated()+"' )");
            addCustomerSQL.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Get all customer records from database
     * @return list of customers
     */
    public ObservableList<Customer> getAllCustomers() {
         ObservableList<Customer> list = FXCollections.observableArrayList();

        try {

            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM customers");


            ResultSet rs =sql.executeQuery();

            while(rs.next()){
                list.add(new Customer(
                        rs.getInt("Customer_ID"),
                        rs.getString("Customer_Name"),
                        rs.getString("Address"),
                        rs.getString("Postal_Code"),
                        rs.getString("Phone"),
                        rs.getString("Create_Date"),
                        rs.getString("Created_By"),
                        rs.getString("Last_Update"),
                        rs.getString("Last_Updated_By"),
                        rs.getInt("Division_ID"),
                        division.getDivisionName(rs.getInt("Division_ID")))
                );
            }
            return list;

        } catch (Exception e){
            list.add(new Customer(
                    0,
                    "Error",
                    "Error",
                    "Error",
                    "Error",
                    null,
                    null,
                    null,
                    null,
                    0,
                    null));
            return list;
        }
    }
}
