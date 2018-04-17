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
	
	//Array list to hold punctuation.
	ArrayList<String> punct = new ArrayList<String>
	(Arrays.asList(",", ".", "!", "?", "'", ";", ":", "+", "&", "=", "*", "(", ")", "/", "\"", "[", "]", "_", "-"));
	
	public WordCounter(File newfile, ArrayList<String> words)
	{
		words = new ArrayList<String>();
	}
	
	public Integer scanFile(File newfile, ArrayList<String> words)
	{
		try
		{
			myScanner = new Scanner(newfile);
			
			while(myScanner.hasNext())
			{
				//Getting the next word from the file and putting it into a string variable.
				String nextWord = myScanner.next();
				
				/*
				 * For loop to get the next word from the file, if it contains any punctuation
				 * from the punctuation array list then the word is stripped from the word.
				 */
				for(int i = 0; i < punct.size(); i++)
				{
					if(nextWord.contains(punct.get(i)))
					{
						nextWord = nextWord.replace(punct.get(i), "");
					}
				}
				
				/*
				 * This for loop goes through all of the words in the words array list and 
				 * checks if the next word is the same as any of the words in the array list.
				 * It ignores the case so that words that contain capital letters do not count.
				 */
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
		
		//Returns the variable count to the file search class.
		return count;
	}	
	
}
