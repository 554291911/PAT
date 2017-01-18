package statisticalCharacter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (true) {
			String s = in.nextLine();
			if (s.equals("#"))
				return;
			char[] flag = s.toCharArray();
			String t = in.nextLine();
			for (int i = 0; i < flag.length; i++) {
				int num = 0;
				char[] c = t.toCharArray();
				for (int j = 0; j < c.length; j++) {
					if (flag[i] == c[j])
						num++;
				}
				System.out.println(flag[i] + " " + num);
			}
		}
	}
}