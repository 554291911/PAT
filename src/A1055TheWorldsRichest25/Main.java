package A1055TheWorldsRichest25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static class Man {
		String name;
		int age;
		int rich;

		public Man(String name, int age, int rich) {
			this.name = name;
			this.age = age;
			this.rich = rich;
		}

		public String toString() {
			return name + " " + age + " " + rich;
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int num = in.nextInt();
		int cases = in.nextInt();
		Man[] m = new Man[num];
		for (int i = 0; i < num; i++) {
			String name = in.next();
			int age = in.nextInt();
			int rich = in.nextInt();
			m[i] = new Man(name, age, rich);
		}
		Comparator<Man> c = new Comparator<Man>() {
			@Override
			public int compare(Man o1, Man o2) {
				if (o1 == null || o2 == null)
					return Integer.MAX_VALUE;
				if (o1.rich != o2.rich)
					return o2.rich - o1.rich;
				else if (o1.age != o2.age)
					return o1.age - o2.age;
				else
					return o1.name.compareTo(o2.name);

			}
		};
		Arrays.sort(m, c);
		TreeMap<Integer, ArrayList<Man>> map = new TreeMap<Integer, ArrayList<Man>>();
		for (int i = 0; i < m.length; i++) {
			if (map.get(m[i].age) == null)
				map.put(m[i].age, new ArrayList<Man>());
			map.get(m[i].age).add(m[i]);
		}
		for (int i = 0; i < cases; i++) {
			int range = in.nextInt();
			int low = in.nextInt();
			int high = in.nextInt();
			ArrayList<Man> list = new ArrayList<Man>();
			System.out.println("Case #" + (i + 1) + ":");
			int k = 0;
			Iterator<Entry<Integer, ArrayList<Man>>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, ArrayList<Man>> e = it.next();
				if (e.getKey() <= high && e.getKey() >= low && e.getValue().size() != 0) {
					list.addAll(e.getValue());
					k += e.getValue().size();
				}
			}
			Collections.sort(list, c);
			int min = Math.min(range, list.size());
			for (int j = 0; j < min; j++)
				System.out.println(list.get(j));
			if (min == 0)
				System.out.println("None");
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	}
}