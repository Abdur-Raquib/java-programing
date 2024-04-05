package stadardJava.chapterFiveArray;

import java.util.Scanner;

public class LetterCount {
	/*
	 * problem definition: Take some character as input from user and count which letter comes how many times.
	 *  
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter character: ");
		String inputValue = sc.nextLine();
		inputValue = inputValue.toLowerCase();
		char[] letters = inputValue.toCharArray();
		
		int[] counts = new int[26];
		
		for(int i=0; i<letters.length; i++) {
			char letter = letters[i];
			if(Character.isLetter(letter)) {
				int index = letter - 'a';
				counts[index]++;
			}
		}
		
		for(int i=0; i<counts.length; i++) {
			if(counts[i]!=0) {
				char letter = (char)(i+'a');
				System.out.println(letter + ": " + counts[i]);
			}
		}
	}
}
