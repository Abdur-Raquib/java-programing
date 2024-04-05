package lab_2;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ClientHandler extends Thread {
	ServerThread st = new ServerThread();
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
	final Socket com_tunnel;

	final DataInputStream dis_tunnel;
	final DataOutputStream dos_tunnel;
	String received = "";
	String toreturn = "";

	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
		this.com_tunnel = s;
		this.dis_tunnel = dis;
		this.dos_tunnel = dos;

	}

	public void run() {
		while (true) {
			try {
				dos_tunnel.writeUTF("Enter two number separated by comma: ");
				received = dis_tunnel.readUTF();
				if (received.equals("Exit")) {
					System.out.println("Connection terminated with client " + st.count);
					this.com_tunnel.close();
					break;
				}
				
				else {
					String[] numbers = received.split(",");
		            int a = Integer.parseInt(numbers[0]);
		            int b = Integer.parseInt(numbers[1]);
		            int result = gcd(a, b);
		            toreturn = String.valueOf(result);
		            dos_tunnel.writeUTF(toreturn);
				}

			} catch (IOException ex) {
				Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE,

						null, ex);

			}
		}
		try {
			this.dos_tunnel.close();
			this.dis_tunnel.close();
		} catch (IOException ex) {
			Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE,

					null, ex);

		}
	}
	public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
