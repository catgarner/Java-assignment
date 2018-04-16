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
	

	public HashMap<File, Integer> strongestMatch(HashMap<File, Integer> match)
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
	      
	      HashMap<File, Integer> match2 = sortByValues(match); 
	      System.out.println("After Sorting:");
	      Set matchSet2 = match2.entrySet();
	      Iterator j = matchSet2.iterator();
	      while(j.hasNext()) 
	      {
	           Map.Entry matchMap2 = (Map.Entry)j.next();
	           System.out.print(matchMap2.getKey() + ": ");
	           System.out.println(matchMap2.getValue());
	      }
	      
	      return match;
	}

	private static HashMap sortByValues(HashMap<File, Integer> match2) 
	{ 
		LinkedList list = new LinkedList(match2.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() 
		{
			public int compare(Object lower, Object higher)
            {
            	return ((Comparable) ((Map.Entry)(higher)).getValue()).compareTo(((Map.Entry)(lower)).getValue());
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
