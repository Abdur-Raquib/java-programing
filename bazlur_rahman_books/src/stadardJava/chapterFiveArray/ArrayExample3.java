package stadardJava.chapterFiveArray;

import java.util.Scanner;

public class ArrayExample3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Array size: ");
		int sizeOfArray = sc.nextInt();
		
		int[] myArray = new int[sizeOfArray];
		for(int i=0; i<myArray.length; i++) {
			myArray[i] = sc.nextInt();
		}
		
		System.out.println("index\tvalue");
		for(int i=0; i<myArray.length; i++) {
			System.out.println(i+"\t"+myArray[i]);
		}
	}
}
