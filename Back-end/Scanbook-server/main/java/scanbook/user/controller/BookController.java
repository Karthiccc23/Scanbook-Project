package scanbook.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import scanbook.user.bean.Book_details;
import scanbook.user.databaseservice.BookDetailsImpl;

@RestController  
public class BookController {  
	@Autowired
	BookDetailsImpl bookimp;

	//GET METHOD TO GET LIST OF BOOKS THAT MATCHES ISBN

	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET,headers="Accept=application/json")  
	public List<Book_details> getbook(@PathVariable String isbn)  
	{  	

		List<Book_details> book_details=bookimp.getbook(isbn);

		if((book_details.get(0)).getisRead()=="" ||(book_details.get(0)).getisRead()==null)
		{
			return null;
		}
		else
		{

			return book_details;

		}
	}  

	//POST METHOD TO SAVE BOOKS IN MYSQL DATABASE

	@RequestMapping(value = "/books", method = RequestMethod.POST, headers =  {"content-type=application/x-www-form-urlencoded"})  
	public String addbooks(@RequestParam String Isbn,String Title,String author , String publisher , String description,String noofpages,String notes,String isread) {

		Boolean validate=bookimp.Servervalidation(Isbn);
		if(validate==false)
		{
			return "failed";


		}
		else
		{			
			bookimp.addbook(Isbn, Title,author,publisher,description,noofpages,notes,isread);

			return "success"; 
		}




	} 

	//EACH USER CAN ADD THEIR NOTES FOR THEIR BOOK - POST METHOD

	@RequestMapping(value = "/addnotes", method = RequestMethod.POST, headers =  {"content-type=application/x-www-form-urlencoded"})  
	public String addnotes(@RequestParam String Isbn,String notes,String isread) {


		Boolean validate=bookimp.Servervalidation(Isbn);
		if(validate==false)
		{
			return "failed";


		}
		else
		{
			bookimp.updatenotes(Isbn,notes,isread);

			return "success"; 
		}
	}  

	//DELETE BOOK BY GIVING INPUT AS BARCODE - DELETE METHOD

	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)  
	public String deletebook(@PathVariable("isbn") String Isbn) {

		Boolean validate=bookimp.Servervalidation(Isbn);

		if(validate==false)
		{
			return "failed";
		}
		else
		{
			String result=bookimp.deletebook(Isbn);
			return "success"; 
		}  

	}  





}  

