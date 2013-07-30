package edu.neumont.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: seanyerg
 * Date: 7/26/13
 * Time: 6:15 PM
 */
public class Client {
	public static void main(String[] args) {
		new Client().run();
	}

	public void run() {
		try {
			Socket socket = new Socket("localhost", 8080);
			PrintWriter writer = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));

			writer.write("GET http://localhost:8080/catering/restaurant HTTP/1.1\n\n");
			writer.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
