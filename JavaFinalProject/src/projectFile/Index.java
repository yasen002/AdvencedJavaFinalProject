
package projectFile;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ya
 */
public class Index extends Application {
    private boolean isServer;
    private Client client;    
    private Server server;
    public static String address ="localhost";    
    public static int port = 8080;


    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //to launch the server, set isServer to true
        isServer = false;
        
        if(!isServer){//create client
            //Start client UI
            FXMLLoader loader = new FXMLLoader(Index.class.getResource("Login.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
            client = new Client(address, port);
            client.start();
//            

            
        }else{//create server
            
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


