package project6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer2 {
	
	public static void main(String[] args) throws FileNotFoundException
	  {
	    System.out.println("Working Directory = " + System.getProperty("user.dir"));
	    
	    // CHECKPOINT PART 1:
//	    File file = new File("src/project6/story.txt");
	    // CHECKPOINT PART 2:
	    File file = new File("../../lab5/src/lab5/SimpleLoops.java");
	    Scanner scanner = new Scanner(file);
	    int lineCount = 1;

	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine();
	      System.out.print(lineCount + " ");
	      System.out.println(line + " " + wordCounter(line));
	      lineCount += 1;
	    }
	    scanner.close();
	  }
	
	public static int wordCounter(String inLine) {
		String[] words = inLine.split(" ");
		return words.length;
	}
}




