package MoviePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
public class MovieDatabaseconnector {

	
	public static void main(String[] args)
	{
		 Connection  c;
		 Statement  s;
		 try
   	  {
   		  Class.forName("com.mysql.jdbc.Driver");
   		  c=DriverManager.getConnection("jdbc:mysql:///movies_database","root","Nishu@123");
   		  
   		System.out.println("Connected to the database");
   		s=c.createStatement();
   		System.out.println("\nEnter the Movie name, Lead Actor, Actress, Year of Release,Director Name\n");
   		Scanner in = new Scanner(System.in);
		String mname = in.nextLine();
		String acname = in.nextLine();
		String actname = in.nextLine();
		int yor = in.nextInt();
		String dname = in.nextLine();
   		String query1 = "INSERT INTO movies_details " + "VALUES ('" +mname+ "', '" +acname+ "', '" +actname+ "', '" +yor+ "', '" +dname+ "')";
        s.executeUpdate(query1);
        String sql="Select * from movies_details";
   		ResultSet res=s.executeQuery(sql);
   		System.out.println("\nMovies Details:-");
   		System.out.println("Movie name   Lead Actor  Actress  Year of Release  Director Name\n");
   		while(res.next())
   		{
   			String Movie_name=res.getString("Movie_name");
   			String Lead_Actor=res.getString("Lead_Actor");
   			String Actress=res.getString("Actress");
   			int year_of_release=res.getInt("year_of_release");
   			String Director_name=res.getString("Director_name");
   			System.out.println(Movie_name+" "+Lead_Actor+" "+Actress+" "+year_of_release+" "+Director_name);
   		}
   		System.out.println("\nEnter the actor name whose details you want to search\n");
   		String actor = in.nextLine();
   		String sql2="Select * from movies_details where Lead_Actor='" +actor+ "'";
   		 res=s.executeQuery(sql2);
   		while(res.next())
   		{
   			String Movie_name=res.getString("Movie_name");
   			String Lead_Actor=res.getString("Lead_Actor");
   			String Actress=res.getString("Actress");
   			int year_of_release=res.getInt("year_of_release");
   			String Director_name=res.getString("Director_name");
   			System.out.println(Movie_name+" "+Lead_Actor+" "+Actress+" "+year_of_release+" "+Director_name);
   		}
   	  }catch(Exception e)
   	  {
   		e.printStackTrace();
   		System.out.println("Oops Error!");
   	  }
	
	}

}
