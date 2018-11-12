import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public static final String DIRECTORY_PATH = "C:\\Users\\Jesse\\eclipse-workspace\\COMP249-A3\\Resources";
	public static final String DELIMITER = "@ARTICLE{";
	
	//ArrayList<File> bibFiles;
	File[] bibFiles;
	
	ArrayList<Article> bibEntries;
	
	/**
	 * Constructor
	 */
	public BibCreator()
	{
		//do stuff
	}
	
	/**
	 * 
	 */
	public void startProcess()
	{
		bibFiles = readDirectory(DIRECTORY_PATH);
		
		//File bibFile;
		
		//Each file would be 1 bib file ... which contain multiple articles
		for(File path: bibFiles)
		{
			if(isValidFileType(path))
			{
				System.out.println("File name: " + path);
				System.out.println("Reading bib file ...");
				
				bibEntries = readBib(path);
			}
			
			
			
		}
		
	}
	
	private boolean isValidFileType(File path)
	{
		String[] tokens = path.getName().split("\\.");
		String fileType = tokens[1];

		if(fileType.equals("bib"))
		{
			return true;
		}
		else
		{
			System.out.println("Invalid file type - Will not process this file: " + path);
		}
		
		return false;
	}

	/**
	 * This will read a directory and generate an array of File objects for further process.
	 * 
	 * @param directoryPath
	 * @return
	 */
	public File[] readDirectory(String directoryPath)
	{
		//System.out.println("directoryPath is: " + directoryPath);
		
		//bibFiles = new ArrayList<File>();
		
		File directory = new File(directoryPath);
		
		bibFiles = directory.listFiles();
		
		/*System.out.println("The directory [" + directoryPath + "] contains the following files:");
		
		for(File path: bibFiles)
		{
			System.out.println(path);
		}*/
		
		return bibFiles;		
	}
	
	/**
	 * Will read a .bib file and output all the articles into Entry objects.
	 * 
	 * @param file
	 * @return
	 */
	public ArrayList<Article> readBib (File file)
	{
		ArrayList<Article> result = new ArrayList<Article>();
		ArrayList<String> articleItem = new ArrayList<String>();
		
		FileReader fileReader;
		
		try
		{
			fileReader = new FileReader(file);
			
			BufferedReader in = new BufferedReader(fileReader);
			
			String fileLine;
			String articleString = "";
			
			System.out.println("Article starts ------------------");
			
			while((fileLine = in.readLine()) != null)
			{				
				//System.out.println(articleString);
				
				if(fileLine.startsWith("}"))
				{
					//Add last line of each article "{"
					articleString = articleString + fileLine;
					
					//Add the article to the arrayList
					articleItem.add(articleString);
					
					//Test purpose
					System.out.println("Article done!");
					System.out.println(articleString);
					
					//Reset the article chunk string
					articleString = "";
									
				}
				else
				{
					//If the line is not the last line ("{" symbol) then just concatenate the string
					articleString = articleString + fileLine;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Article end ------------------");
		
		return result;	
	}
	
	/**
	 * Check if an article is valid (no empty field)
	 * 
	 * @return boolean
	 */
	public boolean isValid(Article entry)
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
	public void fileCreator(Article entry, int fileNumber)
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
		test1.startProcess();
	}
}
