package example;
//1.use a array to represent the labyrinth(8x7)--> int[][] map = new int[8][7]
//2. 0-->can go; 1-->can't go
/*
 1111111
 1     1
 1     1
 111   1
 1     1
 1     1
 1     1
 1111111
 */

public class Labyrinth {

	public static void main(String[] args) {
		int[][] map = new int[8][7];
		//make the first line and the last line be 1
		for(int i=0;i<7;i++) {
			map[0][i]=1;
			map[7][i]=1;
		}
		//make the first column and the last column be 1
		for(int i=0;i<8;i++) {
			map[i][0]=1;
			map[i][6]=1;
		}
		//make the first three in the forth line be 1
		for(int i=0;i<3;i++) {
			map[3][i]=1;
		}
		System.out.println("===map===");
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
//		T t = new T();
		System.out.println("\n===result====");
//		Labyrinth t = new Labyrinth();
		Labyrinth.findWay(map, 1, 1);
//		t.findWay(map, 1, 1);
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}
//static class T{
	//i-->the x-coordinate
	//j-->the y-coordinate
	//(1,1)-->(6,5)-->the mouse out of the labyrinth
	//0-->can go, 1-->can't go, 2-->can go(have taken), 3-->can't go(have taken)
	//decide the sign that finish the recursive: map[6][5]-->2-->find the way
	//first sure the direction(method) that find the way-->down-right-up-left(change the method will make the way change)
	public static boolean findWay(int[][] map,int i,int j) {
		if(map[6][5]==2) {
			return true;
		}
		else {
			if(map[i][j]==0) {
				//suppose can go
				map[i][j]=2;
				//use the method
				if(findWay(map,i+1,j)) {
					return true;//first down
				}
				else if(findWay(map,i,j+1)) {
					return true;//right
				}
				else if(findWay(map,i-1,j)) {
					return true;//up
				}
				else if(findWay(map,i,j-1)) {
					return true;//left
				}
				else {
					map[i][j]=3;
					return false;
				}
			}
			else {
				return false;
			}
		}
	}

}
//}
/*
 11111
 1   1
 1 1 1 
 11111
 In this case, the traceback will hanppen(same method with example)
 map[1][1]--> map[2][1]-->map[1][1]
 */
//How to compute the shortest way?