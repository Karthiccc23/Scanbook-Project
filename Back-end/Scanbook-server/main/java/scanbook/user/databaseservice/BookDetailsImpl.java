package scanbook.user.databaseservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import scanbook.user.bean.Book_details;

public class BookDetailsImpl implements BookDetailsinterface {
	private DataSource dataSource;
	List<Book_details> Bookdetails = new ArrayList<Book_details>();
	Book_details bd = new Book_details();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<Book_details> getbook(String isbn) {
		// TODO Auto-generated method stub
		Bookdetails.clear();
		try {
			Bookdetails.clear();
			bd.setisRead("");
			Connection con=dataSource.getConnection();
			Statement statement = con.createStatement();
			String sqlquery="select * from books_inventory where isbn LIKE ?";
			PreparedStatement stmt =con.prepareStatement(sqlquery);
			stmt.setString(1,isbn);


			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				
				bd.setTitle(rs.getString("Title"));
				bd.setAuthor(rs.getString("Author"));
				bd.setdescription(rs.getString("description"));
				bd.setnoofpages(rs.getString("Noofpages"));
				bd.setPublisher(rs.getString("Publisher"));


				
			}
			
			getnotes(isbn);
			Bookdetails.add(bd);


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Bookdetails;
	}

	public String addbook(String Isbn,String Title,String author , String publisher , String description,String noofpages,String notes,String isread) {
		// TODO Auto-generated method stub

		try {
			Connection con=dataSource.getConnection();
			Statement statement = con.createStatement();
			String sqlquery="INSERT INTO BOOKS_INVENTORY (ISBN,TITLE,AUTHOR,NOOFPAGES,PUBLISHER,DESCRIPTION) " + "VALUES (?,?,?,?,?,?)";
			
			PreparedStatement stmt =con.prepareStatement(sqlquery);
			//con.setAutoCommit(false);
			stmt.setString(1, Isbn);
			stmt.setString(2, Title);
			stmt.setString(3, author);
			stmt.setString(4, noofpages);
			stmt.setString(5, publisher);
			stmt.setString(6, description);
			

			stmt.execute();
			addnotes(Isbn, isread, notes);

		
		
		//	con.commit();



		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public String updatenotes(String Isbn, String notes, String isread) {
		// TODO Auto-generated method stub
		
		try {
			Connection con=dataSource.getConnection();
			Statement statement = con.createStatement();
			String sqlquery="UPDATE USER_READ_HISTORY SET IS_READ = ? , NOTES=? WHERE ISBN = ?"  ;
			PreparedStatement stmt =con.prepareStatement(sqlquery);
			stmt.setString(1,isread);
			stmt.setString(2,notes);
			stmt.setString(3,Isbn);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String deletebook(String isbn) {
		// TODO Auto-generated method stub
		
		try {
			Connection con=dataSource.getConnection();
			Statement statement = con.createStatement();
			String sqlquery="DELETE FROM BOOKS_INVENTORY WHERE isbn = ?";
			PreparedStatement stmt =con.prepareStatement(sqlquery);
			stmt.setString(1, isbn);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addnotes(String Isbn,String isread,String notes)
	{
		
		
		try {
			Connection con = dataSource.getConnection();
						
			String sqlquery="INSERT INTO USER_READ_HISTORY (ISBN,IS_READ,NOTES) " + "VALUES (?,?,?)";

			PreparedStatement stmt2=con.prepareStatement(sqlquery);
			stmt2 =con.prepareStatement(sqlquery);
			stmt2.setString(1, Isbn);
			stmt2.setString(2, isread);
			stmt2.setString(3, notes);
			
			stmt2.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getnotes(String Isbn)
	{
		
		
		try {
			Connection con = dataSource.getConnection();
						
			String sqlquery="select * from USER_READ_HISTORY where isbn LIKE ?";

			PreparedStatement stmt2=con.prepareStatement(sqlquery);
			stmt2 =con.prepareStatement(sqlquery);
			stmt2.setString(1,Isbn);
			ResultSet rs=stmt2.executeQuery();
			while (rs.next()) {
				
				bd.setisRead(rs.getString("is_read"));
			
				bd.setnotes(rs.getString("notes"));


			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}


