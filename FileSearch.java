import java.io.File;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private File[] filenames;
	private File[] myfile;
	Scanner myScanner;
	String line = "Couldn't read the file";
	
	public void openFile(File[] filenames)
	{
		myfile = new File;
	}
	
	public FileSearch(String filename)
	{
		this.filenames = filenames;

	}
	
	
	public String scanFile()
	{
		try
		{
			myScanner = new Scanner(myfile);
			line = myScanner.nextLine();
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		
		return line;
		
	}

}
