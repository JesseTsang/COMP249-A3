import java.io.File;

/**
 * 
 */

/**
 * @author Jesse
 *
 */
public class FileInvalidException extends Exception
{
	private static final long serialVersionUID = 1L;
	private ErrorType error;
	String fileName;
	
	public FileInvalidException(ErrorType errorType)
	{
		this.error = errorType;
		this.fileName = "";		
	}
	
	public FileInvalidException(File file, ErrorType errorType)
	{
		this.error = errorType;
		this.fileName = file.getName();
				
		displayError();
	}
	
	

	/**
	 * 
	 */
	private void displayError()
	{
		System.out.println("Error: Detected Empty Field!");
		System.out.println("============================");
		
		System.out.println("");
		
		System.out.println("Problem detected with input file: " + fileName);
		System.out.println("File is invalid: Field \"" + error.toString() + "\" is empty. Processing stopped at this point. Other empty fields may be present as well!");	
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public ErrorType getErrors()
	{
		return error;
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public void setErrors(ErrorType errors)
	{
		this.error = errors;
	}
	
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
