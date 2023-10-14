package example;
//1,1,2,3,5,8,13
//n=1-->1=1
//n=2-->1=1
//n=3-->2=1+1
//n=4-->3=1+2
//n=(n-2)+(n-1)

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(num(6));

	}
public static int num(int n) {
	if(n>=1&&n<=2) {
		return 1;
	}
	else if(n>2) {
		return num(n-2)+num(n-1);
	}
	else {
		System.out.println("number should bigger than 1");
		return -1;
	}
}

}
