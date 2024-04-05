package multiThreadingPractice1;

import java.net.*;
import java.io.*;

public class ClientHadler extends Thread{
	
	final Socket com_tunnel;
	final DataOutputStream dos_tunnel;
	final DataInputStream dis_tunnel;
	
	String recieve;
	String toReturn;
	
	public ClientHadler (Socket s, DataOutputStream dos, DataInputStream dis) {
		this.com_tunnel=s;
		this.dis_tunnel=dis;
		this.dos_tunnel=dos;
	}
	
	public void run() {
		while(true) {
			try {
				dos_tunnel.writeUTF("String: ");
				recieve = dis_tunnel.readUTF();
				if(recieve == "bye") {
					com_tunnel.close();
				}
				StringBuilder str = new StringBuilder("");
				str.append(recieve);
				str.reverse();
				recieve=str.toString();
				
				this.dis_tunnel.close();
				this.dos_tunnel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
