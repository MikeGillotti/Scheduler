package Controller;

import DAO.*;
import Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author Mike Gillotti
 * Controller for the mainscreen.
 */
public class Controller implements Initializable {
    /**
     * Customer ID form field. Cannot be modified.
     */
    @FXML
    private TextField customerIDForm;
    /**
     * Appointment ID form. Cannot be modified.
     */
    @FXML
    private TextField appointmentIDForm;
    /**
     * User ID form. Cannot be modified.
     */
    @FXML
    private TextField userIDForm;
    /**
     * Radio button that filters schedule by week.
     */
    @FXML
    private RadioButton weekViewRadio;
    /**
     * Radio button that filters schedule by month.
     */
    @FXML
    private RadioButton monthViewRadio;
    /**
     * Radio button that shows whole schedule.
     */
    @FXML
    private RadioButton viewAllRadio;
    /**
     * Combobox for the start time at the second digit of the minute.
     */
    @FXML
    private ComboBox startMinute2Form;
    /**
     * Combobox for the end time at the second digit of the minute.
     */
    @FXML
    private ComboBox EndMinute2Form;
    /**
     * Combobox for the customer in the appointment scheduler form.
     */
    @FXML
    private ComboBox customerCombo;
    /**
     * Button that saves data while an appointment is being updated.
     */
    @FXML
    private Button saveAppointmentButton;
    /**
     * Button that exits appointment update mode without saving data.
     */
    @FXML
    private Button backAppointmentButton;
    /**
     * Button that deletes selected appointment.
     */
    @FXML
    private Button deleteAppointmentButton;
    /**
     * Button that populates appointment fields with selected appointment and enters update mode.
     */
    @FXML
    private Button updateAppointmentButton;
    /**
     * Button that createst new appointment based on data entered into appointment fields.
     */
    @FXML
    private Button addAppointmentButton;
    /**
     * Input field for appointment description.
     */
    @FXML
    private TextField descriptionAppointmentForm;
    /**
     * Combobox for the contacts in the appointment scheduler form.
     */
    @FXML
    private ComboBox contactCombo;
    /**
     * Input field for appointment location.
     */
    @FXML
    private TextField locationAppointmentForm;
    /**
     * Input field for appointment type.
     */
    @FXML
    private TextField typeAppointmentForm;
    /**
     * Input field for appointment title.
     */
    @FXML
    private TextField titleAppointmentForm;
    /**
     * Datepicker for appointment start date.
     */
    @FXML
    private DatePicker startAppointmentForm;
    /**
     * Combobox for end time for first digit of minute.
     */
    @FXML
    private ComboBox endMinuteForm;
    /**
     * Combobox for the end time's hour.
     */
    @FXML
    private ComboBox endHourForm;
    /**
     * Combobox for the end time's AM/PM
     */
    @FXML
    private ComboBox endAMPMForm;
    /**
     * Combo for the start time's AM/PM
     */
    @FXML
    private ComboBox startAMPMForm;
    /**
     * Combobox for the start time of the first digit of the minute.
     */
    @FXML
    private ComboBox startMinuteForm;
    /**
     * Combobox for the start time's hour.
     */
    @FXML
    private ComboBox startHourForm;
    /**
     * Datepicker for the appointment's end date.
     */
    @FXML
    private DatePicker endAppointmentForm;
    /**
     * Button to delete selected customer.
     */
    @FXML
    private Button deleteCustomerButton;
    /**
     * Button that exits customer update mode without saving.
     */
    @FXML
    private  Button backCustomerButton;
    /**
     * Button that saves customer data while in update mode.
     */
    @FXML
    private Button saveCustomerButton;
    /**
     * Button that populates customer form fields with selected customer data.
     */
    @FXML
    private Button updateCustomerButton;
    /**
     * Button that creates new customer record.
     */
    @FXML
    private Button addCustomerButton;
    /**
     * Input field for customer name.
     */
    @FXML
    private TextField customerNameForm;
    /**
     * Input field for customer address.
     */
    @FXML
    private TextField customerAddressForm;
    /**
     * Input field for customer postal code.
     */
    @FXML
    private TextField customerPostalForm;
    /**
     * Input field for customer phone number.
     */
    @FXML
    private TextField customerPhoneForm;
    /**
     * Customer's first level division table column.
     */
    @FXML
    private TableColumn<Customer, String> customerDivision;
    /**
     * Combobox for customer's first level division
     */
    @FXML
    private ComboBox divisionCombo;
    /**
     * Combobox for customer's country.
     */
    @FXML
    private ComboBox countryCombo;
    /**
     * Tableview for appointments.
     */
    @FXML
    private TableView appointmentTable;
    /**
     * Table column for appointment IDs.
     */
    @FXML
    private TableColumn<Appointment, Integer> appointmentID;
    /**
     * Table column for appointment title.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentTitle;
    /**
     * Table column for appointment description.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentDescription;
    /**
     * Table column for appointment location.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentLocation;
    /**
     * Table column for appointment contact.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentContact;
    /**
     * Table column for appointment type.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentType;
    /**
     * Table column for appointment start date and time.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentStart;
    /**
     * Table column for appointment end date and time.
     */
    @FXML
    private TableColumn<Appointment, String> appointmentEnd;
    /**
     * Table column for appointment customer ID.
     */
    @FXML
    private TableColumn<Appointment, Integer> appointmentCustomer;
    /**
     * Table column for appointment user ID.
     */
    @FXML
    private TableColumn<Appointment, Integer> appointmentUser;
    /**
     * Table for customer records.
     */
    @FXML
    private TableView customerTable;
    /**
     * Table column for customer name.
     */
    @FXML
    private  TableColumn<Customer, String> customerName;
    /**
     * Table column for customer address.
     */
    @FXML
    private  TableColumn<Customer, String> customerAddress;
    /**
     * Table column for customer postal code.
     */
    @FXML
    private  TableColumn<Customer, String> customerPostal;
    /**
     * Table column for customer phone number.
     */
    @FXML
    private  TableColumn<Customer, String> customerPhone;

