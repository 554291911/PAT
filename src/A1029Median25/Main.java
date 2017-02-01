package A1029Median25;

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
			int m = in.nextInt();
			int[] a = new int[m + 1];
			int i = 0;
			for (i = 0; i < m; i++)
				a[i] = in.nextInt();
			a[m] = Integer.MAX_VALUE;
			int n = in.nextInt();
			int[] b = new int[n + 1];
			for (i = 0; i < n; i++)
				b[i] = in.nextInt();
			b[n] = Integer.MAX_VALUE;
			int middle = (m + n - 1) / 2;
			int count = 0;
			i = 0;
			int j = 0;
			int result = 0;
			while (count++ <= middle) {
				if (a[i] < b[j])
					result = a[i++];
				else if (a[i] >= b[j])
					result = b[j++];
			}
			if (result != Integer.MAX_VALUE)
				System.out.println(result);
		}
	}
}