import java.util.ArrayList;

/**
 * ------------------------------------
 * COMP 249-D Assignment #3
 * 
 * Each document represents a bib file.
 * 
 * @author Tsang Chi Kit (ID: 25692636)
 * ------------------------------------
 */
public class Document
{
	private ArrayList<Article> articles;
	private String documentName;
	
	/**
	 * Default constructor
	 */
	public Document(String documentName)
	{
		this.documentName = documentName;
	}
	
	/**
	 * 
	 * @param article
	 */
	public void addArticle(Article article)
	{
		articles.add(article);
	}
	
	public String getDocumentName()
	{
		return documentName;
	}

	public void setDocumentName(String documentName)
	{
		this.documentName = documentName;
	}
}
