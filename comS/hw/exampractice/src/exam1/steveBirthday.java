package exam1;

import java.util.Random;

public class steveBirthday {
	public static void main(String arg[]) {
		Random random = new Random();

		int randomDay = random.nextInt(30) + 1;
		int randomYear = random.nextInt(99) + 1900;

		System.out.print("September " + randomDay + ", " + randomYear);

	}
}