    /**
     * Contact data access object.
     */
    private ContactDAO contact = new ContactDAO();
    /**
     * First level division ID used while updating customer record.
     */
    private int divisionToUpdate;
    /**
     * Customer ID used while updating customer record.
     */
    private int customerID;
    /**
     * Customer ID used while updating appointment record.
     */
    private int customerToUpdate;
    /**
     * Appointment ID used while updating appointment record.
     */
    private int appointmentIndex;
    /**
     * Contact ID used while updating appointment record.
     */
    private int contactToUpdate;
    /**
     * User data assigned after logging in.
     */
    private User currentUser=Login.currentUser;
    /**
     * Values for hour combobox.
     */
    private ObservableList<String> hour = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    /**
     * Values for first digit of minute combobox
     */
    private ObservableList<String> tenMinute = FXCollections.observableArrayList("0","1","2","3","4","5");
    /**
     * Values for second digit of minute combobox
     */
    private ObservableList<String> minute = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9");

    /**
     * Values for AM/PM combobox.
     */
    private  ObservableList<String> AMPM = FXCollections.observableArrayList("AM", "PM");
    /**
     * Appointment data access object.
     */
    private AppointmentDao appointment = new AppointmentDao();

    /**
     * Method is called when main screen is entered. Tableviews are setup. Upcoming appointment is checked.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        CustomerDao customer= new CustomerDao();

        CountryDao country= new CountryDao();
        Appointment upcoming = appointment.upcomingAppointment();




        customerName.setCellValueFactory( new PropertyValueFactory<>("name"));
        customerAddress.setCellValueFactory( new PropertyValueFactory<>("address"));
        customerPostal.setCellValueFactory( new PropertyValueFactory<>("postal"));
        customerDivision.setCellValueFactory( new PropertyValueFactory<>("divisionName"));
        customerPhone.setCellValueFactory( new PropertyValueFactory<>("phone"));
        customerTable.setItems(customer.getAllCustomers());


        appointmentID.setCellValueFactory( new PropertyValueFactory<>("id"));
        appointmentTitle.setCellValueFactory( new PropertyValueFactory<>("title"));
        appointmentDescription.setCellValueFactory( new PropertyValueFactory<>("description"));
        appointmentLocation.setCellValueFactory( new PropertyValueFactory<>("location"));
        appointmentType.setCellValueFactory( new PropertyValueFactory<>("type"));
        appointmentContact.setCellValueFactory(   new PropertyValueFactory<>("contactName"));
        appointmentCustomer.setCellValueFactory( new PropertyValueFactory<>("customer"));
        appointmentUser.setCellValueFactory( new PropertyValueFactory<>("user"));

        appointmentStart.setCellValueFactory(cellView-> {
            try {
                return new SimpleStringProperty(UTCtoLocalDate(cellView.getValue().getStart()).toString()+" "+
                        hour.get(UTCtoLocalTime(cellView.getValue().getStart()).get(0))+":"+
                        tenMinute.get(UTCtoLocalTime(cellView.getValue().getStart()).get(1))+
                        minute.get(UTCtoLocalTime(cellView.getValue().getStart()).get(2))+" "+
                        AMPM.get(UTCtoLocalTime(cellView.getValue().getStart()).get(3)));
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        });

        appointmentEnd.setCellValueFactory(cellView-> {
            try {
                return new SimpleStringProperty(UTCtoLocalDate(cellView.getValue().getEnd()).toString()+" "+
                        hour.get(UTCtoLocalTime(cellView.getValue().getEnd()).get(0))+":"+
                        tenMinute.get(UTCtoLocalTime(cellView.getValue().getEnd()).get(1))+
                        minute.get(UTCtoLocalTime(cellView.getValue().getEnd()).get(2))+" "+
                        AMPM.get(UTCtoLocalTime(cellView.getValue().getEnd()).get(3)));
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        });



        appointmentTable.setItems(appointment.getAllAppointments());



        startHourForm.setItems(hour);
        startHourForm.getSelectionModel().select(7);
        startMinuteForm.setItems(tenMinute);
        startMinuteForm.getSelectionModel().select(0);
        startAMPMForm.setItems(AMPM);
        startAMPMForm.getSelectionModel().select(0);
        startMinute2Form.setItems(minute);
        startMinute2Form.getSelectionModel().select(0);


        endHourForm.setItems(hour);
        endHourForm.getSelectionModel().select(7);
        endMinuteForm.setItems(tenMinute);
        endMinuteForm.getSelectionModel().select(1);
        EndMinute2Form.setItems(minute);
        EndMinute2Form.getSelectionModel().select(5);
        endAMPMForm.setItems(AMPM);
        endAMPMForm.getSelectionModel().select(0);



        Callback<ListView<Country>, ListCell<Country>> cf = listView -> new ListCell<Country>(){

            @Override
            protected void updateItem(Country country, boolean empty) {
                super.updateItem(country, empty);
                setText(empty ? "" : country.getName());
            }
        };

        countryCombo.setItems(country.getAllCountries());
        countryCombo.setCellFactory(cf);
        countryCombo.setButtonCell(cf.call(null));
        AddCustomerMode();
        AddAppointmentMode();
userIDForm.setText(String.valueOf(currentUser.getId()));

        if(upcoming!=null){

            try {
                InfoBox("Alert", "Upcoming Appointment:\n" +
                        upcoming.getTitle() + "\n" +
                        UTCtoLocalDate(upcoming.getStart())+"\n"+
                        hour.get(UTCtoLocalTime(upcoming.getStart()).get(0))+":"+
                        tenMinute.get(UTCtoLocalTime(upcoming.getStart()).get(1))+
                        minute.get(UTCtoLocalTime(upcoming.getStart()).get(2))+" "+
                        AMPM.get(UTCtoLocalTime(upcoming.getStart()).get(3))+"\n"+
                        "Appointment ID:" + upcoming.getId()


                );
            }catch(Exception e){

            }

        }else{

            InfoBox("Alert","No upcoming appointments");
        }






        Callback<ListView<Customer>, ListCell<Customer>> customerCF = listView -> new ListCell<Customer>(){

            @Override
            protected void updateItem(Customer customer, boolean empty) {
                super.updateItem(customer, empty);
                setText(empty ? "" : customer.getName());
            }
        };


        customerCombo.setItems(customer.getAllCustomers());
        customerCombo.setCellFactory(customerCF);
        customerCombo.setButtonCell(customerCF.call(null));


        Callback<ListView<Contact>, ListCell<Contact>> contactCF = listView -> new ListCell<Contact>(){

            @Override
            protected void updateItem(Contact contact, boolean empty) {
                super.updateItem(contact, empty);
                setText(empty ? "" : contact.getName());
            }
        };


        contactCombo.setItems(contact.getAllContacts());
        contactCombo.setCellFactory(contactCF);
        contactCombo.setButtonCell(contactCF.call(null));
    }



    Callback<ListView<Division>, ListCell<Division>> cellFactory = listView -> new ListCell<Division>(){

        @Override
        protected void updateItem(Division division, boolean empty) {
            super.updateItem(division, empty);
            setText(empty ? "" : division.getName());
        }
    };


    /**
     * Method is called when country is selected. The first level divisions associated with country is populated in its combobox.
     */
    public void OnCountrySelect() {
        CountryDao country= new CountryDao();



    try {
        Country selectedCountry = (Country) countryCombo.getSelectionModel().getSelectedItem();

        divisionCombo.valueProperty().set(null);
        divisionCombo.setItems(country.getDivisions(selectedCountry.getId()));
        divisionCombo.setCellFactory(cellFactory);
        divisionCombo.setButtonCell(cellFactory.call(null));
    }
    catch (NullPointerException e){
    }
    }

