package exam2_tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class problems {
	
	public static String blankVowels(String str) {
//		ArrayList<Character> vowels = new ArrayList<Character>();
//		vowels.add('a');
//		vowels.add('e');
//		vowels.add('i');
//		vowels.add('o');
//		vowels.add('u');
//		
//		char[] word = str.toCharArray();
//		
//		for(int i = 0; i < word.length; i++) {
//			if(vowels.contains(word[i])) {
//				word[i] = '_';
//			}
//		}
//			
//		return new String(word);
		
		String newString = "";
		for(int i = 0; i <str.length(); i++) {
			char C = str.charAt(i);
			if(C == 'a' || C == 'e' || C == 'i' || C == 'o' || C == 'u') {
				C = '_';
			}
			newString += C;
		}
		
		return newString;
	}
	
	public static int[] removeDuplicates(int[] duppsArr) {
		ArrayList<Integer> noDuppsList = new ArrayList<Integer>();
		
		
		for(int i = 0; i < duppsArr.length; i++) {
			if(!noDuppsList.contains(duppsArr[i])) {
				noDuppsList.add(duppsArr[i]);
			}
		}
		
		int[] noDuppsArr = new int[noDuppsList.size()];
		
		for(int j = 0; j < noDuppsList.size(); j++) {
			noDuppsArr[j] = noDuppsList.get(j);
		}
		
		return noDuppsArr;
		
	}
	
	public static HashMap<Integer, Integer> removeDups(int[] duppsArr) {
		HashMap<Integer, Integer> noDups = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < duppsArr.length; i++) {
			noDups.put(duppsArr[i], i);
		}
		
		return noDups;
		
	}
	
//	public static ArrayList<String> readPalidromes(String filename) throws FileNotFoundException {
//		ArrayList<String> palidromeList = new ArrayList<String>();
//			
//		File file = new File(filename);
//		try {
//			Scanner scnr = new Scanner(file);
//			while(scnr.hasNext()) {
//				String word = scnr.next();
////				if(isPalidrome(word)) {
////					palidromeList.add(word);
////				}
//			}
//		} catch (FileNotFoundException e) {
//			return palidromeList;
//		}
//		
//	}
	
	public static int[][] rightShifts(int[] arr) {
		int[][] shiftTable = new int[arr.length][arr.length];
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++ ) {
				shiftTable[i][j] = arr[j - i];
						
			}
		}
		
		return shiftTable;
	}
	
	public static void main(String args[]) {
		int[] duppsList = {5, 4, 5, 6, 4, 2};
		int[] noDuppsArr = removeDuplicates(duppsList);
		
//		HashMap<Integer, Integer> noDups = removeDups(duppsList);
		
//		System.out.println(blankVowels("volume"));
		
//		for(int i = 0; i < noDuppsArr.length; i++) {
//			System.out.print(noDuppsArr[i] + " ");
//		}
		
//		for(int i : noDups.keySet()) {
//			System.out.print(i + " ");
//		}
		
		int[] nums = {1, 2, 4, 8};
		
		for(int[] i : rightShifts(nums)) {
			for(int j : i) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
}