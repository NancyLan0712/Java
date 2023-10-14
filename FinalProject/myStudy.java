package FinalProject; 
import java.util.Random;

//Study class
public class myStudy extends myActivities {
    //data fields
	private String[] studyActivities = {"reading", "studying", "reviewing", "programming"};
    private Random random = new Random();
    
    //constructor
    public myStudy(String studentID) {
        super(studentID);
    }

    @Override
    public String activityTime() {
        int min = random.nextInt(100) + 1;
        return "Sports Time: " + min + " min";
    }

    @Override
    public String getOutput() {
        String[] efficiencyLevels = {"A", "B", "C", "D"};
        int index = random.nextInt(efficiencyLevels.length);
        return "Learning efficiency: " + efficiencyLevels[index];
    }

    @Override
    public String getActivity() {
        int index = random.nextInt(studyActivities.length);
        return studyActivities[index];
    }

    @Override
    public String withWho() {
        int randomStudentID = random.nextInt(1000000)+1000000;
        return "with Student (id: " + randomStudentID + " ) together";
    }

    public boolean isFinishedHW() {
        return random.nextBoolean();
    }

    public String getMyBook() {
        String[] books = {
            "To Live - Yu Hua",
            "《1984》 - George Orwell",
            "《红楼梦》- 曹雪芹",
            "《Pride and Prejudice》- Jane Austen",
            "《平凡的世界》- 路遥",
            "《To Kill a Mockingbird》- Harper Lee",
            "《西游记》- 吴承恩",
            "《The Catcher in the Rye》- J.D. Salinger",
            "《围城》- 钱钟书",
            "《Brave New World》- Aldous Huxley"
        };
        int index = random.nextInt(books.length);
        return "My Book: " + books[index];
    }

    @Override
    public String toString() {
        return super.toString() + "\nActivity: " + getActivity() + "\n" + getOutput() + "\n" + activityTime() + "\n" +
            withWho() + "\nHomeWork Finished or not: " + isFinishedHW() + "\n" + getMyBook();
    }
    
    public static void main(String[] args) {
        myStudy study = new myStudy("202100");
        System.out.println(study.toString());
    }
}

 



 











