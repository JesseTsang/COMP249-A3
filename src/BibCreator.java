import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jesse
 *
 */
public class BibCreator 
{
	public static final String DIRECTORY_PATH = "C:\\Users\\Jesse\\eclipse-workspace\\COMP249-A3\\Resources";
	public static final String ARTICLE_END_SYMBOL = "}";
	
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
	 * @throws FileInvalidException 
	 * 
	 */
	public void startProcess()
	{
		bibFiles = readDirectory(DIRECTORY_PATH);
			
		//Each file would be 1 bib file ... which contain multiple articles
		for(File path: bibFiles)
		{
			//1. Check if the file is of "bib" file type
			if(isValidFileType(path))
			{
				System.out.println("File name: " + path);
				System.out.println("Reading bib file ...");
							
				//2. Read the bib file ... output ArrayList<Article>
				try
				{
					bibEntries = readBib(path); //ArrayList of Article objects
				}
				catch (FileInvalidException e)
				{
					//Continue the loop even if we catch an exception
					//Checked exceptions (runtime exceptions)
					continue;
				}
			}//end if clause
			
			//3. Process the ArrayList<Article> bibEntries and output JSON documents.
		}	
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
	 * Helper function to weed out non bib files.
	 * 
	 * @param path
	 * @return
	 */
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
	 * Will read a .bib file and output all the articles into Entry objects.
	 * 
	 * @param file
	 * @return
	 * @throws FileInvalidException 
	 */
	public ArrayList<Article> readBib (File file) throws FileInvalidException
	{
		ArrayList<Article> document = new ArrayList<Article>();
		ArrayList<String> articlesStrings = new ArrayList<String>();
		
		FileReader fileReader;
		
		try
		{
			fileReader = new FileReader(file);
			
			BufferedReader in = new BufferedReader(fileReader);
			
			String fileLine;
	
			//System.out.println("Article starts ------------------");
			
			while((fileLine = in.readLine()) != null)
			{
				//Remove all the empty lines
				if(fileLine.equals(""))
				{
					continue;					
				}
				
				//1. We check each line if they are a possible valid line in a bib file.
				//	It is not valid if there is only element, but no value on the element-value pairs.
				isValidArticle(file, fileLine);
							
				//After finish reading each article ...
				if(fileLine.startsWith(ARTICLE_END_SYMBOL))
				{
					//Pass the ArrayList<String> articlesStrings to create 1 Article object
					//	then, add the object to the ArrayList<Article> document 
					document.add(createArticle(articlesStrings));
													
					//Reset the article chunk string for next article
					articlesStrings = new ArrayList<String>();			
				}
				else
				{
					//If the line is not the last line ("{" symbol) then add the line to the ArrayList<String> articlesStrings
					articlesStrings.add(fileLine);
				}
			}//end while
			
			//So at this point ...
			//	1. We checked to make sure each line is valid
			// 	2. We have concatenated all the valid line (for each article) to String articleString which represents 1 article.
			//	3. We will then loop ArrayList<String> articleStrings to create a Article objects ... and return the ArrayList<Article> document.
					
			in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
		//System.out.println("Article end ------------------");
		
		//Testing purpose
		/*for(Article art: document)
		{
			System.out.println("ID: " + art.getID().getValue());
			System.out.println("Title: " + art.getTitle().getValue());
		}*/
			
		return document;	
	}
	
	/**
	 * Helper function to create an ArrayList<Article>
	 * 
	 * @param articleString
	 * @return
	 */
	private Article createArticle(ArrayList<String> articlesStrings)
	{
		Article result = new Article();
		
		for(String str: articlesStrings)
		{		
			//1. Remove any extra white spaces
			str = str.trim();
			
			String subStr = "";
			
			if(str.startsWith("@ARTICLE{") || str.startsWith("}") || str.equals(""))
			{
				continue;			
			}
			
			//2.1 It's also valid if the line is ID
			//	The ID line has a format like [12345,], so we remove the last char and check if it's a number.
			if(!str.equals("}"))
			{
				subStr = str.substring(0, str.length()-1);
				
				if(isNumber(subStr))
				{
					String elementName = "ID";
					String IDvalue = subStr;
	
					Element ID = createElement(elementName, IDvalue);
					
					result.setID(ID);
					
					continue;
				}
			}
			
			//3. If it's not the above lines, then it must be a general line with element-value pair
			//	So, we split the line by two, using "=" as delimiter
			String[] elementTokens = subStr.split("=");
			
			String elementName = elementTokens[0];
			String value = elementTokens[1].substring(1, elementTokens[1].length()-1).trim();
								
			switch(elementName)
			{
				case "author":
					Element author = createElement(elementName, value);
					result.setAuthor(author);
					break;
				case "journal":
					Element journal = createElement(elementName, value);
					result.setAuthor(journal);
					break;
				case "title":
					Element title = createElement(elementName, value);
					result.setTitle(title);
					break;
				case "year":
					Element year = createElement(elementName, value);
					result.setYear(year);
					break;
				case "volume":
					Element volume = createElement(elementName, value);
					result.setVolume(volume);
					break;
				case "number":
					Element number = createElement(elementName, value);
					result.setNumber(number);
					break;
				case "pages":
					Element pages = createElement(elementName, value);
					result.setPages(pages);
					break;
				case "keywords":
					Element keywords = createElement(elementName, value);
					result.setKeywoards(keywords);
					break;
				case "doi":
					Element doi = createElement(elementName, value);
					result.setDoi(doi);
					break;
				case "ISSN":
					Element ISSN = createElement(elementName, value);
					result.setIssn(ISSN);
					break;
				case "month":
					Element month = createElement(elementName, value);
					result.setMonth(month);
					break;
				default:
					System.out.println("Missing element: " + elementName);
			}	
		}//end for loop
		
		return result;
	}

	/**
	 * Helper function to create an Element object
	 * 
	 * @param element
	 * @param value
	 * @return
	 */
	private Element createElement(String elementName, String elementValue)
	{	
		Element result = new Element(elementName, elementValue);
		
		return result;
	}

	/**
	 * We want to check if a line from any bib file is valid.
	 * 
	 * @param file
	 * @param articleString
	 * @return
	 * @throws FileInvalidException
	 */
	private boolean isValidArticle(File file, String articleString) throws FileInvalidException
	{
		//1. Remove any extra white spaces
		articleString = articleString.trim();
		
		String subStr = "";
	
		//2. It's valid if the line starts with the following:
		//	@ARTICLE{
		//	}
		//	"" (Empty space)
		if(articleString.startsWith("@ARTICLE{") || articleString.startsWith("}") || articleString.equals(""))
		{
			return true;			
		}
		
		//2.1 It's also valid if the line is ID
		//	The ID line has a format like [12345,], so we remove the last char and check if it's a number.
		if(!articleString.equals("}"))
		{
			subStr = articleString.substring(0, articleString.length()-1);
			
			if(isNumber(subStr))
			{
				return true;
			}
		}
		
		//3. If it's not the above lines, then it must be a general line with element-value pair
		//	So, we split the line by two, using "=" as delimiter
		String[] elementTokens = subStr.split("=");
		
		//4. We check if the value field is empty.
		//4.1 We extract the substring by removing the tailing comma
		String value = elementTokens[1].substring(1, elementTokens[1].length()-1);
		
		//4.2 If the value is "", that means the element has no value, thus invalid.
		if(value.equals(""))
		{
			System.out.println("Element: " + elementTokens[0] + " has empty value.");
			
			ErrorType errorType = getErrorType(elementTokens[0]);
			
			throw new FileInvalidException(file, errorType);
			
		}
		else
		{
			//Test purposes
			/*System.out.println("Element: " + elementTokens[0]);
			System.out.println("Value: " + value);*/	
		}
				
		return true;
	}

	/**
	 * Helper function to test if a String is a natural number.
	 * 
	 * @param string
	 * @return
	 */
	private boolean isNumber(String string)
	{
		try 
		{
			Integer.parseInt(string);
			
			return true;
		}
		catch(Exception e)
		{		
			return false;
		}
	}

	/**
	 * Helper function to generate ErrerType enum.
	 * 
	 * @param error
	 * @return
	 */
	private ErrorType getErrorType(String error)
	{
		String errorType = error.toUpperCase();
		ErrorType result = ErrorType.valueOf(errorType);
		
		System.out.println("Error Type: " + result.toString());
		
		return result;
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
	 * @throws FileInvalidException 
	 */
	public static void main(String[] args) throws FileInvalidException 
	{
		BibCreator test1 = new BibCreator();
		test1.startProcess();
	}
}