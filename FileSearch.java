import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FileSearch 
{
	
	
	private ArrayList<String> filenames;
	private File myfile;
	private ArrayList<String> words;
	private HashMap<File, Integer> match;
	int count;
	
	
	public FileSearch(ArrayList<String> filenames, ArrayList<String> words)
	{
		//Instantiating the array lists that were sent in by the main screen class.
		this.filenames = new ArrayList<String>(filenames);
		this.words = new ArrayList<String>(words);

	}

	/*
	 * This method adds the first filename in the filenames array list into a file variable. This 
	 * variable and the words hash map are sent into the scan file method in the word counter class.
	 * There is a return variable of an integer. The file name and the count variable that is returned 
	 * from the scan file method are put into the match hash map. This continues until all the filenames
	 * in the filenames array list are accounted for. The match hash map is then returned to the main 
	 * screen class.
	 */
	public HashMap<File, Integer> openFile(ArrayList<String> filenames, ArrayList<String> words)
	{
		match = new HashMap<File, Integer>();
		for (int i = 0; i < filenames.size(); i++) 
		{
			myfile = new File(filenames.get(i));
			WordCounter counter = new WordCounter(myfile, words);
			count = counter.scanFile(myfile, words);
			match.put(myfile, count);
			
		}

		return match;
	}
		
}
	  

