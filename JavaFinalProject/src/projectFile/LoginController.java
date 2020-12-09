/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectFile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ya
 */


public class LoginController implements Initializable {


    @FXML
    private VBox wrapperVBOX;
    @FXML
    private AnchorPane LoginAnchorPane;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        //validate login info
            //if info is valid
            
                //send request to the server
                // this is the part where i don't under stand. how do i send information to the server?
                
                //load home page
                AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                LoginAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleCreateAccount(MouseEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        LoginAnchorPane.getChildren().setAll(pane2);
    }
    
}
