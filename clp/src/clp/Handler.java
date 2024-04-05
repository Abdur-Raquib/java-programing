package clp;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Handler extends Thread {
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	Date date = new Date();
	final Socket com_tunnel;

	final DataInputStream dis_tunnel;
	final DataOutputStream dos_tunnel;
	String received = "";
	String toreturn = "";
	Server sv = new Server();
	
	public Handler(Socket s, DataInputStream dis, DataOutputStream dos) {
		this.com_tunnel = s;
		this.dis_tunnel = dis;
		this.dos_tunnel = dos;

	}

	public void run() {
		while (true) {
			try {
				dos_tunnel.writeUTF("Enter your input: ");
				received = dis_tunnel.readUTF();
				if (received.equals("bye")) {
					System.out.println("Client " + sv.count+" leaves the port at " + fortime.format(date));
					this.com_tunnel.close();
					break;
				}
				else {
					int in = Integer.parseInt(received);
					int s = in*in;
					toreturn = String.valueOf(s);
					dos_tunnel.writeUTF(toreturn);
				}

			} catch (IOException ex) {
				Logger.getLogger(Handler.class.getName()).log(Level.SEVERE,

						null, ex);

			}
		}
		try {
			this.dos_tunnel.close();
			this.dis_tunnel.close();
		} catch (IOException ex) {
			Logger.getLogger(Handler.class.getName()).log(Level.SEVERE,

					null, ex);

		}
	}
}

