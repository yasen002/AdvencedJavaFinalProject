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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Ya
 */


public class LoginController extends Utilities implements Initializable {


    @FXML
    private VBox wrapperVBOX;
    @FXML
    private AnchorPane LoginAnchorPane;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button LogInBtn;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws IOException, SQLException {
        //validate login info
            //if info is valid
             Window displayer = LogInBtn.getScene().getWindow();
        System.out.println(usernameField.getText());
        System.out.println(passwordField.getText());

        if (usernameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, displayer, "LogIn Error!",
                "Please enter your Username");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, displayer, "LogIn Error!",
                "Please enter a password");
            return;
        }
        
        //get user info from UI
        String userName = usernameField.getText();
        String password = passwordField.getText();

        
        JDBCFXLogIn jdbc = new JDBCFXLogIn();
        boolean flag = jdbc.validate(userName, password);
        
        if (!flag) {
            infoBox("Please enter correct Username and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Failed");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            LoginAnchorPane.getChildren().setAll(pane);
        }
        
    }

    @FXML
    private void handleCreateAccount(MouseEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        LoginAnchorPane.getChildren().setAll(pane2);
    }
    
}
