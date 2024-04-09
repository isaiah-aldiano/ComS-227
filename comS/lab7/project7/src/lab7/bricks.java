package lab7;

public class bricks {
	public static void main(String args[]) {
		int size = 9;
		
		System.out.print(countPatterns(size));
	}
	
	private static int countPatterns(int size) {
		int total = 0;
		
		if(size < 0) {
			return 0;
		} else if (size == 0) {
			return 1;
		} else {
			total = countPatterns(size - 1) + countPatterns(size - 3);
		}
		
		return total;
	}
}