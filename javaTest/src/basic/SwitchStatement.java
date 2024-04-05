package basic;

import java.util.Scanner;

public class SwitchStatement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		switch(a) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
			
		default:
			System.out.println(a);
		}

	}

}
