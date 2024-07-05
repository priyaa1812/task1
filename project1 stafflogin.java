package javatraining;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class adstaff {
	void staffaccess() throws Exception{
		Scanner obj=new Scanner(System.in);
		int choice;
		
		System.out.println("Enter your choice: \n\n 1.VIEW STAFF RECORD \n 2.STUDENT TABLE ACCESS\n");
		choice=obj.nextInt();
		if(choice==1) {
		System.out.println("Staff viewing their details");
		System.out.println("Enter your username");
		String username=obj.next();
		System.out.println("Enter your pw");
	    int pw=obj.nextInt();
	   
	    String url="jdbc:mysql://localhost/adminuser1";
		String user="root";
		String pass="";
		String qry="SELECT * FROM staff WHERE USERNAME=? and PW=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt= con.prepareStatement(qry);
		stmt.setString(1,username);
	    stmt.setInt(2,pw);
		ResultSet rst=stmt.executeQuery();
		if(rst.next()) {
		System.out.println("Successful Login!!! Valid Staff record!");
		System.out.println("Viewing "+username+" records:");
		System.out.println("ID\t\tSTAFFNAME\tSUBJECTNAME\tUSERNAME\tPASSWORD\tSALARY\tSALARY STATUS");
		
			System.out.print(rst.getInt(1));
			System.out.print("\t\t"+rst.getString(2));
			System.out.print("\t\t"+rst.getString(3));
			System.out.print("\t\t"+rst.getString(4));
			System.out.print("\t"+rst.getInt(5));
			System.out.print("\t\t"+rst.getString(6));
			System.out.print("\t"+rst.getString(7));
			System.out.println();
		}
		else {
			System.out.println("Invalid Staff");
		}
	    con.close();
	    stmt.close();
	}
		else if(choice==2) {
			String url="jdbc:mysql://localhost/adminuser1";
			String user="root";
			String pass="";
			String staffname;
			System.out.println("Entry of  student's marks!");
			System.out.println("Enter the student username and pw whose marks are to be updated?");
			String username=obj.next();
			int pw=obj.nextInt();
			String qry="SELECT * FROM student WHERE USERNAME=? and PW=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt= con.prepareStatement(qry);
		    stmt.setString(1,username);
		    stmt.setInt(2,pw);
			ResultSet rst=stmt.executeQuery();
			if(rst.next()) {
			System.out.println("Valid student!");
			System.out.println("Enter the Mark scored in english");
			int mark_eng=obj.nextInt();
			System.out.println("Enter the Mark scored in tamil");
			int mark_tam=obj.nextInt();
			System.out.println("Enter the Mark scored in maths");
			int mark_maths=obj.nextInt();
			int total= mark_eng+mark_tam+mark_maths;
		    int average=total/3;
		    String qry1="UPDATE student SET M1=?,M2=?,M3=?,Total=?,Average=? where PW=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt1= con1.prepareStatement(qry);
			
			stmt1.setInt(1,mark_eng);
			stmt1.setInt(2,mark_tam);
			stmt1.setInt(3,mark_maths);
			stmt1.setInt(4,total);
			stmt1.setInt(5,average);
			stmt1.setInt(6,pw);
			stmt1.executeUpdate();
			System.out.println("inserted");
			stmt1.close();
			con1.close();
		}
			else {
				System.out.println("INVALID STUDENT ");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		adstaff ob=new adstaff();
		ob.staffaccess();

	}

}
