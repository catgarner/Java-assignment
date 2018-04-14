import java.io.File;
import java.util.Scanner;

public class WordCounter 
{
	//Create input stream and scanner
	private File newfile;
	private Scanner myScanner;
	
	private String word;
	private int count = 0;
	
	public WordCounter(File newfile, String word)
	{
		
	}
	
	public void scanFile(File newfile, String word)
	{
		try
		{
			myScanner = new Scanner(newfile);
			
			while(myScanner.hasNext())
			{
				//Get the next word
				String nextWord = myScanner.next();
				
				//Determine if word is in ArrayList
				if(nextWord.contains(word))
				{
					count++;
					
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		
		
		System.out.println(word + " occured " + count);
	}
}
