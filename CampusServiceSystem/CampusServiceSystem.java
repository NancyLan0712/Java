package CampusServiceSystem;


import project2.Dorm;
import project2.DormChangingApplicationSystem;
import project2.NoSuchDormException;
import project3.Garbage;
import project3.GarbageDisposalAssistantSystem;
import project4.SportsFacilityManagementSystem;

import java.awt.print.Book;
import java.util.Scanner;

import project.ItemLostReportingSystem;

public class CampusServiceSystem {

    public static void main(String[] args) throws ItemSystemException, NoSuchDormException {
        Scanner in=new Scanner(System.in);
        ItemLostReportingSystem itst=new ItemLostReportingSystem();
        DormChangingApplicationSystem dcst=new DormChangingApplicationSystem();
        GarbageDisposalAssistantSystem gdst=new GarbageDisposalAssistantSystem();
        SportsFacilityManagementSystem sfst=new SportsFacilityManagementSystem();
        boolean quit=false;
        while(!quit) {
            System.out.println("Welcome to Campus service system.");
            System.out.println("Please select the service you want to use:");
            System.out.println("1. Property loss reporting system\n2. Dormitary changing system\n"+
                     "3. Garbage Disposal Assistant System\n4. Sports Facility Management System\n"
                    +"5.library register system \n + 6. Campus Express Station Service System\n");
            System.out.println("Enter the correspond number to access the service: ");
            int service=in.nextInt();
            in.nextLine();
            switch(service) {
//	-------------------------------------------------------------------------------------------------------------
                case 1:
                    Scanner in1 = new Scanner(System.in);
                    System.out.println("Welcome to Property Loss Reporting System. We provide functions include:");
                    boolean quit1 = false;
                    while (!quit1) {
                        System.out.println("1. Showing lost items haven't been claimed\n2. Reporting new lost item\n"
                                + "3. Removing founded item");
                        System.out.println("Enter number to use function: ");
                        int function1 = in.nextInt();
                        switch (function1) {
                            case 1:
                                itst.showLostItems();
                                break;
                            case 2:
                                System.out.println("please submit the information of the reported item:");
                                System.out.println("What is the item: ");
                                String it = in1.nextLine();
                                System.out.println("Any information of the owner founded from the item?"
                                        + "(name/personal information such as phonenumber or student id)");
                                System.out.println("If you don't, type in \"unknown\"");
                                System.out.println("Owner's name: ");
                                String name = in1.nextLine();
                                System.out.println("Owner's personal information(such as phonenumber or student id):");
                                String info = in1.nextLine();
                                Item item = new Item(it, new Person(name, info));
                                System.out.println("Enter the place you found it: ");
                                Place place = new Place(in1.nextLine());
                                itst.addLostItem(item, place);
                                break;
                            case 3:
                                System.out.println("Please enter the information of the removed item:");
                                System.out.println("Item type:");
                                String removedItem = in1.nextLine();
                                System.out.println("Found location: ");
                                String foundPlace = in1.nextLine();
                                itst.removeItem(removedItem, foundPlace);
                                break;
                        }
                        System.out.println("Do you want to quit the Property Loss Reporting System?(Yes/No)");
                        String q1 = in1.nextLine().trim();
                        if (q1.equalsIgnoreCase("Yes") || q1.equalsIgnoreCase("yes")) {
                            quit1 = true;
                        }
                    }
                    break;
//	-------------------------------------------------------------------------------------------------------
                case 2:
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Welcome to Dormitary Changing System. We support following functions:");
                    boolean quit2 = false;
                    while (!quit2) {
                        System.out.println("1. Showing all available dorms\n2. Adding available dorm\n"
                                + "3. Deleting dorm(if the dorm is not available anymore)\n4. Dorm application");
                        System.out.println("Enter number to use function: ");
                        int function2 = in.nextInt();
                        switch (function2) {
                            case 1:
                                dcst.showSystem();
                                break;
                            case 2:
                                System.out.println("please input the information of the available dorm:");
                                System.out.println("Dorm location:");
                                String dormLocation = in2.nextLine();
                                System.out.println("Dorm initial capacity:");
                                int initialCapacity = in2.nextInt();
                                System.out.println("Dorm current capacity (remaining beds):");
                                int currentCapacity = in2.nextInt();
                                dcst.addAvailableDorm(new Dorm(dormLocation, initialCapacity), currentCapacity);
                                in2.nextLine();
                                break;
                            case 3:
                                System.out.println("Enter the location of the removed dorm: ");
                                String removedDormLocation = in2.nextLine();
                                dcst.removeAvailableDorm(removedDormLocation);
                                break;
                            case 4:
                                System.out.println("Enter the applied dorm location(like \"Plum A104\"): ");
                                String appliedDorm = in2.nextLine();
                                dcst.applyForDorm(appliedDorm);
                                break;
                        }
                        System.out.println("Do you want to quit the Dormitary Changing System?(Yes/No)");
                        String q2 = in2.nextLine();
                        if (q2.equalsIgnoreCase("Yes") || q2.equalsIgnoreCase("yes")) {
                            quit2 = true;
                        }
                    }
                    break;
//	---------------------------------------------------------------------------------------------------------
                case 3:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("Welcome to Garbage Disposal Assistant System."
                            + "\nFor further announcement, Old garbages should be handled before the later ones.");
                    boolean quit3 = false;
                    while (!quit3) {
                        System.out.println("We support following services:");
                        System.out.println("1. Reporting new garbage\n2. Listing all unhanded garbages\n"
                                + "3. Deleting cleaned garbage");
                        System.out.println("Enter number to use function: ");
                        int function3 = in.nextInt();
                        switch (function3) {
                            case 1:
                                System.out.println("Enter the basic information of the garbage");
                                System.out.println("Garbage type:");
                                String garbageType = in3.nextLine();
                                System.out.println("Description of garbage(such as \"poured drinks\"):");
                                String description = in3.nextLine();
                                System.out.println("Found location: ");
                                String garbageLocation = in3.nextLine();
                                gdst.addNewGarbage(new Garbage(garbageType, description), new Place(garbageLocation));
                                break;
                            case 2:
                                gdst.showCurrentGarbages();
                                break;
                            case 3:
                                System.out.println("Is the latest garbage cleaned?(Yes/No)");
                                String answer = in3.nextLine();
                                if (answer.equals("Yes") || answer.equals("yes")) {
                                    gdst.deleteGarbage();
                                    System.out.println("Successfully deleted");
                                }
                                break;
                        }
                        System.out.println("Do you want to quit the Garbage Disposal Assistant System?(Yes/No)");
                        String q3 = in3.nextLine().trim();
                        if (q3.equalsIgnoreCase("Yes") || q3.equalsIgnoreCase("yes")) {
                            quit3 = true;
                        }
                    }
                    break;
//	------------------------------------------------------------------------------------------------------
                case 4:
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("Welcome to Sports Facility Management System. We support following functions:");
                    boolean quit4 = false;
                    while (!quit4) {
                        System.out.println("1. Adding new facility\n2. Booking facility\n"
                                + "3. Releasing facility\n4. Showing all available facilities");
                        System.out.println("Enter number to use function: ");
                        int function4 = in.nextInt();
                        switch (function4) {
                            case 1:
                                System.out.println("Please enter the added facility type:");
                                String facilityType = in4.nextLine();
                                sfst.addFacility(facilityType);
                                break;
                            case 2:
                                System.out.println("Please enter the booked facility:");
                                String bookedFacility = in4.nextLine();
                                sfst.bookFacility(bookedFacility);
                                break;
                            case 3:
                                System.out.println("Please enter the released facility:");
                                String releasedFacility = in4.nextLine();
                                sfst.releaseFacility(releasedFacility);
                                break;
                            case 4:
                                sfst.displayFacilities();
                                break;
                        }
                        System.out.println("Do you want to quit the Garbage Disposal Assistant System?(Yes/No)");
                        String q4 = in4.nextLine().trim();
                        if (q4.equalsIgnoreCase("Yes") || q4.equalsIgnoreCase("yes")) {
                            quit4 = true;
                        }
                    }
                    break;
//	------------------------------------------------------------------------------------------------------
                case 5:
                    System.out.println("Welcome to Property Loss Reporting System. We provide functions include:");
                    boolean quit5=false;
                    Scanner scanner = new Scanner(System.in);
                    SingleLinkedList bookList = new SingleLinkedList();
                    SingleLinkedList borrowedBooks = new SingleLinkedList();

                    while (!quit5) {

                        System.out.println("Book Management System");
                        System.out.println("1. Add Book");
                        System.out.println("2. Add Book by Order");
                        System.out.println("3. Get Book by Name");
                        System.out.println("4. Get Book by Author");
                        System.out.println("5. Update Book");
                        System.out.println("6. Delete Book");
                        System.out.println("7. Borrow Book");
                        System.out.println("8. Print Book List");
                        System.out.println("9. Print Borrowed Books");
                        System.out.println("10. Insert Book:");
                        System.out.println("11. Exit");

                        System.out.print("Choose an option: ");

                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (choice) {

                            case 1:
                                // Add Book
                                System.out.println("Enter book name:");
                                String name = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String author = scanner.nextLine();
                                System.out.println("Enter book number:");
                                int number = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline
                                Book newBook = new Book(name, author, number);
                                bookList.add(newBook);
                                break;
                            case 2:
                                // Add Book by Order
                                System.out.println("Enter book name:");
                                String orderedName = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String orderedAuthor = scanner.nextLine();
                                System.out.println("Enter book number:");
                                int orderedNumber = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline
                                Book orderedBook = new Book(orderedName, orderedAuthor, orderedNumber);
                                bookList.addByOrder(orderedBook);
                                break;
                            case 3:
                                // Get Book by Name
                                System.out.println("Enter the name of the book:");
                                String searchName = scanner.nextLine();
                                Book bookByName = bookList.getBookByName(searchName);
                                System.out.println(bookByName != null ? bookByName : "Book not found");
                                break;
                            case 4:
                                // Get Book by Author
                                System.out.println("Enter the author of the book:");
                                String searchAuthor = scanner.nextLine();
                                Book bookByAuthor = bookList.getBookByAuthor(searchAuthor);
                                System.out.println(bookByAuthor != null ? bookByAuthor : "Book not found");
                                break;
                            case 5:
                                // Update Book
                                System.out.println("Enter the number of the book to update:");
                                int updateNumber = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline
                                System.out.println("Enter new name:");
                                String updateName = scanner.nextLine();
                                System.out.println("Enter new author:");
                                String updateAuthor = scanner.nextLine();
                                Book updateBook = new Book(updateName, updateAuthor, updateNumber);
                                bookList.upDate(updateBook);
                                break;
                            case 6:
                                // Delete Book
                                System.out.println("Enter the number of the book to delete:");
                                int deleteNumber = scanner.nextInt();
                                bookList.delete(deleteNumber);
                                break;
                            case 7:
                                // Borrow Book
                                System.out.println("Enter the number of the book to borrow:");
                                int borrowNumber = scanner.nextInt();
                                bookList.borrow(borrowNumber, borrowedBooks);
                                break;
                            case 8:
                                // Print Book List
                                System.out.println("Book List:");
                                bookList.list();
                                break;
                            case 9:
                                // Print Borrowed Books
                                System.out.println("Borrowed Books:");
                                borrowedBooks.list();
                                break;
                            case 10:
                                System.out.println("Position you want to insert :");
                                int position =scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Enter book name:");
                                String Insertname = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String Insertauthor = scanner.nextLine();
                                System.out.println("Enter book number:");
                                int Insertnumber = scanner.nextInt();


                                scanner.nextLine(); // Consume the newline
                                Book bookInsert = new Book(Insertname,Insertauthor,Insertnumber);
                                bookList.insert(bookInsert, position);



                                break;
                            case 11:
                                System.out.println("Exiting the system.");
                                quit5 = true;
                                scanner.close();
                                return;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
//	------------------------------------------------------------------------------------------------------
                case 6:
                    Scanner in6 = new Scanner(System.in);
                    Package p1 = new Package("Jared", "12345678");
                    Package p2 = new Package("Jared", "12341234");
                    Package p3 = new Package("Jared", "12343218");
                    Package p4 = new Package("Lucas", "12345233");
                    System.out.println("Welcome to Campus Express Station Service System. We support following functions:");
                    Administrator administrator = new Administrator();
                    administrator.ExpressWarehousing(p1);
                    administrator.ExpressWarehousing(p2);
                    administrator.ExpressWarehousing(p3);
                    administrator.ExpressWarehousing(p4);
                    User user = new User("Jared");

                    boolean quit6 = false;
                    while (!quit6) {
                        System.out.println(
                                "1. Search the delivery by name\n" +
                                 "2. Search the historical order pickup\n" +
                                 "3. Pickup\n" +
                                 "Enter number to use function:");
                        String choice = in6.nextLine();
                        switch (choice) {
                            case "1":
                                System.out.println("Please enter your name: ");
                                String s = in6.nextLine();
                                user.searchInformation(s);
                                break;
                            case "2":
                                System.out.println("Please enter your name: ");
                                String ss = in6.nextLine();
                                user.queryHistory(ss);
                                break;
                            case "3":
                                System.out.println("Please enter your name: ");
                                String name = in6.nextLine();
                                System.out.println("Please enter your order number: ");
                                String orderNumber = in6.nextLine();
                                user.pickUp(name, orderNumber);
                                break;
                        }
                        System.out.println("Do you want to quit the Campus Express Station Service System?(Yes/No)");
                        String q6 = in6.nextLine().trim();
                        if (q6.equalsIgnoreCase("Yes") || q6.equalsIgnoreCase("yes")) {
                            quit6 = true;
                      }
                    }
            }
//	------------------------------------------------------------------------------------------------------
        case 7:
		        	System.out.println("Welcome to  Dormitory Access System. We provide functions include:");
		            boolean quit7=false;

        	        Scanner scanner = new Scanner(System.in);
        	        SingleLinkedList studentList = new SingleLinkedList();
        	        SingleLinkedList enteredStudents = new SingleLinkedList();

        	        while (!quit) {
        	            System.out.println("School Dormitory Access System");
        	            System.out.println("1. Student Check-In");
        	            System.out.println("2. Student Check-Out");
        	            System.out.println("3. View Entered Students");
        	            System.out.println("4. Exit");

        	            System.out.print("Choose an option: ");

        	            int choice = scanner.nextInt();
        	            scanner.nextLine(); 

        	            switch (choice) {
        	                case 1:
       
        	                    System.out.println("Enter student name:");
        	                    String studentNameIn = scanner.nextLine();
        	                    Student enteredStudentIn = new Student(studentNameIn, choice, studentNameIn, studentNameIn, studentNameIn, choice);
        	                    studentList.add(enteredStudentIn);
        	                    enteredStudents.addByOrder(enteredStudentIn);
        	                    System.out.println(studentNameIn + " checked in.");
        	                    break;

        	                case 2:
        	                   
        	                    System.out.println("Enter student name to check out:");
        	                    String studentNameOut = scanner.nextLine();
        	                    Student checkedOutStudent = studentList.getStudentByName(studentNameOut);
        	                    if (checkedOutStudent != null) {
        	                        enteredStudents.delete(checkedOutStudent);
        	                        System.out.println(studentNameOut + " checked out.");
        	                    } else {
        	                        System.out.println("Student not found.");
        	                    }
        	                    break;

        	                case 3:
        	                    
        	                    System.out.println("Entered Students:");
        	                    enteredStudents.list();
        	                    break;

        	                case 4:
        	                    System.out.println("Exiting the system.");
        	                    quit = true;
        	                    scanner.close();
        	                    break;

        	                default:
        	                    System.out.println("Invalid choice. Please try again.");
        	                    break;
        	            }
        	        }
        	    }

        	class Student {
        	    private String name;

        	    public Student(String name) {
        	        this.name = name;
        	    }

        	    public String getName() {
        	        return name;
        	    }

        	    @Override
        	    public String toString() {
        	        return "Student: " + name;
        	    }
        	}
        	

//------------------------------------------------------------------------------------------------------
            System.out.println("Do you want to quit the whole system?(Yes/No)");
            String q=in.next().trim();
            in.nextLine();
            if(q.equalsIgnoreCase("Yes")||q.equalsIgnoreCase("yes")) {
                quit=true;
            }
        }
        in.close();


//		各位，加功能的时候可能需要创建新的Scanner对象，但是只能在最后加上一个in.close()，不能在case里就close新创建的Scanner对象，要不然会报错。
//		我也没搞明白为啥，还是就按照前面的格式写吧。
    }

	private static void manageDormitory(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
}
