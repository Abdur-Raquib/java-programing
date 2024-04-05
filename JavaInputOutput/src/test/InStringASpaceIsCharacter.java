package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InStringASpaceIsCharacter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = new String[2];
		str = br.readLine().split(" ");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		
		System.out.print(x+" "+ y);
	}

}
