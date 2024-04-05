package multiThreadingPractice1;

import java.io.IOException;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		try {
			Socket soc = new Socket("localhost",6087);
			System.out.print("client connected to port: "+soc.getLocalPort());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
