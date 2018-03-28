import java.io.File;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private String filename;
	private File myfile;
	Scanner myScanner;
	String line = "Couldn't read the file";
	
	public void openFile(String filename)
	{
		myfile = new File(filename);
	}
	
	public FileSearch(String filename)
	{
		this.filename = filename;

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
