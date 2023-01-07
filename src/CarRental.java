
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
//////////////////////////\\\\\\\\\\\\\\//////////////////LOGIN class End\\\\\\\\\\\\\\\\\\\\/////////////////////////////////////////
class Lessor extends CarRental implements CarRent{
	
	
	Scanner scan = new Scanner(System.in);
	 int verificationCode;
	 @Override
	public void mainMenu(){
		System.out.println("return to main menu   [Y/N]?");
		scan.nextLine();
		String response= scan.next();
		switch(response) {
		case "Y":
		case "y":
			Functionality();
			break;
		case "N":
		case "n"://To not make it case sensitive
			super.main(null);
			break;
		default:
			System.out.println("Wrong response");
			super.main(null);
		}
		
	}
		@Override
		public void Functionality() {
			 System.out.println("\n1-Register car\n2-Remove Saved car\n3-Display available cars\n4-Lessee Details\n5-logout");
			 int response =scan.nextInt();
			 switch(response) {
			 case 1:
				 CarDetail();
				 break;
			 case 2:
				 DeleteCar();
				 break;
			 case 3:
				 super.availableCars();
				 Continue();
				 Functionality();
				 break;
			 case 4:
				 lesseeDetails();
				 break;
			 case 5:
				 super.main(null);
			 default:
				 System.out.println("wrong response");
				 Functionality();
				 
			 }
			
		}
		
	 
void DeleteCar() {
	
	System.out.print("Enter the car name :");
	String select=scan.next();
try {
	File file=new File(select+".txt");
	File file2=new File(select+"verification.txt");
	 FileReader file3= new FileReader(select+".txt");
     
		int data = file3.read();
		while(data != -1) {
		System.out.print((char)data);
		data=file3.read();
		}
					
		file3.close();
	
	Continue();
	System.out.println("Are you sure you want to delete all info of "+select+"[Y/N]");
	String response= scan.next();
	switch(response) {
	case "Y":
	case "y":
		file.delete();
		file2.delete();
		System.out.println("All info of "+select+" deleted");
		Continue();
		mainMenu();
		break;
	case "N":
	case "n"://To not make it case sensitive
		System.out.println("///---Process terminated---///");
		Continue();
		mainMenu();//Static reference since Main method is Static 
		break;
	default:
		System.out.println("Wrong response");
		mainMenu();
	}
}
catch(FileNotFoundException e){
	System.out.println("<--There is no such a car-->");
	mainMenu();
}
	

catch(IOException e) {
	System.out.println("Something Went Wrong");
	mainMenu();
}	
	
}

