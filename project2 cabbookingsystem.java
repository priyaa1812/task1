package javatraining;
import java.util.Scanner;
class cab{
	long phoneno;
	String name;
	int passengercount;
	int choice,dropdis;
	int kms,price,riderotp=0000,userotp;
	String ride="confirm";
}
class have extends cab{
void functions(){
	
	Scanner obj=new Scanner(System.in);
	System.out.println("Please enter your name:");
	name=obj.next();
	System.out.println("Please enter your phoneno:");
	phoneno=obj.nextLong();
	System.out.println("Enter the otp you received for the registered mobile number:");
	userotp=obj.nextInt();
	System.out.println("Enter the no.of pasangers:");
	passengercount = obj.nextInt();
	System.out.println("Enter the drop location distance from where you stand:");
	dropdis=obj.nextInt();
	kms=dropdis;
	System.out.println("Total travelling kms:"+kms+"kms");
	if(passengercount==1){
		System.out.println("Please select which type of vehicle:"+"\n"+"1.Bike"+"\n"+"2.Auto"+"\n"+"3.Taxi"+"\n"+"4.Car");
		Scanner ob=new Scanner(System.in);
		choice=obj.nextInt();
		if(choice==1){
			System.out.println("Ride details:");
				price=kms*1;
				System.out.println("Price:"+price);
				System.out.println("Ride yes/no");
				ride=obj.next();
				if(ride.equals("yes")){
					System.out.println("Enjoy your bike ride");
					System.out.println("User otp:");
					userotp=obj.nextInt();
					if(userotp==riderotp){
					System.out.println("Otp confirmed.Have a safe and happy journey!");
				    }
				}
				else {
					System.out.println("Have a good day!");
				}
		}
	
		else if(choice==2){
			System.out.println("Ride details:");
			price= kms*3;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your auto ride!");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
					System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
				
				
			}
			else {
				System.out.println("Have a good day!");
			}
		}
		else if(choice==3){
			System.out.println("Ride details:");
			price= kms*6;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your taxi ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
			}
		}
		else if(choice==4){
			System.out.println("Ride details:");
			price= kms*10;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your car ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
				else {
					System.out.println("Have a good day!");
				}
			}
			else {
				System.out.println("Have a good day!");
			}
		}
		else {
			System.out.println("Have a good day!");
		}
		
	
	}
	else if(passengercount>1&&passengercount<=3) {
		System.out.println("Please select which type of vehicle:"+"\n"+"1.Auto"+"\n"+"2.Taxi"+"\n"+"3.Car");
		Scanner ob=new Scanner(System.in);
		choice=obj.nextInt();
		if(choice==1){
			System.out.println("Ride details:");
			price= kms*3;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your auto ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
			}
			else {
				System.out.println("Have a good day!");
			}
		}
		else if(choice==2){
			System.out.println("Ride details:");
			price= kms*6;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your taxi ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
				
			}
			else {
				System.out.println("Have a good day!");
			}
		}
		else if(choice==3){
			System.out.println("Ride details:");
			price= kms*10;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your Car ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
			}
			else {
				System.out.println("Have a good day!");
			}
		}
		
		
	}
	else if(passengercount>3){
		System.out.println("Please select which type of vehicle:"+"\n"+"1.Taxi"+"\n"+"2.Car");
		Scanner ob=new Scanner(System.in);
		choice=obj.nextInt();
	    if(choice==1){
			System.out.println("Ride details:");
			price= kms*6;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your taxi ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
			}
			else {
				System.out.println("Have a good day!");
			}
		}
	    else if(choice==2){
	    	System.out.println("Ride details:");
			price= kms*10;
			System.out.println("Price:"+price);
			System.out.println("Ride yes/no");
			ride=obj.next();
			if(ride.equals("yes")){
				System.out.println("Enjoy your Car ride");
				System.out.println("User otp:");
				userotp=obj.nextInt();
				if(userotp==riderotp){
			
				System.out.println("Otp confirmed.Have a safe and happy journey!");
				}
			}
			else {
				System.out.println("Have a good day!");
			}
		}
	else{
			System.out.println("Invalid number.");
		}
		
	}
	
}
}
public class  cabsystem{
	public static void main(String[] args){
		have obj=new have();
		
        obj.functions();
	}

}