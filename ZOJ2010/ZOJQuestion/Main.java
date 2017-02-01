package ZOJQuestion;

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
			String t = in.nextLine();
			if (OJ(t))
				System.out.println("Accepted");
			else
				System.out.println("Wrong Answer");
		}
	}

	private static boolean OJ(String t) {
		if (t.equals("zoj"))
			return true;
		else if (t.matches("o+zojo+")) {
			String[] c = t.split("zoj");
			if (c[0].length() == c[1].length())
				return true;
			else
				return false;
		} else if (t.matches("o*zo+jo*")) {
			String r = "";
			char[] c = t.toCharArray();
			int i;
			int start = 0;
			for (i = 0; i < c.length; i++) {
				if (c[i] == 'o') {
					r += c[i];
					start++;
				} else
					break;
			}
			r += c[i];
			i += 2;
			for (; i < c.length; i++) {
				if (c[i] == 'o')
					r += c[i];
				else
					break;
			}
			r += c[i++];
			int N = t.length() - r.length() - 1 - start;
			for (int j = 0; j < N; j++) {
				r += "o";
			}
			return OJ(r);
		} else
			return false;
	}
}