    /**
     *Method that creates a new customer record based on values input in form fields.
     */
    public void addCustomerForm(ActionEvent actionEvent) {
        CustomerDao customer= new CustomerDao();
        Customer newCustomer = new Customer(0, null, null, null, null, null, null, null, null, 0, null);
        Division selectedDivision = (Division) divisionCombo.getValue();



        try {

            newCustomer.setName(customerNameForm.getText());
            newCustomer.setAddress(customerAddressForm.getText());
            newCustomer.setPostal(customerPostalForm.getText());
            newCustomer.setPhone(customerPhoneForm.getText());
            newCustomer.setDivision(selectedDivision.getId());
            newCustomer.setCreated(currentUser.getName());
            newCustomer.setUpdatedBy(currentUser.getName());


            customer.addCustomer(newCustomer);
            customerNameForm.clear();
            customerAddressForm.clear();
            customerPostalForm.clear();
            customerPhoneForm.clear();
            divisionCombo.getSelectionModel().clearSelection();
            countryCombo.getSelectionModel().clearSelection();
            customerTable.getItems().clear();
            customerTable.setItems(customer.getAllCustomers());
            customerCombo.setItems(customer.getAllCustomers());
        }catch(Exception e){

            InfoBox("Error", "Form contains empty fields");

        }

    }

    /**
     *
     * Method that populates form fields with selected customer data, and enters customer update mode.
     */

    public void updateCustomerForm(ActionEvent actionEvent) {
        CountryDao country= new CountryDao();



        Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();


        customerNameForm.clear();
        customerAddressForm.clear();
        customerPostalForm.clear();
        customerPhoneForm.clear();
        countryCombo.getSelectionModel().clearSelection();
        divisionCombo.getSelectionModel().clearSelection();
        customerNameForm.setText(selectedCustomer.getName());
        customerAddressForm.setText(selectedCustomer.getAddress());
        customerPostalForm.setText(selectedCustomer.getPostal());
        customerPhoneForm.setText(selectedCustomer.getPhone());
        customerID=selectedCustomer.getId();
        customerIDForm.setText(String.valueOf(selectedCustomer.getId()));






        countryCombo.getSelectionModel().select((country.getCountryByDivision(selectedCustomer.getDivision()).getId()-1));





        divisionCombo.getSelectionModel().select(selectedCustomer.getDivisionName());
        divisionToUpdate= selectedCustomer.getDivision();

        UpdateCustomerMode();




    }

