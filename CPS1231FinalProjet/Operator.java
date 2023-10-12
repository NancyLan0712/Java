package CPS1231FinalProjet;
import java.util.Scanner;
import java.util.ArrayList;
public class Operator {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String temp;
		ArrayList<NucleicAcidInformationRegistration> list =
				new ArrayList();
		while(true) {
			//display the main menu
			System.out.println("1 to log in\n"
					+ "2 to register your information\n"
					+"3 if you are administrator");
			System.out.print("Enter your choice: ");
			temp = input.next();
	
			//function 1: log in
			if(temp.equals("1")) {
				logIn(list, input);
			}
			
			//function 2: register you account
			else if(temp.equals("2")) {
				register(list, input);
			}
			
			//function 3: administractor mode
			else if(temp.equals("3")){
				administractorMode(list, input);
			}
			
			//default prompts: if you enter wrong things
			else
				System.out.println("\nWrong input!\n");
			
		}
		
		
	}
	//signature: indexCheck() --> int
	//Purpose: get a number from the user, if user enter letter of character
	//			program will loop and promts user to enter again
	public static int indexCheck() {
		boolean isTrue = true;
		int index = -1;
		Scanner input = new Scanner(System.in);
		do {
			try {
				index = input.nextInt();
				isTrue = false;
			}
			catch (java.util.InputMismatchException ex){
				System.out.println("! ! ! Wrong input ! ! !");
				input.nextLine();
				System.out.print("Please enter your index number: ");
			}
		}while(isTrue);
		return index;
	}
	
	//signature: logIn(list: ArrayList<NucleicAcidInformationRegistration>, input: Scanner) --> void
	//Purpose: log in the account which storage in the list 
	//			and provides some choices for user to revise their account information
	public static void logIn(ArrayList<NucleicAcidInformationRegistration> list,Scanner input) {
		int index;String temp;boolean isTrue = true;
		do {
			if(list.size() == 0)break;
			System.out.print("Please enter your index number: ");
			index = indexCheck();
			if(index + 1 > list.size()) {
				System.out.println("The index number is invalid");
				continue;
			}
			
			System.out.print("Please enter your password: ");
			temp = input.next();
			if(!temp.equals( list.get(index).getPassword())) {
				System.out.println("the password is wrong");
				System.out.print("0 to try again\nAny other key to return main menu\n"
						+ "Enter you choice: ");
				temp = input.next();
				if(temp.equals("0"))
					continue;
				else
					break;
			}
			do{
				System.out.println("\nMain Menu");
				System.out.println("Enter 0 to do nucleic acid test");
				System.out.println("Enter 1 to check your nucleic acid test valid time");
				System.out.println("Enter 2 to revise your name");
				System.out.println("Enter 3 to display your information");
				System.out.println("Enter 4 to reset your password");
				System.out.println("Enter 5 to log out");
				System.out.print("Please enter your choice: ");
				
				temp = input.next();
				switch(temp) {
				case "0":list.get(index).setDate();
				System.out.println(list.get(index).getDate());
				break;
				case "1":list.get(index).checkDate();
				break;
				case "2":
					System.out.print("Please enter your name: ");
					input.nextLine();
					temp = input.nextLine();
					list.get(index).setName(temp);
					break;
				case "3":
					System.out.println(list.get(index).toString());
					break;
				case "4":
					do {
						System.out.print("Please enter your new password: ");
						temp = input.next();
						if(temp.length() == 0)
							System.out.println("Do not enter nothing! ! !");
						else {
							list.get(index).setPassword(temp);
							isTrue = false;
						}	
					}while(isTrue);isTrue = true;break;
				case "5":isTrue = false;break;
				default: System.out.println("Please enter corresponding number");
				}
			}while(isTrue);
		}while(isTrue);
	}
	
	//signature: register(list: ArrayList<NucleicAcidInformationRegistration>, input: Scanner) --> void
	//Purpose: provide user a way to register account which will storage in list
	public static void register(ArrayList<NucleicAcidInformationRegistration> list,Scanner input) {
		String temp;boolean isTrue = true; int i = list.size();
		System.out.print("\nPlease enter your name: ");
		input.nextLine();
		temp = input.nextLine();
		list.add(new NucleicAcidInformationRegistration(temp));
		while(isTrue) {
			System.out.print("Please enter your identification number: ");
			temp = input.next();
			if(NucleicAcidInformationRegistration.checkId(temp)) {
				list.get(i).setIdentificationNumber(temp);
				list.get(i).setIndex(i);
				list.get(i).setDate();
				System.out.println(list.get(i).toString());
				isTrue = false;
			}
			else {
				System.out.println
				("\n! ! ! Please enter the right identification number ! ! !");
				System.out.print("0 to try again\nAny other key to return main menu\n"
						+ "Enter you choice: ");
				temp = input.next();
				if(temp.equals("0")) {
					continue;
				}
				else {
					list.remove(i);
					isTrue = false;
				}
			}
		}
		
	}
	
	//signature: administractorMode(ArrayList<NucleicAcidInformationRegistration>, input : Scanner) -->void
	//Purpose: provide a method for administractor to check the user information
	//			and check whose nucleic acid information has expired
	public static void administractorMode(ArrayList<NucleicAcidInformationRegistration> list,Scanner input) {
		String temp;boolean isTrue = true;
		do {
			System.out.print("\nEnter administrator password: ");
			if(!input.next().equals("green")) {
				System.out.println("! ! ! Invalid Password ! ! !\n");
				break;
			}
			do {
				System.out.println("\n1 to print all registracion information");
				System.out.println("2 to print members whose nucleic acid are expired");
				System.out.println("3 to log out");
				System.out.print("Enter your choice: ");
				temp = input.next();
				switch(temp) {
				case "1":
					System.out.print("\n<<< All Registraction Information >>>\n");
					for(NucleicAcidInformationRegistration E : list) {
						System.out.println(E.toString());
					}
					System.out.print("<<< To Be Continue >>>\n");
					break;
				case "2":
					System.out.println("<<<Nucleic Acid Expiration Member List>>>");
					for(int j = 0; j < list.size(); j++) {
						list.get(j).checkDateForAdministractor();
					}
					System.out.print("<<<   To be continue   >>>\n");
					break;
				case "3":isTrue = false;
					break;
				default: System.out.println("");
				}
			
			}while(isTrue);
		}while(isTrue);
	}
}
