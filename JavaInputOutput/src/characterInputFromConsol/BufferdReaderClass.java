package characterInputFromConsol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferdReaderClass {

	public static void main(String[] args) throws IOException{
		int x,y;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = br.read();
		br.read(); // this is for space character
		y = br.read();
		System.out.print(x+" "+ y);
	}

}
