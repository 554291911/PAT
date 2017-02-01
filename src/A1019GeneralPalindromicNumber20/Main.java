package A1019GeneralPalindromicNumber20;

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
		int n = in.nextInt();
		int radix = in.nextInt();
		if (n == 0) {
			System.out.println("Yes\n0");
			return;
		}
		toRadix(n, radix);
	}

	private static void toRadix(int n, int radix) {
		String z = "";
		String r = "";
		int u = 0;
		while (n != 0) {
			int k = n % radix;
			r += " " + k;
			z = " " + k + z;
			n /= radix;
		}
		if (z.equals(r))
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(z.substring(1));
	}
}