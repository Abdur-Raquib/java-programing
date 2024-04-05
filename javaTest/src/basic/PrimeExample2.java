package basic;

import java.util.Scanner;

public class PrimeExample2 {
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int flag =0;
		for(int i=0; i<=b; i++) {
			if(i==0 || i==1) {flag=1;}
			else {
				for(int j=2; j<=Math.sqrt(i); j++) {
					if(i%j==0) {flag =1;break;}
					
				}
				
			}
			if(flag==0) {
				System.out.print(i + " ");
			}
			flag=0;
		}
	}
}
