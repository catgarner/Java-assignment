import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordCounter 
{
	//Create input stream and scanner
	private File newfile;
	private Scanner myScanner;
	
	private ArrayList<String> words;
	Integer count = 0;
	
	
	ArrayList<String> punct = new ArrayList<String>
	(Arrays.asList(",", ".", "\"", ";", ":", "+", "&", "?", "!", "*", "'", "(", ")", "/", "=", "[", "]", "_", "-"));
	
	public WordCounter(File newfile, ArrayList<String> words)
	{
		
	}
	
	public Integer scanFile(File newfile, ArrayList<String> words)
	{
		try
		{
			myScanner = new Scanner(newfile);
			
			while(myScanner.hasNext())
			{
				//Get the next word
				String nextWord = myScanner.next();
				
				//Strip punctuation
				for(int i = 0; i < punct.size(); i++)
				{
					if(nextWord.contains(punct.get(i)))
					{
						nextWord = nextWord.replace(punct.get(i), "");
					}
				}
				
				for(int i = 0; i < words.size(); i++)
				{
					if(nextWord.equalsIgnoreCase(words.get(i)))
					{
						count++;
						
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		
		System.out.println(" occured " + count + " time(s)");
		return count;
	}	
	
}
