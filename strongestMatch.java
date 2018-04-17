import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class strongestMatch implements Comparable
{
	private HashMap<File, Integer> match;
	
	/*
	 * This method takes in the hash map match and the string word from the main screen class. The sort method
	 * is called on the match hash map. This will then print out the 
	 * sorted hash map using an iterator. 
	 */
	public void strongestMatch(HashMap<File, Integer> match, String word)
	{

		this.match = new HashMap<File, Integer>();
	      
	      HashMap<File, Integer> match2 = sort(match); 
	      
	      System.out.println("\nStrongest-waekest match for the word \"" + word + "\":\n");
	      
	      Set matchSet = match2.entrySet();
	      Iterator j = matchSet.iterator();
	      while(j.hasNext())
	      {
	           Map.Entry matchMap = (Map.Entry)j.next();
	           System.out.print(matchMap.getKey() + ": ");
	           System.out.println(matchMap.getValue());
	      }
	      
	}

	/*
	 * This method takes in a hash map from the strongest match class. It then uses the collections class
	 * and the compare method to sort the hash map by the integer value. It sorts it from the highest number 
	 * to the lowest number. This is showing which file contains the strongest match to the search word. 
	 * The sorted hash map is then returned back to the strongest match method.
	 */
	private static HashMap sort(HashMap<File, Integer> match2)
	{ 
		LinkedList<?> list = new LinkedList(match2.entrySet());
		
		Collections.sort(list, new Comparator<Object>() 
		{
			public int compare(Object lower, Object higher)
		    {
		    	return ((Comparable)((Map.Entry)(higher)).getValue()).compareTo(((Map.Entry)(lower)).getValue());
		    }
		});
	   
	   HashMap sortedHashMap = new LinkedHashMap();
	   for (Iterator it = list.iterator(); it.hasNext();) 
	   {
		   Map.Entry entry = (Map.Entry) it.next();
		   sortedHashMap.put(entry.getKey(), entry.getValue());
	   } 
	   return sortedHashMap;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
