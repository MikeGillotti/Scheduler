package DAO;

import Model.Appointment;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Scheduler.JDBC;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces appointment records in the sql database.
 */
public class AppointmentDao{

    /**
     * List of appointments
     */
    private ObservableList<Appointment> list = FXCollections.observableArrayList();


    /**
     * Queries appointments tables to see if there's an appointment with a start time within 15 minutes of current local time.
     * @return appointment object if conditions are met, else it returns null.
     */
    public Appointment upcomingAppointment() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));

        ZonedDateTime fifteenMin = ZonedDateTime.now().plusMinutes(15);



        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM appointments WHERE Start BETWEEN CURRENT_TIMESTAMP AND '" + f.format(fifteenMin) + "'");
            ResultSet rs = sql.executeQuery();
            ContactDAO contact = new ContactDAO();
        if (rs.next()) {
            return new Appointment(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    rs.getString("Start"),
                    rs.getString("End"),
                    rs.getString("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getString("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID"),
                    contact.getContactName(rs.getInt("Contact_ID")));
        }else{
            return null;
        }

        }catch(Exception e){
            System.out.println(e);
            return null;
        }


    }

    /**
     * Pulls records between current time and endDate
     * @param endDate UTC date time stamp
     * @return A list of appointments.
     */
    public ObservableList<Appointment> filterAppointments(String endDate){

        try{

            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM appointments WHERE End BETWEEN CURRENT_TIMESTAMP AND '"+endDate+"'");

            ResultSet rs = sql.executeQuery();

            ContactDAO contact = new ContactDAO();

            list.clear();

            while(rs.next()){
                list.add(new Appointment(
                        rs.getInt("Appointment_ID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getString("Location"),
                        rs.getString("Type"),
                        rs.getString("Start"),
                        rs.getString("End"),
                        rs.getString("Create_Date"),
                        rs.getString("Created_By"),
                        rs.getString("Last_Update"),
                        rs.getString("Last_Updated_By"),
                        rs.getInt("Customer_ID"),
                        rs.getInt("User_ID"),
                        rs.getInt("Contact_ID"),
                        contact.getContactName(rs.getInt("Contact_ID")))



                );
            }
            return list;
        }catch (Exception e){
            System.out.println(e);

            return list;
        }
    }

    /**
     * Removes an appointment record where the index is equal to Appointment_ID
     * @param index the index to delete record at.
     */
    public void removeAppointment(Integer index){

        try{
            PreparedStatement sql = JDBC.getConnection().prepareStatement("DELETE FROM appointments WHERE Appointment_ID ="+index);
            sql.execute();


        }catch(Exception e){



        }

    }

    /**
     * Updates an appointment record where the index is equal to Appointment_ID
     * @param index the index to update Appointment record.
     * @param appointment The appointment data to update.
     */
    public void updateAppointment(Integer index, Appointment appointment){

        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("UPDATE appointments SET Title='"+appointment.getTitle()+"', Description='"+appointment.getDescription()+"', Type='"+appointment.getType()+"', Start='"+appointment.getStart()+"', Last_Update=CURRENT_TIMESTAMP, End='"+appointment.getEnd()+"', Customer_ID='"+appointment.getCustomer()+"', Contact_ID='"+appointment.getContact()+"', Location='"+appointment.getLocation()+"', Last_Updated_By='"+appointment.getUpdatedBy()+"', User_ID='"+appointment.getUser()+"' WHERE Appointment_ID="+index);
            sql.execute();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    /**
     * Adds an appointment record to database.
     * @param appointment The appointment record to add.
     */
        public void addAppointment(Appointment appointment) {

            try {
                PreparedStatement addAppointmentSQL = JDBC.getConnection().prepareStatement("INSERT INTO appointments (Title, Description, Type, Start, End, Create_Date, Last_Update, Customer_ID, Contact_ID, User_ID, Location, Created_By, Last_Updated_By) VALUES ('" + appointment.getTitle() + "', '" + appointment.getDescription() + "', '" + appointment.getType() + "', '" + appointment.getStart() + "', '" + appointment.getEnd() + "', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '" + appointment.getCustomer() + "', '" + appointment.getContact() + "', '"+appointment.getUser()+"', '"+appointment.getLocation()+"', '"+appointment.getCreatedBy()+"', '"+appointment.getUpdatedBy()+"')");
                addAppointmentSQL.execute();
            }catch (Exception e){
System.out.println(e);
            }
    }

    /**
     * Gets all appointment records from database.
     * @return list of appointments.
     */
    public ObservableList<Appointment> getAllAppointments() {
        try {

            JDBC.makePreparedStatement("SELECT * FROM appointments",JDBC.getConnection());

            ResultSet rs =JDBC.getPreparedStatement().executeQuery();

            ContactDAO contact = new ContactDAO();

            list.clear();


            while(rs.next()){
                list.add(new Appointment(
                                rs.getInt("Appointment_ID"),
                                rs.getString("Title"),
                                rs.getString("Description"),
                                rs.getString("Location"),
                                rs.getString("Type"),
                                rs.getString("Start"),
                                rs.getString("End"),
                                rs.getString("Create_Date"),
                                rs.getString("Created_By"),
                                rs.getString("Last_Update"),
                                rs.getString("Last_Updated_By"),
                                rs.getInt("Customer_ID"),
                                rs.getInt("User_ID"),
                                rs.getInt("Contact_ID"),
                                contact.getContactName(rs.getInt("Contact_ID")))



                );
            }
            return list;

        } catch (Exception e){

            return list;
        }
    }


}
