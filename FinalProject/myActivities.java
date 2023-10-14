package FinalProject; 
import java.util.Random;

public abstract class myActivities {
    
	//data fields
	private String studentID;
    private String interest;

    //constructors
    public myActivities(String studentID) {
        this.studentID = studentID;
        //generate random interest
        String[] interests = {"Sports", "Academic", "Games"};
        Random random = new Random();
        int index = random.nextInt(interests.length);
        this.interest = interests[index];
        
    }
    
    //methods
    public String getStudentID() {
        return studentID;
    }

    public String getInterest() {
        return interest;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public abstract String activityTime();

    public abstract String getOutput();

    public abstract String getActivity();

    public abstract String withWho();

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nInterest: " + interest;
    }

   
}
