import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private ArrayList<String> filenames;
	private File myfile;
	private String word;
	
	public FileSearch(ArrayList<String> filenames, String word)
	{
		this.filenames = new ArrayList<String>(filenames);

	}

	public void openFile(ArrayList<String> filenames, String word)
	{
		System.out.println(word);
		for (int i = 0; i < filenames.size(); i++) 
		{
			System.out.println(filenames.get(i));
			myfile = new File(filenames.get(i));
			WordCounter counter = new WordCounter(myfile, word);
			counter.scanFile(myfile, word);
		}
	}
	
	
		
}

