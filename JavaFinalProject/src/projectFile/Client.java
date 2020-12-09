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
import java.net.Socket;

/**
 *
 * @author Ya
 */

public class Client {
    private Socket socket;
    
    // in & out
    public BufferedReader input;
    public PrintWriter out;

    public Client(String address, int port) throws IOException {
        
        try{
            socket = new Socket(address, port);
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        
            System.out.println("Client connettion");
            
        }catch(IOException i ){
            System.out.println(i);
        }
        
        
    }
    
    //handles client request
    public void sendRequest(String requestString) throws IOException{
        //Here converting string to inputstream and pass it to DataInputStream
        InputStream stream = new ByteArrayInputStream(requestString.getBytes());
        this.out.println(stream);
    }
}
