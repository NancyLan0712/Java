package CampusServiceSystem;

import java.util.*;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        Map<String, Person> personMap = new HashMap<>();
        Map<String, List<Action>> actionMap = new HashMap<>();

        boolean running = true;

        while (running) {
            System.out.println("1. Add student/staff");
            System.out.println("2. Add activity");
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
                                    // Add student
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
                                    Person student = new Student(name, age, gender, id, email, classState);
                                    personMap.put(id, student);
                                    break;

                                case "2":
                                    // Add staff
                                    System.out.print("Please enter staff's name: ");
                                    String staffName = scanner.nextLine();
                                    System.out.print("Please enter staff's id: ");
                                    String staffId = scanner.nextLine();
                                    System.out.print("Please enter staff's email: ");
                                    String staffEmail = scanner.nextLine();
                                    System.out.print("Please enter staff's gender: ");
                                    String staffGender = scanner.nextLine();
                                    Person staff = new Staff(staffName, staffGender, staffId, staffEmail);
                                    personMap.put(staffId, staff);
                                    break;

                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        } while (!temp.equals("1") && !temp.equals("2"));
                        break;

                    case 2:
                        // Add activity
                        System.out.print("Please enter student's id: ");
                        String studentId = scanner.nextLine();
                        if (personMap.containsKey(studentId)) {
                            System.out.print("Enter action for student: ");
                            String action = scanner.nextLine();
                            Action studentAction = new Action(personMap.get(studentId).getName(), action);

                            if (!actionMap.containsKey(studentId)) {
                                actionMap.put(studentId, new ArrayList<>());
                            }

                            actionMap.get(studentId).add(studentAction);
                        } else {
                            System.out.println("No student with the provided ID found.");
                        }
                        break;

                    case 3:
                        // Search student
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
                                    // Print all registration information
                                    System.out.println("\nAll Registration Information:");
                                    for (Person person : personMap.values()) {
                                        System.out.println(person.toString());
                                    }
                                    break;

                                case "2":
                                    // Search student's activity
                                    System.out.print("Please enter the student's id: ");
                                    String queryId = scanner.nextLine();

                                    if (actionMap.containsKey(queryId)) {
                                        System.out.println(personMap.get(queryId).getName() + "'s activities:");
                                        List<Action> activities = actionMap.get(queryId);
                                        if (!activities.isEmpty()) {
                                            for (Action action : activities) {
                                                System.out.println("- " + action.getAction());
                                            }
                                        } else {
                                            System.out.println("No activities found for " + personMap.get(queryId).getName());
                                        }
                                    } else {
                                        System.out.println("No student with the provided ID found.");
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

class Person {
    private String name;
    // other common attributes and methods

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // other getters and setters
}

class Student extends Person {
    private int age;
    private String gender;
    private String id;
    private String email;
    private int classState;

    public Student(String name, int age, String gender, String id, String email, int classState) {
        super(name);
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.email = email;
        this.classState = classState;
    }

    // other getters and setters
}

class Staff extends Person {
    private String gender;
    private String id;
    private String email;

    public Staff(String name, String gender, String id, String email) {
        super(name);
        this.gender = gender;
        this.id = id;
        this.email = email;
    }

    // other getters and setters
}

class Action {
    private String name;
    private String action;

    public Action(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getAction() {
        return action;
    }


    // getters and setters
}
