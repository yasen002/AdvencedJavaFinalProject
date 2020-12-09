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
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author Ya
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

    @FXML
    private void handleSandwichesMenu(MouseEvent event) throws IOException {
        //nevigate to sandwiches menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Sandwiches.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }

    @FXML
    private void handleMealsMenu(MouseEvent event) throws IOException {
        //nevigate to meals menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Meals.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }

    @FXML
    private void handleDessertMenu(MouseEvent event) throws IOException {
        //nevigate to dessert menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Dessert.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
    }

    @FXML
    private void handleDrinksMenu(MouseEvent event) throws IOException {
        //nevigate to drink menu
        VBox vbox = FXMLLoader.load(getClass().getResource("menu/Drinks.fxml"));
        mainContainerVbox.getChildren().setAll(vbox);
        
    }

    @FXML
    private void handleLogout(MouseEvent event) throws IOException {
        //nevigate to longin page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        HomePageAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void handleMyOrders(MouseEvent event) {
    }

    @FXML
    private void handleMainMenu(MouseEvent event) throws IOException {
        //nevigate to longin page
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        HomePageAnchorPane.getChildren().setAll(pane);
    }
}

//create account validation 
//login validation
//