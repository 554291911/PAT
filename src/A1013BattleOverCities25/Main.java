package A1013BattleOverCities25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
		int citys = in.nextInt();
		int lines = in.nextInt();
		int losts = in.nextInt();
		ArrayList<String> list = new ArrayList<String>(lines);
		for (int i = 0; i < lines; i++)
			list.add(in.nextInt() + "-" + in.nextInt());
		for (int i = 0; i < losts; i++) {
			ArrayList<String> lList = new ArrayList<String>(list);
			int lost = in.nextInt();
			int[] a = new int[citys + 1];
			Iterator<String> it = lList.iterator();
			int k = 0;
			Set<Integer> s = new HashSet<Integer>();
			int total = 0;
			while (it.hasNext()) {
				String str = it.next();
				String[] strs = str.split("-");
				int x = Integer.parseInt(strs[0]);
				int y = Integer.parseInt(strs[1]);
				if (lost == x || lost == y) {
					it.remove();
					continue;
				}
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
			for (int j = 1; j <= citys; j++) {
				if (j == lost)
					continue;
				if (a[j] != 0)
					s.add(a[j]);
				else
					zero++;
			}
			total = s.size() + zero - 1;
			if (total > 0)
				System.out.println(total);
			else
				System.out.println(0);
		}
	}
}