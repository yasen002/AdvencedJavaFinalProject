
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
    private String request;

    
    public void clientRequest(String request) throws IOException{
        try{
            if(request == "i")
                this.client.sendRequest(request);
        }catch(IOException i){
            System.out.println(i);
        }
    }
    
    
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
            client = new Client("localhost", 8080);
            
        }else{//create server
            
            server = new Server(8080);
            FXMLLoader loader = new FXMLLoader(Index.class.getResource("ServerSide.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
