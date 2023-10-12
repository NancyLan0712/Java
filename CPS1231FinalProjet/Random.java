package CPS1231FinalProjet;



public class Random extends java.security.SecureRandom{
	
	public Random() {
	}
	
	public char nextLowerCase() {
		return (char)('a' + this.nextInt(26));
	}
	public char nextUpperCase() {
		return (char)('A' + this.nextInt(26));
	}
	
	//signature:
	//nextCode (upperCaseCount:int, lowerCaseCount:int,numberCount: int)
	// --> String
	//purpose: Random create a code consists of specific amount of
	// uppercase letter, lowercase letter, numbers
	//example: nextCode(2,2,4) --> WWww0000
	//example: nextCode(1,2,4) --> Www0000
	public String nextCode(int upperCaseCount, int lowerCaseCount,int numberCount) {
		int length = upperCaseCount + lowerCaseCount + numberCount;
		String code = "";
		Random generator = new Random();
		int count =0,count1=0, count2=0;
		do {
			switch(generator.nextInt(3)) {
			case 0:
				if(count < upperCaseCount && code.length() < length) {
					code += generator.nextUpperCase();count++;
				}break;
			case 1:
				if(count1 < lowerCaseCount && code.length() < length) {
					code += generator.nextLowerCase();count1++;
				}break;
			case 2:
				if(count2 < numberCount && code.length() < length) {
					code += generator.nextInt(10);count2++;
				}break;
			}
		}while(code.length() != length);
		return code;
	}
}
