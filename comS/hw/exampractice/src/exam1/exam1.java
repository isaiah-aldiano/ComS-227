package exam1;

public class exam1 {
	public static void main(String args[]) {
		int fullCartons = 49 / 12;
//
//		System.out.print(fullCartons);
//
		String temp = "A full string";
		String temp2 = "A full string";
//
//		System.out.print(temp.charAt(temp.length() - 1));

//		boolean has4 = temp.length() >= 4;

//		System.out.print(has4);

		boolean theSame = temp == temp2;

		int d = 32;
		int c = 42;

		double total = d + ((double) c / 100);

//		System.out.print(total);

		double b = 23.43;

//		System.out.print((int) b);

		Mystery m = new Mystery(5);
		System.out.println(m.brew(20)); // line 1
		System.out.println(m.brew(-9)); // line 2
		System.out.println(m.brew(5)); // line 3
		System.out.println(m.brew(5)); // line 4

	}
}
