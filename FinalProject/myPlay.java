package FinalProject; 
import java.util.Random;

//Play class
public class myPlay extends myActivities {
    //data fields
	private String[] playActivities = {"computerGame", "Switch", "tableGame"};
	private Random random = new Random();
    
    //constructor
    public myPlay(String studentID) {
        super(studentID);
    }

    @Override
    public String activityTime() {
        int min = random.nextInt(100) + 1;
        return "Play Time: " + min + " min";
    }

    @Override
    public String getOutput() {
        int winCount = random.nextInt(5) + 1;
        int lossCount = random.nextInt(5) + 1;
        return "win : " + winCount + " times\nloss: " + lossCount + " times";
    }

    @Override
    public String getActivity() {
        int index = random.nextInt(playActivities.length);
        return playActivities[index];
    }

    @Override
    public String withWho() {
        int randomStudentID = random.nextInt(1000000)+1000000 ;
        return "with Student (id: " + randomStudentID + " ) together";
    }

    public String myGame() {
   	 String[] games = {
   		     "The Witcher 3: Wild Hunt",
   		     "Counter-Strike: Global Offensive",
   		     "PlayerUnknown's Battlegrounds",
   		     "Dota 2",
   		     "Grand Theft Auto V",
   		     "Settlers of Catan",
   		     "Codenames",
   		     "Werewolf",
   		     "Snakes and Ladders",
   		     "Risk",
   		     "The Legend of Zelda: Breath of the Wild",
   		     "Mario Kart 8 Deluxe",
   		     "Animal Crossing: New Horizons",
   		     "Super Mario Odyssey",
   		     "The Legend of Zelda: Link's Awakening"
   		 };
        int index = random.nextInt(games.length);
        return "My game: " + games[index];
    }

    @Override
    public String toString() {
        return super.toString() + "\nActivity: " + getActivity() + "\n" + getOutput() + "\n" + activityTime() + "\n" +
            withWho() + "\n" + myGame();
    }
    
    public static void main(String[] args) {
        myPlay play = new myPlay("2021003");
        System.out.println(play.toString());
    }
}



 











