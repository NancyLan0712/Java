package CampusServiceSystem;

class SingleLinkedList1 {
    private Node head;

    // Node class to represent elements in the linked list
    private static class Node {
        private Student data;
        private Node next;

        public Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor for SingleLinkedList
    public SingleLinkedList1() {
        this.head = null;
    }

    // Add a student to the linked list
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Delete a student from the linked list
    public void delete(Student student) {
        if (head == null) {
            return;
        }

        if (head.data.equals(student)) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.data.equals(student)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return; // Student not found in the list
        }

        previous.next = current.next;
    }

    // List all students in the linked list
    public void list() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void addByOrder(Student student) {
        Node newNode = new Node(student);
        
        if (head == null || student.getName().compareTo(head.data.getName()) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && student.getName().compareTo(current.data.getName()) > 0) {
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    // Get a student from the linked list by name
    public Student getStudentByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Student not found
    }
}
