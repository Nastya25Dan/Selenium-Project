package homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Assignment3 {
	
	// Write a method that will remove all duplicates from string
	// removeDuplicateChars("abcc"); -> "abc". Use Set Interface.

	public static String removeDuplicateChars(String str) {
		//implementation goes here 

		Set<Character> ch = new HashSet<>();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(!ch.contains(c)) {
				ch.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/*
	 * Write a method to remove duplicates from array in Java, without using
	 * Collection classes e.g. Set or ArrayList. Algorithm for this method is
	 * simple, it first sorts the array and then compares adjacent objects, leaving
	 * out duplicates, which is already in the result.
	 */
	public static int[] removeDuplicates(int[] numbersWithDuplicates) {
		// implementation goes here 
		
		
//	    int[] myArray = {1, 2, 1, 4, 1, 5, 2, 5};
//	    System.out.println("Before removing duplicate" + Arrays.toString(myArray));
//
//	    RemoveDuplicateFromArray rd = new RemoveDuplicateFromArray();
//	    int[] newArray = rd.findDuplicate(myArray);
//	    System.out.println("Before removing duplicate" + Arrays.toString(newArray));
//	}

//	public int[] findDuplicate(int[] inputArray) {
	    Arrays.sort(numbersWithDuplicates);
	    int count = 0;
	    for (int i = 0; i < numbersWithDuplicates.length; i++) {
	        if (i + 1 < numbersWithDuplicates.length && numbersWithDuplicates[i] == numbersWithDuplicates[i + 1]) {
	            count++;
	        }
	    }
	    int[] result = new int[numbersWithDuplicates.length - count];
	    int c = 0;
	    for (int j = 0; j < numbersWithDuplicates.length; j++) {
	        if (j + 1 < numbersWithDuplicates.length && numbersWithDuplicates[j] == numbersWithDuplicates[j + 1]) {

	        } else {
	            result[c] = numbersWithDuplicates[j];
	            c++;
	        }
	    }
	    numbersWithDuplicates = result;
	    return numbersWithDuplicates;
	

	}

	
	
	
	public static void main(String [] args) {
		
		
		System.out.println(removeDuplicateChars("abcdeeaf"));
		

		
	}

}