package FinalProject;


public class buildings {
	public int building = (int) (Math.random() * 10 + 1);;
	public String hallName;
	public String room;
	public int floornum = building/3+1;
	public String state = "useful";
	
	public buildings() {}
	public buildings(String hallName, int floornum, String room, String state) {
		this.hallName = hallName;
		this.floornum = floornum;
		this.room = room;
		this.state = state;
	}

	public static void main(String[] args) {
		buildings building = new geh();
		System.out.println(building.toString());
		buildings building2 = new ghk();
		System.out.println(building2.toString());
		buildings building3 = new slac();
		System.out.println(building3.toString());
		buildings building4 = new cbpm();
		System.out.println(building4.toString());
	}
}



class geh extends buildings{
	public geh() {}
	public geh(String hallName, int floornum, String room, String state,int building) {
		super(hallName,floornum, room, state);
	}
	public String hallName() {
		hallName = "geh";
		return hallName;		
	}

	public int floornum(int building, int i) {
		floornum = floornum(building,5);
		return floornum;
	}

	public String roomName() {
		int num = super.building/2;
		switch (building/4) {
		case 0:return "GEHa" + floornum + "0" + num;
		case 1:return "GEHb" + floornum + "0" + num;
		case 2:return "GEHc" + floornum + "0" + num;
		}
		return  "GEHd"+ floornum + "0" + num;
	}
	
	public String state() {
		if (super.building > 2) {
			state = "not useful";
			return state;
		}
		return state;
	}
	public String toString(){
		return "Today this guy entered the Hall "+ this.hallName()+ " till the floor " + floornum + " ,checked out the room " + this.roomName() + " and found this room is " + this.state() + ".\nthen the guy do some activities: ";
		}
}

class cbpm extends buildings{
	public cbpm () {}
	public cbpm (String hallName, int floornum, String room, String state,int building) {
		super(hallName,floornum, room, state);
	}
	public String hallName() {
		hallName = "cbpm";
		return hallName;		
	}

	public int floornum(int building, int i) {
		floornum = floornum(building,5);
		return floornum;
	}

	public String roomName() {
		int num = building/2;
		switch (super.building/4) {
		case 0:return room = "cbpmA" + floornum + "0" + num;
		case 1:return room = "cbpmB" + floornum + "0" + num;
		case 2:return room = "cbpmC" + floornum + "0" + num;
		}
		return room = "cbpmD" + floornum + "0" + num;
	}
	
	public String state() {
		if (super.building > 2) {
			state = "not useful";
			return state;
		}
		return state;
	}
	public String toString(){
		return "Today this guy entered the Hall "+ this.hallName()+ " till the floor " + floornum + " ,checked out the room " + this.roomName() + " and found this room is " + this.state() + ".\nthen the guy do some activities: ";
		}
}

class ghk extends buildings{
	public ghk () {}
	public ghk (String hallName, int floornum, String room, String state,int building) {
		super(hallName,floornum, room, state);
	}
	public String hallName() {
		hallName = "ghk";
		return hallName;		
	}

	public int floornum(int building, int i) {
		floornum = floornum(building,5);
		return floornum;
	}

	public String roomName() {
		int num = building/2;
		switch (super.building/4) {
		case 0:return room = "ghkA" + floornum + "0" + num;
		case 1:return room = "ghkB" + floornum + "0" + num;
		case 2:return room = "ghkC" + floornum + "0" + num;
		}
		return room = "ghkD" + floornum + "0" + num;
	}
	
	public String state() {
		if (super.building > 2) {
			state = "not useful";
			return state;
		}
		return state;
	}
	public String toString(){
		return "Today this guy entered the Hall "+ this.hallName()+ " till the floor " + floornum + " ,checked out the room " + this.roomName() + " and found this room is " + this.state + ".\nthen the guy do some activities: ";
		}
}

class slac extends buildings{
	public slac () {}
	public slac (String hallName, int floornum, String room, String state,int building) {
		super(hallName,floornum, room, state);
	}
	public String hallName() {
		hallName = "slac";
		return hallName;		
	}

	public int floornum(int building, int i) {
		floornum = floornum(building,5);
		return floornum;
	}

	public String roomName() {
		int num = building/2;
		switch (super.building/4) {
		case 0:return room = "slacA" + floornum + "0" + num;
		case 1:return room = "slacB" + floornum + "0" + num;
		case 2:return room = "slacC" + floornum + "0" + num;
		}
		return room = "slacD" + floornum + "0" + num;
	}
	
	public String state() {
		if (super.building > 2) {
			state = "not useful";
			return state;
		}
		return state;
	}
	public String toString(){
		return "Today this guy entered the Hall "+ this.hallName()+ " till the floor " + floornum + " ,checked out the room " + this.roomName() + " and found this room is " + this.state + ".\nthen the guy do some activities: ";
		}
}