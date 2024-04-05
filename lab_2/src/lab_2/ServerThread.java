package lab_2;

import java.io.*;
import java.net.*;

public class ServerThread {
	int count=1;
	public static void main(String args[]) throws IOException {
		ServerThread st = new ServerThread();
		ServerSocket handshake = new ServerSocket(5000);
		while (true) {
			Socket com_socket = handshake.accept();
			DataOutputStream dos = new DataOutputStream(com_socket.getOutputStream());
			DataInputStream dis = new DataInputStream(com_socket.getInputStream());
			Thread new_tunnel = new ClientHandler(com_socket, dis, dos);
			new_tunnel.start();
			st.count++;

		}
	}
}
