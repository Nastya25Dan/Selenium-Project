package dec19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetExercise {

	public static void main(String [] args )throws FileNotFoundException {
		
		// Read all the names from the text file
		// And display all non-duplicate names in an ascending order

		File myObj = new File("names.txt");

		Scanner sc = new Scanner(myObj);
		Set<String> names = new TreeSet<>();

		int count = 0;
		while (sc.hasNextLine()) {
			if (!names.add(sc.nextLine())) {
				count++;
			}
		}

		for (String string : names) {
			System.out.println(string);
		}

		System.out.println("The number of duplicate names is" + count);
	}
}
