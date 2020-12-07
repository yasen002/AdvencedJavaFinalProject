/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectFile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ya
 */
public class CreateAccountController implements Initializable {

    @FXML
    private AnchorPane CreateAccountAnchorPane;

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
    private void handleNewAccount(MouseEvent event) throws IOException {
        // TODO
        //1.validate new user information
        
        //2.if new info is valid, navigate to homepage
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        CreateAccountAnchorPane.getChildren().setAll(pane);
        System.out.println(event);
    }
    
}
