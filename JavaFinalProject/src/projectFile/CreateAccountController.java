/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: This file contains all the controller for CreateAccount.fxml. 
 */
package projectFile;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Ya
 */
public class CreateAccountController extends Utilities implements Initializable  {
    //Private Variables
    @FXML
    private AnchorPane CreateAccountAnchorPane;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button createAccBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
     /**
     * Method description:  This method is triggered upon the click of "Create" button from CreatAccount.fxml
     */
    @FXML
    private void handleNewAccount(MouseEvent event) throws IOException, SQLException {
      
        //1.validate new user information
         Window displayer = createAccBtn.getScene().getWindow();
        if (firstnameField.getText().isEmpty()||lastnameField.getText().isEmpty() || emailField.getText().isEmpty()||usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, displayer, "LogIn Error!",
                "Please Enter all the datas");
            return;
        }
        
        //get user info from UI
        String firstName = firstnameField.getText();
        String lastName = lastnameField.getText();
        String email = emailField.getText();
        String userName = usernameField.getText();
        String password = passwordField.getText();

        JDBCFXCreateAcc jdbcCacc = new JDBCFXCreateAcc();
        boolean flag = jdbcCacc.validate(userName);
        
        //Check the flag and respond 
        if (!flag) {
            infoBox(" Username exists", null, "Failed");
            
        } else { //2.if new info is valid, navigate to homepage
            jdbcCacc.InsertToDb(firstName,lastName,email,userName,password);
            infoBox("Account created Successfully!", null, "Success");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            CreateAccountAnchorPane.getChildren().setAll(pane);
        }
    }
}
