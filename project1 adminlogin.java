package javatraining;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class admin {
	void adminlogin() throws Exception {
		Scanner obj=new Scanner(System.in);
		String username="admin01";
		int pw=101;
		System.out.println("Hey Admin,Enter the username and password");
		username=obj.next();
		pw=obj.nextInt();
		int choice;
		if(username.equals("admin01")&& pw==101) {
			System.out.println("Valid admin!!!");
			int x=1;
			while(x==1)
			{ 
			System.out.println("Enter your choice \n\n 1.Staff Access \n 2.Student Access \n 3.Delete Student or Staff\n");
			choice=obj.nextInt();
            if(choice==1) { //Staff entry
				String url="jdbc:mysql://localhost/adminuser1";
				String user="root";
				String pass="";
				String staffname;
				System.out.println("Selected staff access!");
				 
				System.out.println("Enter the Staff's name:");
				staffname=obj.next();
				String qry1="SELECT * FROM Staff WHERE STAFFNAME=?";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement stmt= con.prepareStatement(qry1);
				stmt.setString(1,staffname);
				ResultSet rst=stmt.executeQuery();
				if(rst.next()) {
					System.out.println("Already staff exists...");
					System.out.println("Salary Status updated in table...");
					String qry="UPDATE staff SET SALSTATUS='CREDITED'";
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1 = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt1= con1.prepareStatement(qry);
					stmt1.executeUpdate();
					stmt1.close();
					con1.close();
					
				}
				else {
				System.out.println("Staff doesn't exist/New staff/ Get details:");
				String stname,subject,usrname,salstats;
				int password,salary;
				
				System.out.println("Enter the Staff name:");
				stname= obj.next();
				System.out.println("Enter the Subject Handling:");
				subject= obj.next();
				System.out.println("Enter the username:");
				usrname= obj.next();
				System.out.println("Enter the pw:"); 
				password=obj.nextInt();
				System.out.println("Enter the salary:");
				salary=obj.nextInt();
				System.out.println("Enter the salstatus:");
				salstats= obj.nextLine();
			    String qry="INSERT INTO staff(STAFFNAME,SUBJECTHANDLING,USERNAME,PW,SALARY,SALSTATUS) VALUES(?,?,?,?,?,?)";
				PreparedStatement stmt1= con.prepareStatement(qry);
				stmt1.setString(1,stname);
				stmt1.setString(2,subject);
				stmt1.setString(3,usrname);
				stmt1.setInt(4,password);
				stmt1.setInt(5,salary);
				stmt1.setString(6,salstats);
				stmt1.executeUpdate();
				System.out.println("INSERTED...");
				stmt1.close(); 
				}
				
				}
				
			
			else if(choice==2) { //student entry
				String url="jdbc:mysql://localhost/adminuser1";
				String user="root";
				String pass="";
				String stuname;
				System.out.println("Selected student access!");
				
				{ 
				System.out.println("Enter the Student name...");
				stuname=obj.next();
				String qry1="SELECT * FROM student WHERE STUDENTNAME=?";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement stmt= con.prepareStatement(qry1);
				stmt.setString(1,stuname);
				ResultSet rst=stmt.executeQuery();
				if(rst.next()) {
					System.out.println("Already student exists...");
				}
				else {
				System.out.println("New student/ Get details:");
				String stname,usrname;
				int password,rno;
				System.out.println("Enter the Student name:");
				stname= obj.next();
				System.out.println("Enter the rno:");
				rno= obj.nextInt();
				System.out.println("Enter the username:");
				usrname= obj.next();
				System.out.println("Enter the pw:");
				password=obj.nextInt();
				System.out.println("Enter 5 null values");// can be handled by staff
				int mark_eng=obj.nextInt();
				int mark_tam=obj.nextInt();
				int mark_maths=obj.nextInt();
				int total=obj.nextInt();
				int average=obj.nextInt();
				String qry="INSERT INTO student(STUDENTNAME,RNO,USERNAME,PW,M1,M2,M3,TOTAL,AVERAGE) VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt1= con.prepareStatement(qry);
				stmt1.setString(1,stname);
				stmt1.setInt(2,rno);
				stmt1.setString(3,usrname);
				stmt1.setInt(4,password);
				stmt1.setInt(5,mark_eng);
				stmt1.setInt(6,mark_tam);
				stmt1.setInt(7,mark_maths);
				stmt1.setInt(8,total);
				stmt1.setInt(9,average);
				
				stmt1.executeUpdate();
				System.out.println("INSERTED");
				stmt1.close(); 
				con.close();
				
				}
				}
			}
			else if(choice==3) { //deletion
				System.out.println(" Selected DELETION!");
				System.out.println("1.Delete Staff \n 2.Delete Student");
				int choices=obj.nextInt();
				if(choices==1) {
					System.out.println("Delete which Staff ? Enter STAFFNAME:");
					
					String url="jdbc:mysql://localhost/adminuser1";
					String user="root";
					String pass="";
					String staffname=obj.next();
					String qry="DELETE FROM Staff WHERE STAFFNAME=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt= con.prepareStatement(qry);
					stmt.setString(1,staffname);
					stmt.executeUpdate();
					System.out.println("Done");
					stmt.close();
					con.close();
				}
				else if(choices==2) {
					System.out.println("Delete which Student? Enter STUDENT ROLLNO");
					String url="jdbc:mysql://localhost/adminuser1";
					String user="root";
					String pass="";
					int rollno=obj.nextInt();
					String qry="DELETE FROM student WHERE RNO=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt= con.prepareStatement(qry);
					stmt.setInt(1,rollno);
					stmt.executeUpdate();
					System.out.println("Done...");
					stmt.close();
					con.close();
					
				}
				else {
					
				}
			}
			else {
				
			}
            System.out.println("Do you want to continue?");
			x=obj.nextInt();
			}
			
			}	
		else {
			System.out.println("INVALID ADMIN...");
		}
		
	}
	
		void adstudent() throws Exception {
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
		System.out.println("Successful Login!!! valid student record!\n");
		System.out.println("Viewing "+username+" records:");
		System.out.println("ID\t\tSTUDENTNAME\tRNO\tUSERNAME\tPASSWORD\tM1\tM2\tM3\tTotal\tAverage");
		
			System.out.print(rst.getInt(1));
			System.out.print("\t\t"+rst.getString(2));
			System.out.print("\t\t"+rst.getInt(3));
			System.out.print("\t"+rst.getString(4));
			System.out.print("\t"+rst.getInt(5));
			System.out.print("\t\t"+rst.getInt(6));
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
		
		void adstaff() throws Exception{
				Scanner obj=new Scanner(System.in);
				int choice;
				int x=1;
				while(x==1)
				{ 
				System.out.println("Enter your choice: \n\n 1.VIEW STAFF RECORDS \n 2.STUDENT MARK UPDATION\n");
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
					System.out.println("Enter the student username whose marks are to be updated?");
					String username=obj.next();
					
					String qry="SELECT * FROM student WHERE USERNAME=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt= con.prepareStatement(qry);
				    stmt.setString(1,username);
				   
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
				    String qry1="UPDATE student SET M1=?,M2=?,M3=?,Total=?,Average=? where USERNAME=?";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1 = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt1= con1.prepareStatement(qry1);
					stmt1.setInt(1,mark_eng);
					stmt1.setInt(2,mark_tam);
					stmt1.setInt(3,mark_maths);
					stmt1.setInt(4,total);
					stmt1.setInt(5,average);
					stmt1.setString(6,username);
					stmt1.executeUpdate();
					System.out.println("Student marks updated!");
					stmt1.close();
					con1.close();
				}
					else {
						System.out.println("INVALID STUDENT... ");
					}
				}
				System.out.println("Do you want to continue?");
				x=obj.nextInt();
			}
		}
public static void main(String[] args) throws Exception {
	     
	    admin ob=new admin();
	    int x=1;
		while(x==1)
		{ 
		System.out.println("Who are you? \n\n 1.ADMIN...\n 2.STUDENT...\n 3.STAFF...");
		Scanner obj =new Scanner(System.in);
		int choice=obj.nextInt();
		if(choice==1) {
		ob.adminlogin();
		}
		else if(choice==2) {
		ob.adstudent();
		}
		else if(choice==3) {
		ob.adstaff();
		}
		System.out.println("Do you want to continue as admin/student/staff?");
		x=obj.nextInt();
		}
	}

	
}
	