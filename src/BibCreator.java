import java.io.File;

/**
 * 
 */

/**
 * @author Jesse
 *
 */
public class BibCreator 
{
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
		
		return null;		
	}
	
	/**
	 * Will read a .bib file and output all entries into Entry objects.
	 * 
	 * @param file
	 * @return
	 */
	public Entry[] readBiB (File file)
	{
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
		// TODO Auto-generated method stub

	}

}
