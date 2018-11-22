/**
 * ------------------------------------
 * COMP 249-D Assignment #3
 * 
 * Each entry class object represents an article in the bib file.
 * 
 * @author Tsang Chi Kit (ID: 25692636)
 * ------------------------------------
 */
public class Article
{
	private Element ID, author, journal, title, year, volume, number, pages, keywoards, doi, issn, month;
	
	/**
	 * Default constructor
	 */
	public Article()
	{
		
	}
	
	/**
	 * Parameterized constructor
	 */
	public Article(Element ID, Element author, Element journal, Element title, Element year, 
			Element volume, Element number, Element pages, Element keywoards, 
			Element doi, Element issn, Element month)
	{
		this.ID = ID;
		this.author = author;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = 
		this.pages = pages;
		this.keywoards = keywoards;
		this.doi = doi;
		this.issn = issn;
		this.month = month;
	}
	
	
	public Element getID()
	{
		return ID;
	}

	public void setID(Element iD)
	{
		ID = iD;
	}

	public Element getAuthor()
	{
		return author;
	}

	public void setAuthor(Element author)
	{
		this.author = author;
	}

	public Element getJournal()
	{
		return journal;
	}

	public void setJournal(Element journal)
	{
		this.journal = journal;
	}

	public Element getTitle()
	{
		return title;
	}

	public void setTitle(Element title)
	{
		this.title = title;
	}

	public Element getYear()
	{
		return year;
	}

	public void setYear(Element year)
	{
		this.year = year;
	}

	public Element getVolume()
	{
		return volume;
	}

	public void setVolume(Element volume)
	{
		this.volume = volume;
	}

	public Element getNumber()
	{
		return number;
	}

	public void setNumber(Element number)
	{
		this.number = number;
	}

	public Element getPages()
	{
		return pages;
	}

	public void setPages(Element pages)
	{
		this.pages = pages;
	}

	public Element getKeywoards()
	{
		return keywoards;
	}

	public void setKeywoards(Element keywoards)
	{
		this.keywoards = keywoards;
	}

	public Element getDoi()
	{
		return doi;
	}

	public void setDoi(Element doi)
	{
		this.doi = doi;
	}

	public Element getIssn()
	{
		return issn;
	}

	public void setIssn(Element issn)
	{
		this.issn = issn;
	}

	public Element getMonth()
	{
		return month;
	}

	public void setMonth(Element month)
	{
		this.month = month;
	}
}
