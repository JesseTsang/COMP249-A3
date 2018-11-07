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
	private ErrorType[] errors;
	
	
	public FileInvalidException(ErrorType[] errors)
	{
		this.errors = errors;		
	}
	
	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public ErrorType[] getErrors()
	{
		return errors;
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public void setErrors(ErrorType[] errors)
	{
		this.errors = errors;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
