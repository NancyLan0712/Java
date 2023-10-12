package CPS1231FinalProjet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
public class NucleicAcidInformationRegistration {
	//datefield to storage specific information of user
	private final int NUCLEIC_ACID_EFFECTIVE_TIME = 72;
	private String name ="Unfilled",identificationNumber = "Unfilled";
	private int age;
	private String password = "nothing";
	private int int.dex;
	private Date date = new Date();
	
	//construct method
	public NucleicAcidInformationRegistration(String name) {
		this.name = name;
	}
	
	//Accessor and Modifier of name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Accessor and Modifier of index
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	//Accessor and Modifier of identity numbers
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		if(checkId(identificationNumber)) {
			this.identificationNumber = identificationNumber;
			this.assignAge();
			this.setPassword();
		}
		else
			System.out.println("Please enter right identification number");
	}
	
	//Accessor of password and private Modifier of password
	public String getPassword() {
		return password;
	}
	//method to random create a identity password for user
	private void setPassword() {
		Random generator = new Random();
		//method to random a password consists of 2 upper case letter, 2 lower case letter
		//4 numbers
		password = generator.nextCode(2,2,4);
		
	}
	//method to reset password for user
	public void setPassword(String password) {
		this.password = password;
	}
	
	//method to record the nucleic acid test valid time
	//Accessor and Modifier of date
	public Date getDate() {
		return date;
	}
	public void setDate() {
		date = new Date();
	}
	//signature： checkDate() : void
	//purpose: display the date you do nucleic acid test last time
	//and if you 
	public void checkDate() {
		Date dateNow = new Date();
		System.out.println("\nYou last do nucleic acid test date is\n"+date);
		int timeDifference =(int) (  (dateNow.getTime() - date.getTime()) / 1000/*/3600 */  );
		if(timeDifference > NUCLEIC_ACID_EFFECTIVE_TIME) {
			System.out.println("\nYour nucleic acid has expired");
		}
		else if(timeDifference > NUCLEIC_ACID_EFFECTIVE_TIME - 12) {
			System.out.println("\nYour nucleic acid will be expired after "
					+(NUCLEIC_ACID_EFFECTIVE_TIME - timeDifference) + " seconds");
		}
		else {
			System.out.println("your nucleic acid is valid\n"
					+"Whitin "+timeDifference +" seconds negative");
			
		}
		
	}
	//signature: checkDateForAdministractor() --> void
	//Purpose: check the nucleic acid for administer
	//			print the index and name if the nucleic acid has expired
	public void checkDateForAdministractor() {
		Date dateNow = new Date();
		int timeDifference =(int) (  (dateNow.getTime() - date.getTime()) / 1000/*/3600 */  );
		if(timeDifference > NUCLEIC_ACID_EFFECTIVE_TIME) {
			System.out.println("index: " + index + " name: " +name);
			
		}
		
	}
	
	@Override
	public String toString() {
		return "Index is "+ index+ "\nName is " + name +"\nAge is " + age
				+ "\nPassword is " +password+"\n";
	}
	
	//Signature: checkId(id: String) --> boolean
	//Purpose: check if the identity number is right and return a boolean type
	//     if identification is valid, return true, else return false
	//example: checkId(150102199003078850) --> true
	// 			checkId(150102199003078851) --> false
	//			checkId(W50102199003078850) --> false
	public static boolean checkId(String id) {
		int sum = 0;
		int temp;
		if(id.length() != 18)
			return false;
		
		for(int i = 0 ; i < 17; i ++) {
			if(!Character.isDigit(id.charAt(i)))
				return false;
			switch(i) {
			case 0:temp = 7; break;
			case 1:temp = 9; break;
			case 2:temp = 10; break;
			case 3:temp = 5; break;
			case 4:temp = 8; break;
			case 5:temp = 4; break;
			case 6:temp = 2; break;
			case 7:temp = 1; break;
			case 8:temp = 6; break;
			case 9:temp = 3; break;
			case 10:temp = 7; break;
			case 11:temp = 9; break;
			case 12:temp = 10; break;
			case 13:temp = 5; break;
			case 14:temp = 8; break;
			case 15:temp = 4; break;
			default :temp = 2;
			}
			sum += (id.charAt(i) - '0')*temp;
		}
		sum %= 11;
		switch(sum) {
		case 0:if(id.charAt(17) == '1')
			return true;break;
		case 1:if(id.charAt(17) == '0')
			return true;break;
		case 2:if(id.charAt(17) == 'X')
			return true;break;
		case 3:if(id.charAt(17) == '9')
			return true;break;
		case 4:if(id.charAt(17) == '8')
			return true;break;
		case 5:if(id.charAt(17) == '7')
			return true;break;
		case 6:if(id.charAt(17) == '6')
			return true;break;
		case 7:if(id.charAt(17) == '5')
			return true;break;
		case 8:if(id.charAt(17) == '4')
			return true;break;
		case 9:if(id.charAt(17) == '3')
			return true;break;
		case 10:if(id.charAt(17) == '2')
			return true;
		}
		return false;
			
	}
	//Signature: assignAge() --> void
	//Purpose: method to assign age by identification number
	private void assignAge() {
		int year = Integer.parseInt(identificationNumber.substring(6,10));
		int month = Integer.parseInt(identificationNumber.substring(10,12));
		int day = Integer.parseInt(identificationNumber.substring(12,14));
		Calendar calendar = Calendar.getInstance();
		age = calendar.get(Calendar.YEAR) - year  - 1;
		if(calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.DATE) > day
				|| calendar.get(Calendar.MONTH) > month) {
			age += 1;
		}
	}

}
