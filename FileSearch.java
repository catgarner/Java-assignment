import java.io.File;
import java.util.Scanner;

public class FileSearch 
{
	
	
	private String filenames;
	Scanner myScanner;
	String line = "Couldn't read the file";
	
	
	
	public void openFile(String filenames)
	{
		//myfile = new File;
	}
	
	public FileSearch(String filenames)
	{
		this.setFilenames(filenames);

	}
	
	public String toString()
	{
		return ("\nThe list contains " + getFilenames() );
		
	}
	
	
	public String scanFile()
	{
		try
		{
			//myScanner = new Scanner(myfile);
			line = myScanner.nextLine();
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		
		return line;
		
}

	private String getFilenames() {
		return filenames;
	}

	private void setFilenames(String filenames) {
		this.filenames = filenames;
	}
	

}
