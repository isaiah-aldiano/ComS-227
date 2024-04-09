package project6;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class checkpoint2 {
	private static Polyline parseOneLine(String line)
	{
		int pSize = -1;
		int i = 2;
		
		Polyline pl;
		
		String[] pli= line.split(" ");
		String color = pli[0];
		
		try {
			if(Integer.parseInt(pli[0]) > 0) {
				pSize = Integer.parseInt(pli[0]);
				color = pli[1];
			}
			
			pl = new Polyline(color, pSize);

		} catch (NumberFormatException e) {
			pl = new Polyline(color);
			i = 1;
		}
		
		for(int j = i; j < pli.length; j += 2) {
			int p1 = Integer.parseInt(pli[j]);
			int p2 = Integer.parseInt(pli[j + 1]);
			
			pl.addPoint(new Point(p1, p2));
		}
		
		return pl;
	}
	
	private static ArrayList<Polyline> readFile(String inFile) throws FileNotFoundException {
		ArrayList<Polyline> newPolyline = new ArrayList<Polyline>();
		
		File file = new File(inFile);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			System.out.println(line);
			Polyline newP = parseOneLine(line);
			newPolyline.add(newP);
		}
		
		return newPolyline;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
//		Plotter plotter = new Plotter();
//	    Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
//	    plotter.plot(p);
//	    
//	    p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
//	    plotter.plot(p);
		
		String file = "src/project6/hello.txt";
		ArrayList<Polyline> list = readFile(file);
		Plotter plotter = new Plotter();
		
		for(Polyline p : list) {
			plotter.plot(p);
		}
	}
}
