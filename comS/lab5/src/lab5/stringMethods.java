package lab5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class stringMethods {
	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U');
	
	public static void main(String args[]) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println(initals("Edna del Humboldt von der Schooch"));
		System.out.println(findFirstVowel("sdfghjkkU"));
	}
	
	public static String initals(String name) {
		String initals = "";
		
		String[] names = name.split(" ");
		
		for(int i = 0; i < names.length; i++) {
			initals += names[i].charAt(0);
		}
		
		return initals;
	}
	
	public static String findFirstVowel(String inString) {
		int index = -1;
		
		for(int i = 0; i < inString.length(); i++) {
			if(vowels.contains(inString.charAt(i))) {
				index = i;
				break;
			}
			
//			if(inString.indexOf(i) >= 0) {
//				index = i;
//				break;
//			}
		}
		
		return index + " " + inString.charAt(index);
	}
}
