/**
 * 
 */

/**
 * Each field on each article would be an element.
 * Each element would have 
 * 	(1) a name
 * 	(2) a string array of value[s]
 * 
 * @author Jesse
 *
 */
public class Element 
{
	private String name;
	private String[] value;
	
	public Element(String name, String[] value)
	{
		this.name = name;
		this.value = value;		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public String[] getValue()
	{
		return value;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public void setValue(String[] value)
	{
		this.value = value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub

	}

}
