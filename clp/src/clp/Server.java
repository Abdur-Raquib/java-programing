package clp;


import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	int count=1;
	public static void main(String args[]) throws IOException {
		Server sv = new Server();
		int c = sv.count;
		DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date();
		ServerSocket handshake = new ServerSocket(6969);
		while (true) {
			Socket com_socket = handshake.accept();
			System.out.println("Client " +c+" connected at " + com_socket.getLocalPort()+" "+fortime.format(date));
			DataOutputStream dos = new DataOutputStream(com_socket.getOutputStream());
			DataInputStream dis = new DataInputStream(com_socket.getInputStream());
			Thread new_tunnel = new Handler(com_socket, dis, dos);
			new_tunnel.start();
			c++;

		}
	}
}

