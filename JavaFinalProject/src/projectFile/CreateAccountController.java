/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * Create button handle
     */
    @FXML
    private void handleNewAccount(MouseEvent event) throws IOException, SQLException {
        // TODO
        //1.validate new user information
        
//         Window displayer = createAccBtn.getScene().getWindow();
//        if (firstnameField.getText().isEmpty()||lastnameField.getText().isEmpty() || emailField.getText().isEmpty()||usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, displayer, "LogIn Error!",
//                "Please Enter all the datas");
//            return;
//        }
//        
//        String firstName = firstnameField.getText();
//        String lastName = lastnameField.getText();
//        String email = emailField.getText();
//        String userName = usernameField.getText();
//        String password = passwordField.getText();
//
//        JDBCFXCreateAcc jdbcCacc = new JDBCFXCreateAcc();
//        boolean flag = jdbcCacc.validate(userName);
//
//        if (!flag) {
//            infoBox(" Username exists", null, "Failed");
//        } else {
//            jdbcCacc.InsertToDb(firstName,lastName,email,userName,password);
//            infoBox("Account created Successfully!", null, "Failed");
//        }


        
        //2.if new info is valid, navigate to homepage
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        CreateAccountAnchorPane.getChildren().setAll(pane);
        System.out.println(event);
    }
    
}
