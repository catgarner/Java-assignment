import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class strongestMatch 
{
	private HashMap<File, Integer> match;
	
	public strongestMatch(HashMap<File, Integer> match)
	{
		this.match = new HashMap<File, Integer>();
		
		System.out.println("Before Sorting:");
		// Get a set of the entries
	      Set matchSet = match.entrySet();
	      
	      // Get an iterator
	      Iterator i = matchSet.iterator();
	      
	      // Display elements
	      while(i.hasNext()) 
	      {
	         Map.Entry matchMap = (Map.Entry)i.next();
	         System.out.print(matchMap.getKey() + ": ");
	         System.out.println(matchMap.getValue());
	      }
	      
	      Map<Integer, String> map = sortByValues(match); 
	      System.out.println("After Sorting:");
	      Set set2 = map.entrySet();
	      Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) 
	      {
	           Map.Entry me2 = (Map.Entry)iterator2.next();
	           System.out.print(me2.getKey() + ": ");
	           System.out.println(me2.getValue());
	      }
	}

	private static HashMap sortByValues(HashMap map) 
	{ 
		LinkedList list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() 
		{
			public int compare(Object o1, Object o2)
            {
            	return ((Comparable) ((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
            }
		});
	   // Here I am copying the sorted list in HashMap
	   // using LinkedHashMap to preserve the insertion order
	   HashMap sortedHashMap = new LinkedHashMap();
	   for (Iterator it = list.iterator(); it.hasNext();) 
	   {
		   Map.Entry entry = (Map.Entry) it.next();
		   sortedHashMap.put(entry.getKey(), entry.getValue());
	   } 
	   return sortedHashMap;
	}
}
