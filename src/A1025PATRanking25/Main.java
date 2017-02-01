package A1025PATRanking25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
		HashMap<String, Student> totalMap = new HashMap<String, Student>();
		Scanner in = new Scanner(System.in);
		int wai = in.nextInt();
		ArrayList<Student>[] map = new ArrayList[wai];
		for (int i = 0; i < map.length; i++)
			map[i] = new ArrayList<Student>();
		for (int i = 0; i < wai; i++) {
			int li = in.nextInt();
			for (int j = 0; j < li; j++) {
				String name = in.next();
				int score = in.nextInt();
				Student s = new Student(name, score, i + 1);
				totalMap.put(name, s);
				map[i].add(s);
			}
		}
		ArrayList<Map.Entry<String, Student>> list = new ArrayList<Map.Entry<String, Student>>(totalMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Student>>() {
			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				if (o1.getValue().score != o2.getValue().score)
					return o2.getValue().score - o1.getValue().score;
				else
					return o1.getValue().name.compareTo(o2.getValue().name);
			}
		});
		list.get(0).getValue().final_rank = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getValue().score == list.get(i - 1).getValue().score)
				list.get(i).getValue().final_rank = list.get(i - 1).getValue().final_rank;
			else
				list.get(i).getValue().final_rank = i + 1;
		}
		Comparator<Student> c = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.score == o2.score)
					return o1.name.compareTo(o2.name);
				else
					return o2.score - o1.score;
			}
		};
		for (int i = 0; i < map.length; i++)
			Collections.sort(map[i], c);
		for (int i = 0; i < map.length; i++) {
			int r = 1;
			map[i].get(0).local_rank = 1;
			for (int j = 1; j < map[i].size(); j++) {
				if (map[i].get(j).score == map[i].get(j - 1).score)
					map[i].get(j).local_rank = map[i].get(j - 1).local_rank;
				else
					map[i].get(j).local_rank = j + 1;
			}
		}
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue().final_rank + " "
					+ list.get(i).getValue().local_number + " " + list.get(i).getValue().local_rank);
	}
}

class Student {
	String name;
	int score;
	int final_rank;
	int local_number;
	int local_rank;

	public Student(String name, int score, int local_number) {
		this.name = name;
		this.score = score;
		this.local_number = local_number;
	}
}