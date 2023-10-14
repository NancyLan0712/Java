package FinalProject; 
import java.text.*;

abstract class person implements Comparable<person>{
	protected String name;
	protected String id;
	private String email;
	private String gender;
	private int age;
	
	public person() {
		
	}
	public person(String name,String id,String email,String gender) {
		this.name=name;
		this.id=id;
		this.email=email;
		this.gender=gender;
	}
	public String toString(){
		return name+"-"+"-"+gender+"-"+id+"-"+email;
	}
	@Override
    public int compareTo(person otherPerson) {
        int nameComparison = this.name.compareTo(otherPerson.name);
        if (nameComparison == 0) {
            return Integer.compare(this.age, otherPerson.age);
        } else {
            return nameComparison;
        }
    }
	protected abstract Object getId();
	protected abstract String getName();
}
class Student extends person{
	private int classState;
	private int age;
	public Student() {
	}
	public Student(String name, int age, String gender, String id, String email,int classState) {
		super(name, id, email, gender);
		this.classState = classState;
		this.age = age;
	}
	public String toString() {
		return "Student:"+super.toString()+"-"+classState;
	}
	@Override
	protected Object getId() {
		return id;
	}
	@Override
	protected String getName() {
		return name;
	}
}
class Staff extends person{
	private int classState;
	public Staff(String name, String gender, String id, String email) {
		super(name, id, email, gender);
	}
	public String toString() {
		return "Staff:"+super.toString();
	}
	@Override
	protected Object getId() {
		return id;
	}
	@Override
	protected String getName() {
		return name;
	}
}