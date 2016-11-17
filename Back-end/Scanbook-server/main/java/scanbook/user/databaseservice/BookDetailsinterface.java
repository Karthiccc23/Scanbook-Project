package scanbook.user.databaseservice;

import java.util.List;

import scanbook.user.bean.Book_details;

public interface BookDetailsinterface {
	public List<Book_details> getbook(String  isbn);
	public String addbook(String Isbn,String Title,String author , String publisher , String description,String noofpages,String notes,String isread);
	public String deletebook(String isbn);
	public void addnotes(String Isbn,String isread,String notes);
	public void getnotes(String Isbn);
	public String updatenotes(String title, String notes, String isread);

}