	void CarDetail() {
	
		try {
		System.out.print("Car name : ");
		CarName=scan.next();
		System.out.print("Car model :");
		CarModel=scan.next();
		System.out.print("Car Color : ");
		CarColor=scan.next();
		System.out.print("Car No : ");
		CarNo=scan.nextInt();
		System.out.print("Car Price for one month: ");
		CarPrice=scan.nextDouble();
		
		Random random = new Random();
		verificationCode= random.nextInt(1000000000);		
	
		
		
		

			
			FileWriter file2 = new FileWriter(CarName+"verification.txt");
			file2.write(""+verificationCode);
			file2.close();
			FileWriter file = new FileWriter(CarName+".txt");
			file.write("Car name :"+CarName+"\n");
			file.append("Car Model: "+CarModel+"\n");
			file.append("CarColor: "+CarColor+"\n");
			file.append("Car No: "+CarNo+"\n");
			file.append("CarPrice [one Month]: \n");
			file.append(""+CarPrice);
			file.close();
			BufferedWriter b= new BufferedWriter( new FileWriter("carlist.txt",true));
			b.write(CarName+"\n");
			b.close();
			
		}
		catch(InputMismatchException e) {
			System.out.println("Enter a number please...");
			mainMenu();
		}
		catch(IOException e){
			System.out.println("Something Went Wrong");
			super.main(null);
		}
		displayDetail();
	
		}

	
	@Override
	public void displayDetail() {
			Continue();
			System.out.println("You have Succesfully added your Details");
			System.out.println("Verification code==:"+verificationCode);
			
			System.out.println("return to main menu   [Y/N]?");
			String response= scan.next();
			switch(response) {
			case "Y":
			case "y":
				Functionality();
				break;
			case "N":
			case "n"://To not make it case sensitive
				super.main(null);
				break;
			default:
				System.out.println("Wrong response");
				super.main(null);
			}
			
	}
	@Override
	public void lesseeDetails() {
		try {
			BufferedReader b3 = new BufferedReader(new FileReader("lesseeDetails.txt"));
			int data=b3.read();
			while(data!=-1) {
				System.out.print((char)data);
				data=b3.read();
			}
			b3.close();
			mainMenu();
		} catch (FileNotFoundException e) {
			
			System.out.println("There is No Lessee for now");
			mainMenu();
		} catch (IOException e) {
			System.out.println("Something Went Wrong");
			mainMenu();
		}
		
	}
}///////////////////////////end of lessor Class///////////////////////////////////////

 class Lessee extends CarRental implements CarRent{

String select;
String Name,Country,City;
 
int line,month,phoneNumber,response2;
double price,Total;
//void recipent() {
//	
//}
public void mainMenu() {
		
		System.out.println("return to main menu [Y/N]?");
		scan.nextLine();//to catch the escape sequence \n
		String response= scan.next();
		switch(response) {
		case "Y":
		case "y":
			Functionality();
			break;
		case "N":
		case "n"://To not make it case sensitive
			super.main(null);
			break;
		default:
			System.out.println("Wrong response");
			super.main(null);
		}
	
}
public void lesseeDetails() {
	
		System.out.println("\n<!---Please Fill out order Form--->");
		
		try {
		System.out.print("Enter your Name :");
		Name=scan.next();
		System.out.print("Enter Region :");
		Country=scan.next();
		System.out.print("Enter City :");
		City=scan.next();
		System.out.print("Enter PhoneNumber :");
		
		phoneNumber=scan.nextInt();
		if(Integer.toString(phoneNumber).length()!=9) {
			System.out.println("follow the format[ 911223344 ]");
			Continue();
			lesseeDetails();
		}
		}
		
		catch(InputMismatchException e) {
			System.out.println("//--Wrong phone-number format--//");
			
			mainMenu();
		}
		catch(Exception e) {
			System.out.println("Some thing went Wrong");
			mainMenu();
		}
		System.out.println("Do you Want to continue?[Y/N]");
		String response= scan.next();
		switch(response) {
		case "Y":
		case "y":
			
			SelectCar();
			
			break;
		case "N":
		case "n"://To not make it case sensitive
				Functionality();
			break;
		default:
			System.out.println("Wrong response");
		mainMenu();
		}
	}
	@Override
	public void Functionality() {
		 try {
		 System.out.println("\n1-Rent a car\n2-Available cars\n3-logout");
		
		 int response =scan.nextInt();
		
		 switch(response) {
		 case 1:
			
			
			 lesseeDetails();
		   break;
		 case 2:
			 availableCars();
			 mainMenu();
		 case 3:
			 super.main(null);
		 default:
			 System.out.println("---//wrong response//---");
			 
			 Functionality();
		
		 			}}
		 catch(InputMismatchException e) {
			 System.out.println("Enter 1-3");
			 Continue();
			 mainMenu();
		 }
		}
				
	void SelectCar() {
			super.availableCars();
			
	
	         System.out.println("\n1-Select a Car\n2-return to main menu");
	         response2=scan.nextInt();
			
	         switch(response2) {
			 case 1:
				 System.out.print("Car Name :");
				 select= scan.next();
					try {
				    Scanner scan2 = new Scanner(new File(select+".txt"));
				    for(line=1;line<8;line++) {
					if(line==7) {//checking if rented text is in the car file
					if(!scan2.hasNext()) {
					FileReader file= new FileReader(select+".txt");
								           
					int data = file.read();
					while(data != -1) {
					System.out.print((char)data);
					data=file.read();
					}
											
					file.close();
					scan2.close();
					priceCalculator(select); 
					}
					else {
					System.out.println("Car is already rented Choose another");
					System.out.println("press any key to continue...");
			        System.in.read();
			        SelectCar();
					}
					}
					else {
					scan2.nextLine();
					}
				    }
					}
					catch (FileNotFoundException e) {
						
						System.out.println(select+" car is not available please choose only from the list");
						SelectCar();//recursive function if no car found by the selected name
					}
					catch(Exception e) {
						System.out.println("**Something went wrong**");
						SelectCar();
					}
		  
				
						System.out.println("\n'Do you Want this Car'[Y/N]");
						String response= scan.next();
						switch(response) {
						case "Y":
						case "y":
							confirm();
						break;
						case "N":
						case "n"://To not make it case sensitive
							SelectCar();
							break;
						default:
							System.out.println("|<!--Wrong response-->");
							SelectCar();
				
						}
						break;
			 case 2:
				 Functionality();
			 default:
				 System.out.println("---//wrong response//---");
				 
				 Functionality();
			
			 			}
	        			
						}
	void priceCalculator(String select){
		String s=select;
		try {
	
        Scanner scanner2 = new Scanner(new File(select+".txt"));
       
		System.out.println("\nfor how long you want to rent [not more than 6]?"); 
	        month=scan.nextInt();
	        if(month<=6) {
	        for(line=1;line<7;line++) {
			if(line==6) {
			price=scanner2.nextDouble();//Store car price to variable
			}
			else {
			scanner2.nextLine();
			}
			}
	        Total=month*price;//Total payment
	        System.out.println("Total payment(birr)= :"+Total);
	        }
	       
	        else {
	        	System.out.println("not allowed morethan Six month");
				priceCalculator(s);
	        }
			}
		catch(InputMismatchException e) {
			System.out.println("Expected to be a number");
		}
		catch(IOException e) {
			System.out.println("Something went Wrong");
			mainMenu();
		   }
		
		   }

	void confirm() {
		try {
		int VerificationCode =0;
		
		
		System.out.println("A verification Code will be Sent to your phone-number After payment");
		
		scan.nextLine();
		
		
			File files = new File(select+"verification.txt");
			BufferedWriter b= new BufferedWriter( new FileWriter(select+".txt",true));
			
			Scanner scanner = new Scanner(files);
				while(scanner.hasNextInt())
					VerificationCode+=scanner.nextInt();
						
			//	if(verification==VerificationCode) 
				System.out.println("Enter your verification code");
					for(int i=3;i>=0;i--) {
					
					int verification=scan.nextInt();
					if(verification!=VerificationCode) {
					if(i!=0) {
					System.out.println("You have "+i+" attempts left");
					}
					else {
					System.out.println("<--Sorry you have used All of Your attempts-->");
					mainMenu();
					}
					}
					else {
b.write("\nRented by "+Name+" for "+month+ " month "+"starting from "+java.time.LocalDate.now()+" to "+java.time.LocalDate.now().plusMonths(month)); 
					b.close();
					scanner.close();
				
					BufferedWriter b2 = new BufferedWriter(new FileWriter("lesseeDetails.txt",true));
					
					b2.write("\nLessee name :"+Name+"\n");
					b2.append("Country: "+Country+"\n");
					b2.append("City: "+City+"\n");
					b2.append("PhoneNumber: 0"+phoneNumber+"\n");
					b2.append("Rented "+select+" car for "+month+ " month "+"starting from "+java.time.LocalDate.now()+" to "+java.time.LocalDate.now().plusMonths(month));
					b2.close();
					
					displayDetail();
					}
					}

					}
		catch(InputMismatchException e) {
			System.out.println("Verification expected to be a number\n");
			
			confirm();
		}
	catch (Exception  e) {
		System.out.println("|<--Something went Wrong-->|");
		mainMenu();
		}
		
		}
		@Override
	public  void displayDetail() {
		System.out.println("<!------you've succesfuly rented the car------>");
		System.out.println("return to login   [Y/N]?");
		String response= scan.next();
		switch(response) {
		case "Y":
		case "y":
			super.main(null);
			break;
		case "N":
		case "n"://To not make it case sensitive
		System.out.println("<!-------That's All------>");
			break;
		default:
			System.out.println("Wrong response");
			super.main(null);
		
		}
		
		}
		}












