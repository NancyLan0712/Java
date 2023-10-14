package FinalProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        ArrayList<person> personList = new ArrayList<>();
        ArrayList<myActivities> actList = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("1. Add student/staff");
            System.out.println("2. Generate activity");
            System.out.println("3. Search student");
            System.out.println("4. Log out");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        do {
                            System.out.println("1 -> Student\n2 -> Staff");
                            temp = scanner.nextLine();

                            switch (temp) {
                                case "1":
                                    System.out.print("Please enter student's name: ");
                                    String name = scanner.nextLine();
                                    System.out.print("Please enter student's id: ");
                                    String id = scanner.nextLine();
                                    System.out.print("Please enter student's email: ");
                                    String email = scanner.nextLine();
                                    System.out.print("Please enter student's age: ");
                                    int age = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Please enter student's gender: ");
                                    String gender = scanner.nextLine();
                                    System.out.print("Please enter student's class state: ");
                                    int classState = scanner.nextInt();
                                    scanner.nextLine();
                                    person student = new Student(name, age, gender, id, email, classState);
                                    personList.add(student);
                                    break;
                                case "2":
                                    System.out.print("Please enter staff's name: ");
                                    String staffName = scanner.nextLine();
                                    System.out.print("Please enter staff's id: ");
                                    String staffId = scanner.nextLine();
                                    System.out.print("Please enter staff's email: ");
                                    String staffEmail = scanner.nextLine();
                                    System.out.print("Please enter staff's gender: ");
                                    String staffGender = scanner.nextLine();
                                    person staff = new Staff(staffName, staffGender, staffId, staffEmail);
                                    personList.add(staff);
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        } while (!temp.equals("1") && !temp.equals("2"));
                        break;

                    case 2:
                        System.out.print("Please enter student's id: ");
                        String studentId = scanner.nextLine();
                        boolean found = false;

                        for (person person : personList) {
                            if (person.getId().equals(studentId)) {
                                found = true;                                
                                int random = (int)(Math.random()*3);
                                myActivities studentAct;
                                if (random == 0) { 
                                	studentAct = new mySports(studentId);
                                	actList.add(studentAct);
                                }
                                if (random == 1) { 
                                	studentAct = new myStudy(studentId);
                                	actList.add(studentAct);
                                }
                                if (random == 2) { 
                                	studentAct = new myPlay(studentId);
                                	actList.add(studentAct);
                                }
                                
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("No student with the provided ID found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter administrator password: ");
                        String password = scanner.nextLine();

                        if (!password.equals("123")) {
                            System.out.println("Invalid Password\n");
                            break;
                        }

                        do {
                            System.out.println("\n1. Print all registration information");
                            System.out.println("2. Search student's activity");
                            System.out.println("3. Log out");
                            System.out.print("Enter your choice: ");
                            temp = scanner.nextLine();

                            switch (temp) {
                                case "1":
                                    System.out.println("\nAll Registration Information:");
                                    for (person person : personList) {
                                        System.out.println(person.toString());
                                    }
                                    break;
                                case "2":
                                    System.out.print("Please enter the student's id: ");
                                    String queryId = scanner.nextLine();
                                    found = false;

                                    for (person person : personList) {
                                        if (queryId.equals(person.getId())) {
                                            found = true;
                                            
                                            for (myActivities a : actList) {
                                            	if (a.getStudentID().equals(person.getId())) {
                                                    Date current = new Date();
                                            		System.out.println("------"+current+"------");
                                            		// random building condition 
                                                    int random = (int)(Math.random()*4);
                                                    buildings currentSituation;
                                                    if (random == 0) { 
                                                    	currentSituation = new geh();
                                                    	System.out.println(currentSituation.toString());
                                                    }
                                                    if (random == 1) { 
                                                    	currentSituation = new cbpm();
                                                    	System.out.println(currentSituation.toString());
                                                    }
                                                    if (random == 2) { 
                                                    	currentSituation = new ghk();
                                                    	System.out.println(currentSituation.toString());
                                                    }
                                                    if (random == 3) { 
                                                    	currentSituation = new slac();
                                                    	System.out.println(currentSituation.toString());
                                                    }
                                                    
                                                    // then, output activities
                                                    System.out.println("------" + person.getName() + "'s activities record:------");
                                            		System.out.println(a.toString());
                                                    
                                            	}
                                            }
                                                                             
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        System.out.println("No student with the provided id found.");
                                    }
                                    break;
							case "3":
                                    running = false;
                                    break;

                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        } while (!temp.equals("3"));
                        break;

                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input");
                scanner.nextLine();
            }
        }

        System.out.println("Logged out successfully.");
        scanner.close();
    }
}
