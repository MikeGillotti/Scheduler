package DAO;

import Model.Contact;
import Scheduler.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces contact records in the sql database.
 */
public class ContactDAO {
    /**
     * Contact name
     */
    private String name;
    /**
     * List of contacts.
     */
    private ObservableList<Contact> list= FXCollections.observableArrayList();

    /**
     * Gets all contacts from the database.
     * @return list of contacts.
     */
    public ObservableList<Contact> getAllContacts(){

        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM contacts");
            ResultSet rs = sql.executeQuery();
            while(rs.next()){

                list.add( new Contact(rs.getInt("Contact_ID"), rs.getString("Contact_Name"), rs.getString("Email")));
            }


            return list;
        }catch (Exception e){

            System.out.println(e);

    return list;
        }


    }

    /**
     * Gets name of contact based on Contact_ID
     * @param id contact ID
     * @return Contact name
     */
    public String getContactName (int id){

        try {

            PreparedStatement contactSQL = JDBC.getConnection().prepareStatement("SELECT * FROM contacts WHERE Contact_ID="+id);

            ResultSet rs =contactSQL.executeQuery();

           if (rs.next()) {
               name = rs.getString("Contact_Name");
           }
            return name;

        } catch (Exception e){
            System.out.println(e);
            return "No contact found";
        }










    }
}
