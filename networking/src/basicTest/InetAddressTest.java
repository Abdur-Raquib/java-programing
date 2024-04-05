package basicTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] a) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			address = InetAddress.getByName("google.com");
			System.out.println(address);
			InetAddress add[] = InetAddress.getAllByName("nab.com");
			for (int i=0; i<add.length; i++) {
				System.out.println(add[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
