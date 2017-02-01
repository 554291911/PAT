package HelloWorldforU;

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
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String t = in.nextLine();
			int N = t.length();
			int n1 = 0;
			int n2;
			for (int i = 3; i < N; i++) {
				int k = (N - i + 2) / 2;
				if (k <= i && k >= n1)
					n1 = k;
			}
			n2 = N - 2 * n1;
			String r = "";
			for (int i = 0; i < n2; i++)
				r += " ";
			char[] c = t.toCharArray();
			for (int i = 0; i < n1 - 1; i++)
				System.out.println(c[i] + r + c[N - i - 1]);
			System.out.println(t.substring(n1 - 1, N - n1 + 1));
		}
	}
}