    /**
     *
     * Method called when division is selected. assigns ID to divisionToUpdate used to updated customer record.
     */

    public void OnDivisionSelect(ActionEvent actionEvent) {


try {
    Division selectedDivision = (Division) divisionCombo.getValue();
    divisionToUpdate = selectedDivision.getId();

}catch (Exception e) {
}
    }


    /**
     * Methods updates customer record while in customer update mode. After successful update, program returns to add customer mode.
     *
     */
    public void OnSaveCustomer(ActionEvent actionEvent) {
        CustomerDao customer= new CustomerDao();

        Customer customerToUpdate = new Customer(0, null, null, null, null, null, null, null, null, 0, null);

        if (customerNameForm.getText().equals("") ||
                customerAddressForm.getText().equals("")||
                customerPostalForm.getText().equals("")||
                customerPhoneForm.getText().equals("")

        ) {
            InfoBox("Error", "Form contains empty fields");
        } else {


            customerToUpdate.setDivision(divisionToUpdate);
            customerToUpdate.setName(customerNameForm.getText());
            customerToUpdate.setAddress(customerAddressForm.getText());
            customerToUpdate.setPostal(customerPostalForm.getText());
            customerToUpdate.setPhone(customerPhoneForm.getText());
            customerToUpdate.setUpdatedBy(currentUser.getName());
            customer.updateCustomer(customerID, customerToUpdate);
            customerTable.getItems().clear();
            customerTable.setItems(customer.getAllCustomers());
            AddCustomerMode();
            customerCombo.setItems(customer.getAllCustomers());
            customerNameForm.clear();
            customerAddressForm.clear();
            customerPostalForm.clear();
            customerPhoneForm.clear();
            divisionCombo.getSelectionModel().clearSelection();
            countryCombo.getSelectionModel().clearSelection();
            customerIDForm.clear();


        }




    }

    /**
     * Method hides add, update, and delete buttons, while shows save and back buttons in the customer form.
     */
    public void UpdateCustomerMode(){

        saveCustomerButton.setVisible(true);
        backCustomerButton.setVisible(true);
        deleteCustomerButton.setVisible(false);
        addCustomerButton.setVisible(false);
        updateCustomerButton.setVisible(false);


    }

    /**
     * Method hides save and back buttons, while shows add, update, and delete buttons in the customer form.
     */
    public void AddCustomerMode(){
        customerTable.getSelectionModel().clearSelection();
        customerNameForm.clear();
        customerAddressForm.clear();
        customerPostalForm.clear();
        customerPhoneForm.clear();
        customerIDForm.clear();
        countryCombo.getSelectionModel().clearSelection();
        divisionCombo.getSelectionModel().clearSelection();
        saveCustomerButton.setVisible(false);
        backCustomerButton.setVisible(false);
        deleteCustomerButton.setVisible(true);
        addCustomerButton.setVisible(true);
        updateCustomerButton.setVisible(true);





    }

    /**
     * Method hides add, update, and delete buttons, while shows save and back buttons in the appointment form.
     */
    public void UpdateAppointmentMode(){
    deleteAppointmentButton.setVisible(false);
    addAppointmentButton.setVisible(false);
    updateAppointmentButton.setVisible(false);
    backAppointmentButton.setVisible(true);
    saveAppointmentButton.setVisible(true);
    }

    /**
     * Method hides save and back buttons, while shows add, update, and delete buttons in the appointment form.
     */
    public void AddAppointmentMode(){
        titleAppointmentForm.clear();
        descriptionAppointmentForm.clear();
        locationAppointmentForm.clear();
        typeAppointmentForm.clear();
        startAppointmentForm.setValue(LocalDate.now());
        startHourForm.getSelectionModel().clearAndSelect(7);
        startMinuteForm.getSelectionModel().select(0);
        startMinute2Form.getSelectionModel().select(0);
        startAMPMForm.getSelectionModel().select(0);
        endAppointmentForm.setValue(LocalDate.now());
        endHourForm.getSelectionModel().select(7);
        endMinuteForm.getSelectionModel().select(1);
        EndMinute2Form.getSelectionModel().select(5);
        endAMPMForm.getSelectionModel().select(0);
        appointmentIDForm.clear();
        deleteAppointmentButton.setVisible(true);
        addAppointmentButton.setVisible(true);
        updateAppointmentButton.setVisible(true);
        backAppointmentButton.setVisible(false);
        saveAppointmentButton.setVisible(false);

    }

    /**
     *
     * Deletes customer record.
     */
    public void OnCustomerDelete(ActionEvent actionEvent) {
        CustomerDao customer= new CustomerDao();


        try {
            Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();
            customerID = selectedCustomer.getId();

            if (ConfirmBox("Warning", "Are You sure you want to permanently delete "+selectedCustomer.getName()+"?")){

                if(customer.hasAppointments(customerID)){
                    InfoBox("Error","Unable to delete customer while they have scheduled appointments.");
                }else {
                    customer.removeCustomer(customerID);
                    customerTable.getItems().clear();
                    customerTable.setItems(customer.getAllCustomers());
                    customerCombo.setItems(customer.getAllCustomers());

                    InfoBox("Info", "Record deleted");
                }
        }
        }catch (Exception e){
            InfoBox("Error", "No record selected");
        }
    }

