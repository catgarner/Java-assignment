import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private ArrayList<String> filenames;
	private Scanner myScanner;
	private File myfile;
	String line = "Couldn't read the file";
	
	
	
	public void openFile()
	{
		for (int i = 0; i < 1; i++) 
		{
			System.out.println(filenames.get(i));
			myfile = new File(filenames.get(i));
			System.out.println(myfile);
		}
	}
	
	public FileSearch(ArrayList<String> choosenFiles)
	{
		this.filenames = new ArrayList<String>(filenames);

	}
	/*public String scanFile()
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
	*/
		
}

