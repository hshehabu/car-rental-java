
import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
interface CarRent {
	void mainMenu();
	void displayDetail();
	void Functionality();
	void lesseeDetails();

}
interface LoginPage{
	void loginPage();
	
}
public class CarRental {

	void Continue()
	{
		System.out.println("press any key to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			
			System.out.println("<--SomeThing Went Wrong--->");
		}
	}	 
	Scanner scan = new Scanner(System.in);

	String CarName,CarModel,CarColor;	
	int CarNo;
	double CarPrice;
	static String input;//Since it is going to be used in a static method
	
	
	void availableCars()  {
		
		 System.out.println("Here are Available cars");
		try {
			FileReader fil= new FileReader("carlist.txt");

			int data = fil.read();
			while(data != -1) {
				System.out.print((char)data);
				data=fil.read();
			}
			
			fil.close();
			
		} catch (IOException e) {
			
			System.out.println("<!---There are no available cars for now check later---->");
			
			Continue();
			}
	
	
	}
	
	
	public class lesseLogin implements LoginPage{

		String lesseeuname,lesseepsw;
		lesseLogin(String lesseeuname,String lesseepsw){
			this.lesseeuname=lesseeuname;
			this.lesseepsw=lesseepsw;
		}
		 Lessee lessee = new Lessee();
			public void loginPage() {
				 System.out.println("Enter Username");
				 String name= scan.nextLine();
				 System.out.println("Enter PassWord");
				 String  psw=scan.nextLine();
				 	if(name.equals(lesseeuname)) {
					if(name.equals(lesseeuname) && psw.equals(lesseepsw)) {
						lessee.Functionality();
					}
					else {
						System.out.println("incorrect password\n");
						CarRental.main(null);
					}}
					else {
						System.out.println("Incorrect username\n");
						CarRental.main(null);
					}
				 	}
				}

	
	public class lessorLogin implements LoginPage{
		String lessoruname,lessorpsw;
	lessorLogin(String lessoruname,String lessorpsw){
		this.lessoruname=lessoruname;
		this.lessorpsw=lessorpsw;
	}
	public void loginPage() {
		 Lessor lessor = new Lessor();
		 System.out.println("Enter Username");
		 String name= scan.nextLine();
		 System.out.println("Enter PassWord");
		 String  psw=scan.nextLine();
		 	if(name.equals(lessoruname)) {
			if(name.equals(lessoruname) && psw.equals(lessorpsw)) {
				lessor.Functionality();
			}
			else {
				System.out.println("incorrect password\n");
				CarRental.main(null);
			}}
			else {
				System.out.println("Incorrect username\n");
				CarRental.main(null);
				
			}
		 	}
		
//		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CarRental login = new CarRental();
		CarRental.lesseLogin lessee =login.new lesseLogin("","");
		CarRental.lessorLogin lessor =login.new lessorLogin("","");
		
		
		System.out.println("|<---Type 1 if You are Lessee or 2 If you are Lessor--->|");
		
		
		input=scan.nextLine();
		switch(input) {
		case "1":
			
			lessee.loginPage();
			break;
		
		case "2":
			
			lessor.loginPage();
			
			break;
		default:
			System.out.println("Wrong Response enter 1 or two");
			main(args);
		}
		
	
	
	
		scan.close();
	}
	}












