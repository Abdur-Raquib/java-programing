package clp;

import java.io.*;
import java.net.*;

import java.util.*;

public class Client {
	public static void main(String args[]) throws IOException {
		try {
			Socket clientsocket = new Socket("localhost", 6969);
			Scanner scn = new Scanner(System.in);
			DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
			DataInputStream dis = new DataInputStream(clientsocket.getInputStream());
			while (true) {
				String inLine = dis.readUTF();
				System.out.println(inLine);
				String outLine = scn.nextLine();
				dos.writeUTF(outLine);

				if (outLine.equals("bye")) {
					clientsocket.close();
					break;
				}
				String received = dis.readUTF();
				int i = Integer.parseInt(received);
				System.out.println(i);
			}
			dos.close();
			dis.close();
			clientsocket.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
