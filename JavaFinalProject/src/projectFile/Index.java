/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: This file contains the main(String[] args) function, which shows the stage and lauches a Client or Server with respect to the "isServer" flag
 */
package projectFile;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 *
 */
public class Index extends Application {
    
    //valiables
    private boolean isServer;//to launch the server, set isServer to true
    private Client client;    
    private Server server;
    // address and port which the Client and Server will connect to
    public static String address ="localhost";    
    public static int port = 8080;


    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //to launch the server, set isServer to true
        isServer = false;
        
        if(!isServer){//create client
            //Start client and client UI
            FXMLLoader loader = new FXMLLoader(Index.class.getResource("Login.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
            client = new Client(address, port);
            client.start();      
        }else{//create server and server UI
            FXMLLoader loader = new FXMLLoader(Index.class.getResource("ServerSide.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
            server = new Server(port);
            server.start();   
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}


