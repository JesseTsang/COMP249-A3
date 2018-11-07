import java.io.File;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Jesse
 *
 */
public class BibCreator 
{
	public static final String directoryPath = "\\Resources";
	
	//ArrayList<File> bibFiles;
	File[] bibFiles;
	
	ArrayList<Entry> bibEntries;
	
	/**
	 * Constructor
	 */
	public BibCreator()
	{
		//do stuff
	}
	
	/**
	 * This will read a directory and generate an array of File objects for further process.
	 * 
	 * @param directoryPath
	 * @return
	 */
	public File[] readDirectory(String directoryPath)
	{
		System.out.println("directoryPath is: " + directoryPath);
		
		//bibFiles = new ArrayList<File>();
		
		File directory = new File(directoryPath);
		
		bibFiles = directory.listFiles();
		
		System.out.println("The directory [" + directoryPath + "] constains the following files:");
		
		for(File path: bibFiles)
		{
			System.out.println(path);
		}
		
		return bibFiles;		
	}
	
	/**
	 * Will read a .bib file and output all entries into Entry objects.
	 * 
	 * @param file
	 * @return
	 */
	public ArrayList<Entry> readBiB (File file)
	{
		bibEntries = new ArrayList<Entry>();
		
		return null;	
	}
	
	/**
	 * Check if an article is valid (no empty field)
	 * 
	 * @return boolean
	 */
	public boolean isValid(Entry entry)
	{
		return false;
	}
	
	/**
	 * Will create 3 versions of JSON files
	 * 	1. IEEE[x].json
	 * 	2. ACM[x].json
	 * 	3. NJ[x].json
	 * 
	 * @param entry
	 */
	public void fileCreator(Entry entry, int fileNumber)
	{
		//Do stuff		
	}

	/**
	 * Driver
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BibCreator test1 = new BibCreator();
		test1.readDirectory("C:\\Users\\Jesse\\eclipse-workspace\\COMP249-A3\\Resources");
	}
}
