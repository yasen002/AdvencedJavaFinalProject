/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ya
 */
public class Server {
    private Socket socket;     
    private ServerSocket server; 
    private BufferedReader in;
    private PrintWriter out;

    public Server( int port) throws IOException {
        
        try{
            server = new ServerSocket(port);
            System.out.println("server started");

            socket = server.accept();
            System.out.println("Client accepted");
             in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             out = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ((line = in.readLine()) != null) {
                    System.out.println("received: " + line);

                    out.println("echo from server: " + line + "888");
            }
        }catch(IOException i ){
            System.out.println(i);
        }
        
        
    }
    
//    //handles client request
//    public void clientRequestHandller(String requestString) throws IOException{
//        //send request to server
//        
//        try{
//          //Here converting string to inputstream and pass it to DataInputStream
//      InputStream stream = new ByteArrayInputStream(requestString.getBytes());
//      input = new DataInputStream(stream);
//      out = new DataOutputStream(socket.getOutputStream());
//        
//        }catch(IOException i){
//        System.out.println(i);
//      }
//        
//    }
}
