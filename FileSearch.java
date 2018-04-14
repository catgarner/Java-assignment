import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private ArrayList<String> filenames;
	private File myfile;
	private ArrayList<String> words;
	
	
	public FileSearch(ArrayList<String> filenames, ArrayList<String> words)
	{
		this.filenames = new ArrayList<String>(filenames);
		this.words = new ArrayList<String>(words);

	}

	public void openFile(ArrayList<String> filenames, ArrayList<String> words)
	{
		for (int i = 0; i < filenames.size(); i++) 
		{
			System.out.println(filenames.get(i));
			myfile = new File(filenames.get(i));
			WordCounter counter = new WordCounter(myfile, words);
			int count = counter.scanFile(myfile, words);
			System.out.println(count);
		}
		
	}
	
	
		
}

