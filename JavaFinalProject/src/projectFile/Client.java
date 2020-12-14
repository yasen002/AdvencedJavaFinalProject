/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: Client.java creates a client which will connect to the "address" and "port" specified
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
import java.util.Scanner;

/**
 *
 * @author Ya
 */

public class Client extends Thread {
    private String address;
    private int port;
    
    @Override
    public void run(){
        try (Socket socket = new Socket(address, port); Scanner scanner = new Scanner(System.in)) {

			// in & out
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String line;
			do {
				System.out.println("Enter: ");
				line = scanner.nextLine();
				out.println(line);

				String response = in.readLine();
				System.out.println("Server response: " + response);
			} while (!line.equalsIgnoreCase("bye"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }

    public Client(String address, int port) throws IOException {
        this.address = address;
        this.port = port;
    }
    

}
