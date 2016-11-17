package scanbook.user.bean;

public class Book_details {
	String isbn;
	String Title;
	String Author;
	String isRead;
	String Noofpages;
	String publisher;
	String description;
	String notes;

	public Book_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
  //GETTER METHODS
	public String getTitle()
	{
		return this.Title;
	}
	public String getAuthor()
	{
		return this.Author;
	}
	public String getisRead()
	{
		return this.isRead;
	}
	public String getpublisher()
	{
		return this.publisher;
	}
	public String getNoofpages()
	{
		return this.Noofpages;
	}
	public String getdescription()
	{
		return this.description;
	}
	public String getnotes()
	{
		return this.notes;
	}
	public String getisbn()
	{
		return this.isbn;
	}
	
	//SETTER METHODS
	public void setTitle(String title)
	{
		this.Title=title;
	}
	public void setAuthor(String author)
	{
		this.Author=author;
	}
	public void setisRead(String isread)
	{
		this.isRead=isread;
	}
	public void setPublisher(String Publisher)
	{
		this.publisher=Publisher;
	}
	public void setdescription(String des)
	{
		this.description=des;
	}
	public void setnoofpages(String noofpages)
	{
		this.Noofpages=noofpages;
	}
	public void setnotes(String notess)
	{
		this.notes=notess;
	}
	public void setisbn(String ISBN)
	{
		this.isbn=ISBN;
	}

}
