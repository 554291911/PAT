package A1075PATJudge25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	static class User {
		String name;
		TreeMap<Integer, Integer> codes;
		int score;
		int p;
		boolean loser;
		int rank = Integer.MAX_VALUE;

		public User(String name) {
			this.name = name;
			this.codes = new TreeMap<Integer, Integer>();
			loser = true;
		}

		public void add(int num, int code) {
			if (codes.get(num) == null) {
				if (code != -1) {
					score += code;
					codes.put(num, code);

					loser = false;
				} else
					codes.put(num, 0);
			} else if (codes.get(num) < code) {
				score += code - codes.get(num);
				codes.put(num, code);
				loser = false;
			}

		}

		public int getperfect() {
			Iterator<Entry<Integer, Integer>> it = codes.entrySet().iterator();
			int perfect = 0;
			while (it.hasNext()) {
				Entry<Integer, Integer> e = it.next();
				if (s[e.getKey() - 1] == e.getValue())
					perfect++;
			}
			p = perfect;
			return perfect;
		}

		public String toString() {
			String str = rank + " " + name + " " + score;
			for (int i = 0; i < s.length; i++) {
				if (codes.get(i + 1) == null)
					str += " -";
				else
					str += " " + codes.get(i + 1);
			}
			return str;
		}
	}

	static boolean LOCAL = System.getSecurityManager() == null;
	static int[] s;

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(System.in);
		HashMap<String, User> map = new HashMap<String, User>();
		int users = in.nextInt();
		int code = in.nextInt();
		int num = in.nextInt();
		s = new int[code];
		for (int i = 0; i < code; i++)
			s[i] = in.nextInt();
		Comparator<Entry<String, User>> c = new Comparator<Entry<String, User>>() {
			@Override
			public int compare(Entry<String, User> o1, Entry<String, User> o2) {
				if (o1.getValue().score != o2.getValue().score)
					return o2.getValue().score - o1.getValue().score;
				else if (o1.getValue().getperfect() != o2.getValue().getperfect())
					return o2.getValue().p - o1.getValue().p;
				else
					return o1.getValue().name.compareTo(o2.getValue().name);
			}
		};
		for (int i = 0; i < num; i++) {
			String name = in.next();
			int ti = in.nextInt();
			int fen = in.nextInt();
			if (map.get(name) == null)
				map.put(name, new User(name));
			map.get(name).add(ti, fen);
		}
		ArrayList<Entry<String, User>> list = new ArrayList<Entry<String, User>>(map.entrySet());
		Collections.sort(list, c);
		list.get(0).getValue().rank = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getValue().loser)
				continue;
			if (list.get(i).getValue().score == list.get(i - 1).getValue().score)
				list.get(i).getValue().rank = list.get(i - 1).getValue().rank;
			else
				list.get(i).getValue().rank = i + 1;
		}
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getValue().loser)
				System.out.println(list.get(i).getValue());
		}
	}
}