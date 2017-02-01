package ApB;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static boolean LOCAL = System.getSecurityManager() == null;

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while (in.hasNextLine()) {
			String a = in.nextLine();
			a = a.replaceAll(",", "");
			String[] as = a.split(" ");
			System.out.println(Integer.valueOf(as[0]) + Integer.valueOf(as[1]));
		}
	}
}