    /**
     *Adds appointment record based on values input in appointment form.
     */
    public void OnAddAppointment(ActionEvent actionEvent) throws ParseException {

        Contact selectedContact= (Contact) contactCombo.getValue();
        Customer selectedCustomer= (Customer) customerCombo.getValue();

        Appointment newAppointment = new Appointment(0,null,null,null,null,null,null,null,null,null,null,0,0,0,null);



        try {


            newAppointment.setTitle(titleAppointmentForm.getText());
            newAppointment.setDescription(descriptionAppointmentForm.getText());
            newAppointment.setLocation(locationAppointmentForm.getText());
            newAppointment.setType(typeAppointmentForm.getText());
            newAppointment.setStart(DateToUTC(startAppointmentForm.getValue(), startHourForm.getValue(), startMinuteForm.getValue(), startMinute2Form.getValue(), startAMPMForm.getValue()));
            newAppointment.setEnd(DateToUTC(endAppointmentForm.getValue(), endHourForm.getValue(), endMinuteForm.getValue(), EndMinute2Form.getValue(), endAMPMForm.getValue()));
            newAppointment.setContact(selectedContact.getId());
            newAppointment.setCustomer(selectedCustomer.getId());
            newAppointment.setUser(currentUser.getId());
            newAppointment.setUpdatedBy(currentUser.getName());
            newAppointment.setCreatedBy(currentUser.getName());


            if (DateValidation(newAppointment.getStart(), newAppointment.getEnd())) {
                if (DateOverlap(newAppointment.getStart(), newAppointment.getEnd())) {

                    InfoBox("Error", "Schedule overlaps another appointment\nAdjust date and time accordingly.");

                } else {

                    appointment.addAppointment(newAppointment);
                    AppointmentTableSet();
                    titleAppointmentForm.clear();
                    descriptionAppointmentForm.clear();
                    locationAppointmentForm.clear();
                    typeAppointmentForm.clear();
                    startAppointmentForm.setValue(LocalDate.now());
                    startHourForm.getSelectionModel().clearAndSelect(7);
                    startMinuteForm.getSelectionModel().select(0);
                    startMinute2Form.getSelectionModel().select(0);
                    startAMPMForm.getSelectionModel().select(0);
                    endAppointmentForm.setValue(LocalDate.now());
                    endHourForm.getSelectionModel().select(7);
                    endMinuteForm.getSelectionModel().select(1);
                    EndMinute2Form.getSelectionModel().select(5);
                    endAMPMForm.getSelectionModel().select(0);
                    appointmentIDForm.clear();

                }
            }
        } catch (Exception e){
            InfoBox("Error", "Form contains empty fields");


        }


    }

    /**
     * Local date and time input from form is converted into a UTC date and time stamp ready to be stored in database.
     * @param date Local date selected from datepicker
     * @param hour Hour selected from combobox
     * @param min First digit of minute from combobox
     * @param min2 Second digit of minute from combobox
     * @param ampm AM/PM from combobox
     * @return UTC date and time in yyyy-MM-dd HH:mm:ss format.
     * @throws ParseException
     */
    public String DateToUTC(LocalDate date, Object hour, Object min, Object min2, Object ampm) throws ParseException {

        SimpleDateFormat formFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        String dateString = date+" "+hour+":"+min+min2+" "+ampm;
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String convertedDate = sqlFormat.format(formFormat.parse(dateString));

        return convertedDate;
    }

    /**
     * Converts SQL UTC date and time format to local date.
     * @param datetime UTC date and time stamp in yyyy-MM-dd HH:mm:ss format
     * @return LocalDate value
     * @throws ParseException
     */
    public LocalDate UTCtoLocalDate(String datetime) throws ParseException {
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat formFormat = new SimpleDateFormat("yyyy-MM-dd");
        //formFormat.setTimeZone(TimeZone.);

        return LocalDate.parse(formFormat.format(sqlFormat.parse(datetime)));

    }

