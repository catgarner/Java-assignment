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
		this.filenames = new ArrayList<String>(filenames);
		this.words = new ArrayList<String>(words);

	}

	public void openFile(ArrayList<String> filenames, ArrayList<String> words)
	{
		match = new HashMap<File, Integer>();
		for (int i = 0; i < filenames.size(); i++) 
		{
			System.out.println(filenames.get(i));
			myfile = new File(filenames.get(i));
			WordCounter counter = new WordCounter(myfile, words);
			count = counter.scanFile(myfile, words);
			//match.add(count);
			match.put(myfile, count);
			
		}
		
		strongestMatch strongest = new strongestMatch(match);
		
		
	}
		
}
	  

