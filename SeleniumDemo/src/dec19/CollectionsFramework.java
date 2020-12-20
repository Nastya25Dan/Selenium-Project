package dec19;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsFramework {

	public static void main(String[] args) {


		
		List <Integer> prices = Arrays.asList(34,22,11);
		
		Collections.sort(prices);
		Collections.reverse(prices);
		
		System.out.println(prices);
		
		Iterator<Integer> iterator2 = prices.iterator();
		
//		while(iterator2.hasNext()) {
//			System.out.println(iterator2.next());
//		}

		
		//if there is no index and we need to get the 3rd element
		iterator2.next();
		iterator2.next();
		Integer num = iterator2.next();
		
		System.out.println(num);
		
	}

}
