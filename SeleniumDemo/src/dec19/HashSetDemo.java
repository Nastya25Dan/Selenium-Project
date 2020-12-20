package dec19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {

		Set <Long> accountNumbers = new HashSet<>(); // The order of insertion is not kept
		
		accountNumbers.add(182738495832L);
		accountNumbers.add(764635232832L);
		accountNumbers.add(293847327838L);
		accountNumbers.add(304435390394L);
		accountNumbers.add(438928717182L);
		System.out.println(accountNumbers.add(976542390394L));//true
		System.out.println(accountNumbers.add(304435390394L));//false doesn't allow duplicates
		
		//Internally HashSet uses hashCode() method to retrieve unique of each object 
		//to check if an item exists in the collection
		
		System.out.println(accountNumbers);
		
		Set<Long> accountNumber2 = new HashSet<>(accountNumbers);
		
		System.out.println(accountNumber2);
		
		List<Long> prices = new ArrayList<>();
		prices.add(22L);
		prices.add(33L);
		prices.add(11L);
		prices.add(11L);
		prices.add(22L);
		
		System.out.println(prices);
		
		Set <Long> numbers = new HashSet<>(prices);
		
		System.out.println(numbers);
		
		prices.add(null);
		prices.add(null);
		
		
		System.out.println(prices);

	}

}
