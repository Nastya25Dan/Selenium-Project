package dec19;

import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TreeSetDemo {

	public static void main(String[] args) {

		Set<Integer> ids = new TreeSet<>();// The elements are sorted as they are added to the set
		
		ids.add(34);
		ids.add(779);
		ids.add(12);
		ids.add(33);
		
		ids.add(999);
		ids.add(122);
		ids.add(777);
		ids.add(25);
		
		System.out.println(ids);
		

	}

}
