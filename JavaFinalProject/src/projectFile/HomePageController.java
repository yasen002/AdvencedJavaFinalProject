/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: This files contains all the controller for CreateAccount.fxml 
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
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 */
public class HomePageController implements Initializable {

    @FXML
    private AnchorPane HomePageAnchorPane;
    @FXML
    private VBox mainContainerVbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    
    /**
     * Description: This controller is triggered when User clicks "Sandwiches" button from HomePage.fxml
     */
    @FXML
    private void handleSandwichesMenu(MouseEvent event) throws IOException {
        //nevigate to sandwiches menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Sandwiches.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }

    /**
     * Description: This controller is triggered when User clicks "Meals" button from HomePage.fxml
     */
    @FXML
    private void handleMealsMenu(MouseEvent event) throws IOException {
        //nevigate to meals menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Meals.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }
    
    
    /**
     * Description: This controller is triggered when User clicks "Dessert" button from HomePage.fxml
     */
    @FXML
    private void handleDessertMenu(MouseEvent event) throws IOException {
        //nevigate to dessert menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Dessert.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }

    /**
     * Description: This controller is triggered when User clicks "Drinks" button from HomePage.fxml
     */
    @FXML
    private void handleDrinksMenu(MouseEvent event) throws IOException {
        //nevigate to drink menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Drinks.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
        
    }

    /**
     * Description: This controller is triggered when User clicks "log out" button from HomePage.fxml
     */
    @FXML
    private void handleLogout(MouseEvent event) throws IOException {
        //nevigate to longin page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        HomePageAnchorPane.getChildren().setAll(pane);
    }

    /**
     * Description: This controller is triggered when User clicks "my order" button from HomePage.fxml
     */
    @FXML
    private void handleMyOrders(MouseEvent event) {
    }

    /**
     * Description: This controller is triggered when User clicks "main menu" button from HomePage.fxml
     */
    @FXML
    private void handleMainMenu(MouseEvent event) throws IOException {
        //nevigate to longin page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        HomePageAnchorPane.getChildren().setAll(pane);
    }
}
