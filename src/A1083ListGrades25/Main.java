package A1083ListGrades25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Stu {
		String name;
		String id;
		int score;

		public Stu(String name, String id, int score) {
			this.name = name;
			this.id = id;
			this.score = score;
		}

		public String toString() {
			return name + " " + id;
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
		int n = in.nextInt();
		ArrayList<Stu> list = new ArrayList<Stu>();
		Stu[] stus = new Stu[n];
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String id = in.next();
			int score = in.nextInt();
			stus[i] = new Stu(name, id, score);
		}
		int low = in.nextInt();
		int high = in.nextInt();
		for (int i = 0; i < stus.length; i++) {
			if (stus[i].score >= low && stus[i].score <= high)
				list.add(stus[i]);
		}
		Collections.sort(list, new Comparator<Stu>() {
			@Override
			public int compare(Stu o1, Stu o2) {
				return o2.score - o1.score;
			}
		});
		if (list.isEmpty()) {
			System.out.println("NONE");
			return;
		}
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}