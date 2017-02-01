package A1062TalentandVirtue25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Man {
		String name;
		int v;
		int t;
		int total;
		int flag;

		public Man(String name, int v, int t, int total, int flag) {
			this.name = name;
			this.v = v;
			this.t = t;
			this.total = total;
			this.flag = flag;
		}

		public String toString() {
			return name + " " + v + " " + t;
		}
	}

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
		int num = in.nextInt();
		int L = in.nextInt();
		int H = in.nextInt();
		ArrayList<Man> list = new ArrayList<Man>();
		Comparator<Man> c = new Comparator<Man>() {
			@Override
			public int compare(Man o1, Man o2) {
				if (o1.flag != o2.flag)
					return o1.flag - o2.flag;
				else if (o2.total != o1.total)
					return o2.total - o1.total;
				else if (o2.v != o1.v)
					return o2.v - o1.v;
				else
					return o1.name.compareTo(o2.name);
			}
		};
		for (int i = 0; i < num; i++) {
			String name = in.next();
			int v = in.nextInt();
			int t = in.nextInt();
			int total = v + t;
			if (v < L || t < L)
				continue;
			else {
				if (v >= H && t >= H && v <= 100 && t <= 100)
					list.add(new Man(name, v, t, total, 1));
				else if (v >= H && t < H && t >= L && v <= 100)
					list.add(new Man(name, v, t, total, 2));
				else if (v < H && t < H && v >= L && t >= L && v >= t)
					list.add(new Man(name, v, t, total, 3));
				else if (v >= L && t >= L && v < 100 && t < 100)
					list.add(new Man(name, v, t, total, 4));
			}
		}
		Collections.sort(list, c);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}