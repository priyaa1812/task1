package javatraining;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class adstudent {
	void studentres() throws Exception {
	Scanner obj=new Scanner(System.in);
	System.out.println("Student viewing their details!!!");
	System.out.println("Enter your username");
	String username=obj.next();
	System.out.println("Enter your pw");
    int pw=obj.nextInt();
    String url="jdbc:mysql://localhost/adminuser1";
	String user="root";
	String pass="";
	
	String qry="SELECT * FROM student WHERE USERNAME=? and PW=?";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,user,pass);
	PreparedStatement stmt= con.prepareStatement(qry);
    stmt.setString(1,username);
    stmt.setInt(2,pw);
	ResultSet rst=stmt.executeQuery();
	if(rst.next()) {
	System.out.println("Successful Login!!! valid student record!");
	System.out.println("Viewing "+username+" records:");
	System.out.println("ID\t\tSTUDENTNAME\tRNO\tUSERNAME\tPASSWORD\tM1\tM2\tM3\tTotal\tAverage");
	
		System.out.print(rst.getInt(1));
		System.out.print("\t\t"+rst.getString(2));
		System.out.print("\t\t"+rst.getInt(3));
		System.out.print("\t"+rst.getString(4));
		System.out.print("\t"+rst.getInt(5));
		System.out.print("\t"+rst.getInt(6));
		System.out.print("\t"+rst.getInt(7));
		System.out.print("\t"+rst.getInt(8));
		System.out.print("\t"+rst.getInt(9));
		System.out.print("\t"+rst.getInt(10));
		System.out.println();
	
    con.close();
    stmt.close();
	}
	else
	{
		System.out.println("Invalid student");
	}
	}
	
	public static void main(String[] args) throws Exception {
		adstudent ob=new adstudent();
		ob.studentres();
        
	}

}
