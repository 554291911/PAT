package A1050StringSubtraction20;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		Scanner in = new Scanner(System.in);
		String t = in.nextLine();
		String s = in.nextLine();
		char[] ss = s.toCharArray();
		for (int i = 0; i < ss.length; i++) {
			if (t.contains(ss[i] + ""))
				t = t.replaceAll(ss[i] + "", "");
		}
		System.out.println(t);
	}
}