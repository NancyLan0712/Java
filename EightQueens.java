package example;
//first queen-->line1,column1
//second queen-->line2,column1(X)-->line2,column2....
//...
//first queen-->line1,column2
//...
//we can just use one-dimensional array to represent-->arr[8]={0,4,7,5,2,6,1}
//arr[i]=val,val-->(n+1)queen put on (n+1)line
public class EightQueens {

	public static void main(String[] args) {
		//show the map
		int[][] map = new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				map[i][j]=0;
			}
		}
		System.out.println("====map====");
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		EightQueens.position(map,0,0);
		System.out.println("====result====");
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}
//	sure the method-->down-->right
//	0-->blank, 1-->occupied,2-->can't put
	public static boolean position(int[][]map,int i,int j) {
		if(i==7) {
			return true;
		}
		else {
			if(map[i][j]==0) {
				for(int a=0;a<map[i].length;a++) {
					map[i][a]=2;
				}
				map[i][j]=1;
				map[i+1][j]=2;
				map[i+1][j+1]=2;
			}
//			if(position(map,i+1,j)) {
//				return true;
//			}
//			if(position(map,i+1,j+1)) {
//				return true;
//			}
			for(int a=0;a<8;a++) {
				for(int b=0;b<8;b++) {
					if(position(map,a,b)) {
						return true;
					}
				}
			}
//			else {
//				return false;
//			}
		}
		return true;
		
	}

}
