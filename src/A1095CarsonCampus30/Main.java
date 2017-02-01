package A1095CarsonCampus30;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

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
		Scanner in = new Scanner(System.in);
		TreeMap<String, String> pass = new TreeMap<String, String>();
		TreeMap<String, String> out = new TreeMap<String, String>();
		int n = in.nextInt();
		int l = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String time = in.next();
			String type = in.next();
			if (type.equals("in"))
				pass.put(time, name);
			else
				out.put(time, name);
		}
		for (int i = 0; i < args.length; i++) {

		}
		System.out.println();
	}
}