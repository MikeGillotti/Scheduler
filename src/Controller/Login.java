package Controller;

import DAO.UserDao;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 * @author Mike Gillotti
 * Controller for login screen.
 */
public class Login implements Initializable {
    /**
     * static field for login user.
     */
    public static User currentUser = new User (0, null, null);
    /**
     * Button for login
     */
    @FXML
    private Button loginButton;
    /**
     * Text that displays local time zone
     */
    @FXML
    private Label timeZoneLabel;
    /**
     * Input for user password
     */
    @FXML
    private PasswordField passwordForm;
    /**
     * Input for username
     */
    @FXML
    private TextField usernameForm;
    /**
     * Time zone label
     */
    @FXML
    private Label timezonetitleLabel;
    /**
     * Username label
     */
    @FXML
    private Label usernameLabel;
    /**
     * Password label
     */
    @FXML
    private Label passwordLabel;
    /**
     * French locale object.
     */
    private Locale french = new Locale("fr");
    /**
     * Filewriter that logs activity
     */
    private FileWriter logger;
    /**
     * Formats datetime to specified format.
     */
    private DateTimeFormatter outFormat=  DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

    /**
     *
     * Method is called when login screen loads. If system language is French, labels, dialog, and buttons display text in French.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        timeZoneLabel.setText(ZoneId.systemDefault().getId());

        if (Locale.getDefault().getLanguage()==french.getLanguage()) {
        timezonetitleLabel.setText("Fuseau horaire:");
        usernameLabel.setText("Nom d'utilisateur");
        passwordLabel.setText("Mot de passe");
        loginButton.setText("Connexion");

        }

    }


    /**
     *
     * This method checks username and password against the database, and if it matches, the mainscreen is loaded.
     * Lambda expression is used to loop through users to get logged in user data.
     * @throws IOException
     */
    public void OnLogin(javafx.event.ActionEvent event) throws IOException {

        UserDao users = new UserDao();

        logger= new FileWriter("login_activity.txt", true);





        if (users.passwordAccepted(usernameForm.getText(), passwordForm.getText())) {

            logger.write("\nLogin Successful | User: "+usernameForm.getText()+" | Timestamp: "+ outFormat.format(LocalDateTime.now())+" "+ZoneId.systemDefault().getId());
            logger.close();

            users.getAllUsers().forEach((u)->{if (u.getName().equals(usernameForm.getText())){

                currentUser.setName(u.getName());
                currentUser.setId(u.getId());
                currentUser.setPassword(u.getPassword());

            }
            });
            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/MainScreen.fxml")));

            primaryStage.setTitle("Scheduler");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }
        else
        {


            logger.write("\nLogin Failed | Username attempted: "+usernameForm.getText()+" | Timestamp: "+ outFormat.format(LocalDateTime.now())+" "+ZoneId.systemDefault().getId());
            logger.close();


            if (Locale.getDefault().getLanguage()==french.getLanguage()) {
                InfoBox("Erreur", "Nom d'utilisateur ou mot de passe invalide");

            }else{
            InfoBox("Error", "Invalid Username or Password");
        }}



}

    /**
     * General purpose dialog box.
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



}
