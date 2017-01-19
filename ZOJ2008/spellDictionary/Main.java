package spellDictionary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		String[] map = new String[100000];
		int num = 0;
		while (true) {
			String line = in.nextLine();
			if (line.equals("@END@"))
				break;
			map[num++] = line;
		}
		int n = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String t = in.nextLine();
			String r = "";
			for (int j = 0; j < num; j++) {
				if (map[j].startsWith(t)) {
					String[] p = map[j].split("]");
					r = p[1].substring(1);
					break;
				}
				if (map[j].endsWith(t)) {
					String[] p = map[j].split("]");
					r = p[0].substring(1);
					break;
				}
			}
			if (r.equals(""))
				System.out.println("what?");
			else
				System.out.println(r);
		}
	}
}