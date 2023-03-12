package DAO;

import Model.Division;
import Scheduler.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces division records in the sql database.
 */
public class DivisionDao {
    /**
     * First level division name
     */
    private String name;

    /**
     * Get first level division name based on ID
     * @param id first level division ID
     * @return first level division name
     */
    public String getDivisionName(Integer id){


        try{

            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT Division FROM first_level_divisions WHERE Division_ID ="+id);
            ResultSet rs = sql.executeQuery();
        if(rs.next()) {
            name= rs.getString("Division");
        }
        return name;
        }catch(Exception e){
            return "error";
        }
    }


}
