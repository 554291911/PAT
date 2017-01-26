package zoj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String t = in.nextLine();
			if (t.equals("E"))
				return;
			char[] c = t.toCharArray();
			ArrayList<String> z = new ArrayList<String>();
			ArrayList<String> o = new ArrayList<String>();
			ArrayList<String> j = new ArrayList<String>();
			for (int i = 0; i < c.length; i++) {
				switch (c[i]) {
				case 'Z':
					z.add("Z");
					break;
				case 'O':
					o.add("O");
					break;
				case 'J':
					j.add("J");
					break;
				}
			}
			while (!z.isEmpty() || !o.isEmpty() || !j.isEmpty()) {
				if (!z.isEmpty())
					System.out.print(z.remove(0));
				if (!o.isEmpty())
					System.out.print(o.remove(0));
				if (!j.isEmpty())
					System.out.print(j.remove(0));
			}
			System.out.println();

		}
	}
}