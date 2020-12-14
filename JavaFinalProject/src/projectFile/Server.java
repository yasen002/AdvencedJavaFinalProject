/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: Server.java creates a server which will connect to the "port" specified
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
 */
public class Server extends Thread {
    private int port;
    
    @Override
    public void run() {
    try (ServerSocket server = new ServerSocket(port)) {
			System.out.println("Server Description:  This server will reverse back the client input.");
			System.out.println("Connection Status:   server started, waiting for connection...");
			Socket socket = server.accept();
			
			// in & out
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			System.out.println("Connection Status:   connection established...");
			
			String line;
			while ((line = in.readLine()) != null) {
			System.out.println("Server Received:     " + line);
                                
                                StringBuilder input1 = new StringBuilder();

                                // append a string into StringBuilder input1
                                input1.append(line);

                                // reverse StringBuilder input1
                                input1 = input1.reverse();

                                // send reversed String
				out.println(input1);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Connection Status:   server terminating...");
  }

    public Server( int port){
        this.port = port;
    }

}
