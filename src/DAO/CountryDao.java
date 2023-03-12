package DAO;

import Model.Country;
import Model.Customer;
import Model.Division;
import Scheduler.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Mike Gillotti
 * This Data Access Object interfaces country records in the sql database.
 */
public class CountryDao {
    /**
     * List of countries
     */
    private ObservableList<Country> list = FXCollections.observableArrayList();
    /**
     * List of first level divisions
     */
    private ObservableList<Division> divisionList = FXCollections.observableArrayList();

    /**
     * Get all countries from database.
     * @return list of countries
     */
    public ObservableList<Country> getAllCountries(){
        try {


            JDBC.makePreparedStatement("SELECT * FROM countries", JDBC.getConnection());

            ResultSet rs =JDBC.getPreparedStatement().executeQuery();

            while(rs.next()){
                list.add(new Country(
                                rs.getInt("Country_ID"),
                                rs.getString("Country")


                        )
                );
            }
            return list;

        } catch (Exception e){



            return list;
        }

    }

    /**
     * Joins countries and first level division records to get a Country based on Country_ID
     * @param id country ID
     * @return Country
     */
    public Country getCountryByDivision(int id) {
        Country country = new Country(0, null);
        try {
            PreparedStatement sql = JDBC.getConnection().prepareStatement("SELECT * FROM countries LEFT JOIN first_level_divisions ON countries.Country_ID = first_level_divisions.Country_ID WHERE first_level_divisions.Division_ID=" + id);

            ResultSet rs = sql.executeQuery();

            if(rs.next()){
                country.setId(rs.getInt("Country_ID"));
                country.setName(rs.getString("Country"));
            }
            return country;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Joins countries and first level division records to get a list first level Divisions based on country_ID.
     * @param id country ID
     * @return List of first level divisions
     */
    public ObservableList<Division> getDivisions(int id){

        try {

            PreparedStatement divisionSQL= JDBC.getConnection().prepareStatement("SELECT * FROM first_level_divisions LEFT JOIN countries ON first_level_divisions.Country_ID = countries.Country_ID WHERE first_level_divisions.Country_ID ="+id);

            ResultSet rs =divisionSQL.executeQuery();

            while(rs.next()){
                divisionList.add(new Division(
                                rs.getInt("Division_ID"),
                                rs.getString("Division"),
                                rs.getInt("Country_ID")


                        )
                );

            }
            return divisionList;

        } catch (Exception e){

            divisionList.add(new Division(
                    0,
                    "error",
                    0));

        return divisionList;
    }
}}
