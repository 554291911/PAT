package UnimpededProject;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			Set<Integer> s = new HashSet<Integer>();
			int m = in.nextInt();
			if (m == 0)
				break;
			int n = in.nextInt();
			if (n == 0) {
				System.out.println(m - 1);
				continue;
			}
			int a[] = new int[m + 1];
			int k = 0;
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (a[x] == 0 && a[y] == 0) {
					k++;
					a[x] = k;
					a[y] = k;
				} else if (a[x] == 0 && a[y] != 0)
					a[x] = a[y];
				else if (a[x] != 0 && a[y] == 0)
					a[y] = a[x];
				else {
					if (a[x] != a[y]) {
						int min = a[x] < a[y] ? a[x] : a[y];
						int max = a[x] > a[y] ? a[x] : a[y];
						for (int j = 0; j < a.length; j++) {
							if (a[j] == max || a[j] == min)
								a[j] = min;
						}
					}
				}
			}
			int zero = 0;
			for (int i = 1; i <= m; i++) {
				if (a[i] != 0)
					s.add(a[i]);
				else
					zero++;
			}
			System.out.println(s.size() + zero - 1);
		}
	}
}