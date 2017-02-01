package A1041BeUnique20;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static boolean LOCAL = System.getSecurityManager() == null;
	static int[] a;
	static int[] table = new int[1001];

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = in.nextInt();
			table[a[i]]++;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < num; i++) {
			if (table[a[i]] == 1) {
				ans = a[i];
				break;
			}
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println("NONE");
		else
			System.out.println(ans);
	}
}