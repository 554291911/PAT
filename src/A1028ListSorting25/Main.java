package A1028ListSorting25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int tag = in.nextInt();
		Student[] t = new Student[n];
		for (int i = 0; i < n; i++) {
			String id = in.next();
			String name = in.next();
			int score = in.nextInt();
			t[i] = new Student(id, name, score);
		}
		Comparator<Student> c;
		if (tag == 1) {
			c = new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.id.compareTo(o2.id);
				}
			};
		} else if (tag == 2) {
			c = new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if (o1.name.equals(o2.name))
						return o1.id.compareTo(o2.id);
					return o1.name.compareTo(o2.name);
				}
			};
		} else {
			c = new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if (o1.score == o2.score)
						return o1.id.compareTo(o2.id);
					return o1.score - o2.score;
				}
			};
		}
		Arrays.sort(t, c);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);
	}

	static class Student {
		String id;
		String name;
		int score;

		public Student(String id, String name, int score) {
			this.id = id;
			this.name = name;
			this.score = score;
		}

		public String toString() {
			return id + " " + name + " " + score;
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