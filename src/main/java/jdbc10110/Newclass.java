package jdbc10110;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class Newclass {



	public static void main(String[] args) {
		
		int rice = 100 ,dal = 150 , atta = 200;
		 int price=0;
		 StringBuilder item = new StringBuilder();
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("                            SHOP ENTRIES                  ");
		System.out.println("----------------------------------------------------------------------");
	
		System.out.println("Enter customer ID: ");
		String cusID = sc.nextLine();
		while(true) {
		System.out.println("Available items are \n 1 rice \n 2 dal \n 3 atta");
		System.out.println("Enter item no : ");
		int val = sc.nextInt();
		if (val == 1 )	{
			price += rice;
			item.append("Rice,");
		} else if (val == 2) {
			price += dal;
			item.append("Dal,");}
		else if(val == 3) {
			price += atta;
			item.append("Atta,");
		}else {
			System.out.println("error!");
			continue;
		}
		
		 System.out.println("want to add more : ");
		 sc.nextLine();
		 String ch = sc.nextLine();
		
		 if (!ch.equalsIgnoreCase("y")) {
		break;
			 }
		
		}
		 sc.close();
		 if (item.length()>0) {
			 item.setLength(item.length()-1);
		 }
		try {
			 Connection con = null;
		       
		        
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","password");
			
			Statement stmt = con.createStatement();
			String query = "insert into table1 values ('"+cusID+"','"+item+"', '"+price+"')";

			stmt.executeUpdate(query);
			System.out.println("record saved");
		}
		catch(Exception e) {
			System.out.println("no conn");
		}

	}
	
	}


