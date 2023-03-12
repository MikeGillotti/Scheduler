package DAO;

import Model.User;
import Scheduler.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces user records in the sql database.
 */
public class UserDao {
    /**
     * List of users
     */
    private ObservableList<User> userList = FXCollections.observableArrayList();

    /**
     * Checks if the username exists, then checks if the username's password is valid.
     * @param username the input username
     * @param password the input password
     * @return true if username and password is valid.
     */
    public boolean passwordAccepted(String username, String password){

        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM users WHERE User_Name= '"+username+"'");

            ResultSet rs = sql.executeQuery();

            if(rs.next()){

                if (rs.getString("Password").equals(password)){
                    return  true;
                }else{
                    return false;
                }

            }
            return false;


        }catch(Exception e){
            return false;
        }
    }

    /**
     * Gets all users from database.
     * @return list of users.
     */
    public ObservableList<User> getAllUsers() {

        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM users");

            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                userList.add( new User (
                        rs.getInt("User_ID"),
                        rs.getString("User_Name"),
                        rs.getString("Password")
                ));
            }

return userList;

        } catch (Exception e){
       return  userList;
        }

    }
}
