package A1047StudentListforCourse25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		String[] s = new String[n];
		ArrayList<Integer>[] cs = new ArrayList[c + 1];
		String[] names = new String[n];
		in.nextLine();
		for (int i = 0; i < n; i++) {
			s[i] = in.nextLine();
			names[i] = s[i].substring(0, 4);
		}
		Arrays.sort(names);
		for (int i = 1; i < cs.length; i++) {
			cs[i] = new ArrayList<Integer>();
			for (int j = 0; j < s.length; j++) {
				if (s[j].substring(7).contains("" + i)) {
					int j2;
					for (j2 = 0; j2 < names.length; j2++) {
						if (s[j].substring(0, 4).equals(names[j2]))
							break;
					}
					if (j2 != names.length)
						cs[i].add(j2);
				}
			}
			Collections.sort(cs[i]);
		}
		for (int i = 1; i < cs.length; i++) {
			System.out.println(i + " " + cs[i].size());
			for (int j = 0; j < cs[i].size(); j++)
				System.out.println(names[cs[i].get(j)]);
		}
	}
}