package dec19;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {

		 Set<String> cities = new LinkedHashSet<>();  // The order of insertion is kept
	        
	        cities.add("Washington DC");
	        cities.add("Atlanta");
	        cities.add("Moscow");
	        cities.add("Minsk");
	        cities.add("Kyiv");
	        cities.add("Istanbul");
	        cities.add("Washington DC");
	        cities.add("Atlanta");
	        cities.add("Moscow");
	        cities.add("Minsk");
	        cities.add("Tashkent");
	        
	        
	        System.out.println(cities);
	        
//	      ArrayList<String> list = new ArrayList<String>(cities);
//	      System.out.println(list.get(list.size()-2));
	        
	        
	        
	        
	        Iterator<String> iterator = cities.iterator();
	        
//	      while (iterator.hasNext()) {         // retrieving the element based on its values
//	          String city = iterator.next();
//	          
//	          if(city.equals("Kyiv")) {
//	              System.out.println(city);
//	          }
//	          
//	      }
	        
	        int i;              // rertieve the index of an element with value "Kyiv"
	        
	        for ( i = 0; i < cities.size(); i++) {  
	            
	            if(iterator.next().equals("Kyiv")) {
	                break;
	            }
	            
	        }
	        
	        System.out.println(i);


			cities.add(null);
			
			System.out.println(cities);
	}

}
