import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private ArrayList<String> filenames;
	private File myfile;
	private ArrayList<String> words;
	private ArrayList<Integer> match;
	int count;
	
	
	public FileSearch(ArrayList<String> filenames, ArrayList<String> words)
	{
		this.filenames = new ArrayList<String>(filenames);
		this.words = new ArrayList<String>(words);

	}

	public void openFile(ArrayList<String> filenames, ArrayList<String> words)
	{
		match = new ArrayList<Integer>();
		for (int i = 0; i < filenames.size(); i++) 
		{
			System.out.println(filenames.get(i));
			myfile = new File(filenames.get(i));
			WordCounter counter = new WordCounter(myfile, words);
			count = counter.scanFile(myfile, words);
			match.add(count);
			
		}
		
		Collections.sort(match);
		for(int i = 0; i < match.size(); i++)
		{
			System.out.print("\n" + match.get(i));
		}
		
	}
	
	
		
}