    /**
     * Checks start and end date and time against records in a databased for any overlaps.
     * @param start UTC Date and time format
     * @param end UTC date and time format
     * @return true if overlap is found.
     */
    public boolean DateOverlap (String start, String end){
        ZonedDateTime startInput = LocalDateTime.parse(start,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));
        ZonedDateTime endInput = LocalDateTime.parse(end,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));

       for(Appointment dates: appointment.getAllAppointments()){
           ZonedDateTime startDate = LocalDateTime.parse(dates.getStart(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));
           ZonedDateTime endDate = LocalDateTime.parse(dates.getEnd(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));


           if (startInput.isBefore(startDate) && endInput.isBefore(startDate) || startInput.isAfter(endDate) && endInput.isAfter(endDate)){


           }else{
               return true;
           }


       }

        return false;
    }

    /**
     *
     * @param start UTC Date and time format
     * @param end UTC date and time format
     * @return true if data is valid
     * @throws ParseException
     */
    public boolean DateValidation(String start, String end) throws ParseException {
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat validateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       validateFormat.setTimeZone(TimeZone.getTimeZone("EST"));

        ZonedDateTime startTest = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));
        ZonedDateTime endTest = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("UTC"));

        ZonedDateTime openHours = LocalDateTime.parse(dateFormat.format(sqlFormat.parse(start))+" 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("EST", ZoneId.SHORT_IDS));
        ZonedDateTime closeHours = LocalDateTime.parse(dateFormat.format(sqlFormat.parse(start))+" 22:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("EST", ZoneId.SHORT_IDS));



       if (startTest.isBefore(openHours)||endTest.isAfter(closeHours)){
           InfoBox("Error","Appointment range is outside business hours.\n 8:00 AM to 10:00 PM EST");
           return false;
       }else if(endTest.isBefore(startTest)||startTest.isEqual(endTest)){
           InfoBox("Error","Invalid time range");

           return false;


        }else{

        return true;
    }

    }


    /**
     * Converts SQL date and time format to local time values.
     * @param datetime UTC Date and time format
     * @return A list of values that corresponds to the hour, first digit minute, second digit minute, and AM/PM combobox indices.
     * @throws ParseException
     */
    public ObservableList<Integer> UTCtoLocalTime(String datetime) throws ParseException {

        int ampmIndex=0;
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh");
        SimpleDateFormat minFormat = new SimpleDateFormat("mm");
        SimpleDateFormat ampmFormat = new SimpleDateFormat("a");

        int hour = Integer.parseInt(hourFormat.format(sqlFormat.parse(datetime)));
        String min = minFormat.format(sqlFormat.parse(datetime));
        String AMPM = ampmFormat.format(sqlFormat.parse(datetime));
       int min1= Integer.parseInt(String.valueOf(min.charAt(0)));
        int min2= Integer.parseInt(String.valueOf(min.charAt(1)));

        if (AMPM.equals("AM")){

            ampmIndex=0;

        }else{
            ampmIndex=1;
        }

        return FXCollections.observableArrayList(hour-1, min1, min2, ampmIndex);

    }


    /**
     * General purpose dialog box with just an Ok button.
     * @param title The title of the dialog box.
     * @param body The body of the dialog box.
     */
    public void InfoBox(String title, String body){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(body);
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();

    }

    /**
     * General purpose confirmation box with Yes and No buttons.
     * @param title The title of the confirmation box.
     * @param body The body of the confirmation box.
     * @return
     */
    public boolean ConfirmBox(String title, String body){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(body);
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult()==ButtonType.YES){
            return true;
        }else{
            return false;
        }

    }

    /**
     *
     * Method populates appointment form with selected appointment values.
     * @throws ParseException
     */
    public void OnUpdateAppointmentForm(ActionEvent actionEvent) throws ParseException {
        CustomerDao customer= new CustomerDao();

        Appointment selectedAppointment = (Appointment) appointmentTable.getSelectionModel().getSelectedItem();

        ObservableList<Integer> startTime = UTCtoLocalTime(selectedAppointment.getStart());
        ObservableList<Integer> endTime = UTCtoLocalTime(selectedAppointment.getEnd());


        titleAppointmentForm.setText(selectedAppointment.getTitle());
        descriptionAppointmentForm.setText(selectedAppointment.getDescription());
        locationAppointmentForm.setText(selectedAppointment.getLocation());
        startAppointmentForm.setValue(UTCtoLocalDate(selectedAppointment.getStart()));
       startHourForm.getSelectionModel().clearAndSelect(startTime.get(0));
        startMinuteForm.getSelectionModel().clearAndSelect(startTime.get(1));
        startMinute2Form.getSelectionModel().clearAndSelect(startTime.get(2));
        startAMPMForm.getSelectionModel().clearAndSelect(startTime.get(3));
        endAppointmentForm.setValue(UTCtoLocalDate(selectedAppointment.getEnd()));
        endHourForm.getSelectionModel().clearAndSelect(endTime.get(0));
        endMinuteForm.getSelectionModel().clearAndSelect(endTime.get(1));
        EndMinute2Form.getSelectionModel().clearAndSelect(endTime.get(2));
        endAMPMForm.getSelectionModel().clearAndSelect(endTime.get(3));
        typeAppointmentForm.setText(selectedAppointment.getType());
        contactCombo.getSelectionModel().select(selectedAppointment.getContactName());
        customerCombo.getSelectionModel().select(customer.getCustomer(selectedAppointment.getCustomer()).getName());
        contactToUpdate=selectedAppointment.getContact();
        customerToUpdate=selectedAppointment.getCustomer();
        appointmentIndex=selectedAppointment.getId();
        appointmentIDForm.setText(String.valueOf(selectedAppointment.getId()));
        UpdateAppointmentMode();

    }


    /**
     *
     * Method saves appointment record while in appointment update mode.
     * @throws ParseException
     */
    public void OnSaveAppointmentForm(ActionEvent actionEvent) throws ParseException {



        Appointment updateAppointment = new Appointment(0,null,null,null,null,null,null,null,null,null,null,0,0,0,null);


        if (titleAppointmentForm.getText().equals("")||
                descriptionAppointmentForm.getText().equals("")||
                locationAppointmentForm.getText().equals("")||
                typeAppointmentForm.getText().equals("")
        ){
            InfoBox("Error", "Form contains empty fields");
        }else{


        updateAppointment.setTitle(titleAppointmentForm.getText());
        updateAppointment.setDescription(descriptionAppointmentForm.getText());
        updateAppointment.setLocation(locationAppointmentForm.getText());
        updateAppointment.setType(typeAppointmentForm.getText());
        updateAppointment.setStart(DateToUTC(startAppointmentForm.getValue(),startHourForm.getValue(),startMinuteForm.getValue(),startMinute2Form.getValue(),startAMPMForm.getValue()));
        updateAppointment.setEnd(DateToUTC(endAppointmentForm.getValue(),endHourForm.getValue(),endMinuteForm.getValue(),EndMinute2Form.getValue(),endAMPMForm.getValue()));
        updateAppointment.setContact(contactToUpdate);
        updateAppointment.setCustomer(customerToUpdate);
        updateAppointment.setUpdatedBy(currentUser.getName());
        updateAppointment.setUser(currentUser.getId());

        if (DateValidation(updateAppointment.getStart(), updateAppointment.getEnd())) {

            appointment.updateAppointment(appointmentIndex, updateAppointment);
            AppointmentTableSet();
            AddAppointmentMode();
            titleAppointmentForm.clear();
            descriptionAppointmentForm.clear();
            locationAppointmentForm.clear();
            typeAppointmentForm.clear();
            startAppointmentForm.setValue(LocalDate.now());
            startHourForm.getSelectionModel().clearAndSelect(7);
            startMinuteForm.getSelectionModel().select(0);
            startMinute2Form.getSelectionModel().select(0);
            startAMPMForm.getSelectionModel().select(0);
            endAppointmentForm.setValue(LocalDate.now());
            endHourForm.getSelectionModel().select(7);
            endMinuteForm.getSelectionModel().select(1);
            EndMinute2Form.getSelectionModel().select(5);
            endAMPMForm.getSelectionModel().select(0);
            appointmentIDForm.clear();


        }}

    }

    /**
     * Called when a customer is selected in combobox. Assigns value to customerToUpdate for purpose of updating record.
     *
     */
    public void OnCustomerSelect(ActionEvent actionEvent) {

        try {
            Customer selectedCustomer = (Customer) customerCombo.getValue();
            customerToUpdate = selectedCustomer.getId();

        }catch (Exception e) {

        }
    }

    /**
     *
     * Called when a contact is selected in combobox. Assigns value to contactToUpdate for purpose of updating record.
     */

    public void OnContactSelect(ActionEvent actionEvent) {

        try {
            Contact selectedContact = (Contact) contactCombo.getValue();
            contactToUpdate = selectedContact.getId();
        }catch (Exception e){

        }


    }

    /**
     * Deletes selected appointment.
     */
    public void OnAppointmentDelete(ActionEvent actionEvent) {

        try {
            Appointment selectedAppointment = (Appointment) appointmentTable.getSelectionModel().getSelectedItem();

            if(ConfirmBox("Confirm Delete", "Are you sure you want to delete "+selectedAppointment.getTitle()+"?")){
                appointment.removeAppointment(selectedAppointment.getId());

                AppointmentTableSet();
                InfoBox("Info", "Appointment deleted!\nType: "+selectedAppointment.getType()+"\nAppointment ID: "+selectedAppointment.getId());
            }

        }catch (Exception e){

            InfoBox("Error", "No record selected");
        }

    }

    /**
     * This method sets Appointment Table view based on monthly, weekly, or view all filters.
     * @throws ParseException
     */
    public void AppointmentTableSet() throws ParseException {
        if (viewAllRadio.isSelected()) {
            onViewAll();
        }else if (monthViewRadio.isSelected()){
            onMonthFilter();
        }else{
            OnWeekFilter();
        }
    }

    /**
     * This method filters appointments by week.
     * @throws ParseException
     */
    public void OnWeekFilter() throws ParseException {
        LocalDate today = LocalDate.now();
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat plusWeek = new SimpleDateFormat("yyyy-MM-dd");
        appointmentTable.getItems().clear();
        appointmentTable.setItems(appointment.filterAppointments(""+plusWeek.format(input.parse(today.plusWeeks(1).toString()))+" 23:59:59"));


    }

    /**
     * This method filters appointments by month.
     * @throws ParseException
     */
    public void onMonthFilter() throws ParseException {
        LocalDate today = LocalDate.now();
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat yearMonth = new SimpleDateFormat("yyyy-MM");
        appointmentTable.getItems().clear();
        appointmentTable.setItems(appointment.filterAppointments(""+yearMonth.format(input.parse(today.toString()))+"-"+today.lengthOfMonth()+" 23:59:59"));

    }

    /**
     * This method removes any appointment filters.
     */

    public void onViewAll() {
        appointmentTable.getItems().clear();
        appointmentTable.setItems(appointment.getAllAppointments());
    }


    /**
     * This methods generates a report that displays appointment counts by type. A lambda expression is used to loop between appointments to create a TreeMap.
     *
     */
    public void OnTypeReport(ActionEvent actionEvent) {
        Map<String, Integer> typeList = new TreeMap<>();

        ObservableList<Appointment> report = appointment.getAllAppointments();

        report.forEach(r->{




            try {
                String type = r.getType();

                if (typeList.get(type)==null){
                    typeList.put(type, 1);
                } else{
                    typeList.put(type, typeList.get(type)+1);
                }

            } catch (Exception e) {
            }




        });


        StringBuilder out= new StringBuilder();
        for(Map.Entry<String, Integer> x: typeList.entrySet()){

            out.append(x.getKey()).append(": ").append(x.getValue()).append("\n");

        }

        InfoBox("Appointment Count by Type", out.toString());


    }
    /**
     * This methods generates a report that displays appointment counts by Month. A lambda expression is used to loop between appointments to create a TreeMap.
     *
     */
    public void OnMonthReport(ActionEvent actionEvent) {


        Map<String, Integer> monthList = new TreeMap<>();

        AppointmentDao appReport = new AppointmentDao();

        List<Appointment> report =  appReport.getAllAppointments();
        Collections.sort(report, (o1,o2)->{

            LocalDate d1 = LocalDate.parse(o1.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDate d2 = LocalDate.parse(o2.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


            return d1.compareTo(d2);

        });

        report.forEach(r->{


            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat f= new SimpleDateFormat("yyyy MMMMM");

            try {
                LocalDate appMonth = UTCtoLocalDate(r.getStart());
                String keyDate = f.format(input.parse(appMonth.toString()));

                if (monthList.get(keyDate)==null){
                    monthList.put(keyDate, 1);
                } else{
                    monthList.put(keyDate, monthList.get(keyDate)+1);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }




        });



        StringBuilder out= new StringBuilder();
        for(Map.Entry<String, Integer> x: monthList.entrySet()){

            out.append(x.getKey()).append(": ").append(x.getValue()).append("\n");

        }

        InfoBox("Appointment Count by Month", out.toString());

    }

    /**
     * This method generates a report that displays the schedule for each contact.  A lambda expression is used to loop between appointments to create a TreeMap.
     *
     * @throws ParseException
     */

    public void OnContactReport(ActionEvent actionEvent) throws ParseException {
        ContactDAO conReport = new ContactDAO();
        AppointmentDao appReport = new AppointmentDao();

        List<Appointment> report =  appReport.getAllAppointments();

        Collections.sort(report, (o1,o2)->{

            LocalDate d1 = LocalDate.parse(o1.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDate d2 = LocalDate.parse(o2.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


            return d1.compareTo(d2);

        });
        Map<Integer, ObservableList<Appointment>> contactList=new TreeMap<>();
        report.forEach(r->{
            if (contactList.get(r.getContact())==null) {
                contactList.put(r.getContact(), FXCollections.observableArrayList());
                contactList.get(r.getContact()).add(r);
            }else {
                contactList.get(r.getContact()).add(r);
            }

        });
        StringBuilder out = new StringBuilder();

        for(Map.Entry<Integer, ObservableList<Appointment>> m: contactList.entrySet()){

            out.append(conReport.getContactName(m.getKey())+"\n");
            for (Appointment l: m.getValue()){
                out.append(l.getId()+" | ").append(l.getTitle()+" | ")
                        .append(l.getDescription()+" | ")
                        .append(l.getType()+" | ")
                        .append(UTCtoLocalDate(l.getStart())+" | ")
                        .append(hour.get(UTCtoLocalTime(l.getStart()).get(0))+":")
                        .append(tenMinute.get(UTCtoLocalTime(l.getStart()).get(1)))
                        .append(minute.get(UTCtoLocalTime(l.getStart()).get(2))+" ")
                        .append(AMPM.get(UTCtoLocalTime(l.getStart()).get(3))+"\n");

            }

        }
        InfoBox("Appointments by Contact", out.toString());



    }

    /**
     * This method generates a report that displays the schedule for each customer.  A lambda expression is used to loop between appointments to create a TreeMap.
     * @throws ParseException
     */

    public void OnCustomerReport(ActionEvent actionEvent) throws ParseException {
        CustomerDao custReport = new CustomerDao();
        AppointmentDao appReport = new AppointmentDao();

        List<Appointment> report =  appReport.getAllAppointments();

        Collections.sort(report, (o1,o2)->{

            LocalDate d1 = LocalDate.parse(o1.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDate d2 = LocalDate.parse(o2.getStart(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


            return d1.compareTo(d2);

        });
        Map<Integer, ObservableList<Appointment>> customerList=new TreeMap<>();
    report.forEach(r->{
        if (customerList.get(r.getCustomer())==null) {
            customerList.put(r.getCustomer(), FXCollections.observableArrayList());
            customerList.get(r.getCustomer()).add(r);
        }else {
            customerList.get(r.getCustomer()).add(r);
        }

    });
    StringBuilder out = new StringBuilder();

    for(Map.Entry<Integer, ObservableList<Appointment>> m: customerList.entrySet()){

        out.append(custReport.getCustomer(m.getKey()).getName()+"\n");
        for (Appointment l: m.getValue()){
            out.append(l.getId()+" | ").append(l.getTitle()+" | ")
                    .append(l.getDescription()+" | ")
                    .append(l.getType()+" | ")
                    .append(UTCtoLocalDate(l.getStart())+" | ")
                    .append(hour.get(UTCtoLocalTime(l.getStart()).get(0))+":")
                    .append(tenMinute.get(UTCtoLocalTime(l.getStart()).get(1)))
                    .append(minute.get(UTCtoLocalTime(l.getStart()).get(2))+" ")
                    .append(AMPM.get(UTCtoLocalTime(l.getStart()).get(3))+"\n");

        }

    }
    InfoBox("Appointments by Customer", out.toString());


    }
}

