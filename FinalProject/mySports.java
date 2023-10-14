package FinalProject; 
import java.util.Random;

//Sports class
public class mySports extends myActivities {
    private String[] sportsActivities = {
            "Baketball", "Swimming", "PingPong", "Volleyball", "Badminton",
            "Teneis", "CrossFit", "Jogging", "Flying Saucer","Hide-and-Seek"
    };
    private Random random = new Random();

    public mySports(String studentID) {
        super(studentID);
    }

    @Override
    public String activityTime() {
        int min = random.nextInt(100) + 1;
        return "Sports Time: " + min + " min";
    }

    @Override
    public String getOutput() {
        int calories = random.nextInt(500) + 1000;
        return "Consumption: " + calories + " calories";
    }

    @Override
    public String getActivity() {
        int index = random.nextInt(sportsActivities.length);
        return sportsActivities[index];
    }

    @Override
    public String withWho() {
        int randomStudentID = random.nextInt(1000000)+1000000;
        return "with Student (id: " + randomStudentID + " ) together";
    }

    public String getCondition() {
        String[] conditions = {"tired", "energized", "cramp", "injured", "excited"};
        int index = random.nextInt(conditions.length);
        return "Sports condition: " + conditions[index];
    }

    public String getMySneaker() {
        String[] sneakers = {"Adidas", "Nike", "Jordan", "New Balance", "足力健"};
        int index = random.nextInt(sneakers.length);
        return "Sports sneaker: " + sneakers[index];
    }

    @Override
    public String toString() {
    	return super.toString() + "\n " + activityTime() + "\n " + getActivity() + "\n" + getOutput()  + "\n" + withWho() + "\n" + getCondition() + "\n" + getMySneaker();
    }

    public static void main(String[] args) {
        mySports sports = new mySports("2021001");
        System.out.println(sports.toString());
    }
}

