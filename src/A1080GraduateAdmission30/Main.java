package A1080GraduateAdmission30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Stu {
		int id;
		int e;
		int i;
		int k;
		int[] choices;
		int total;
		int rank;

		public Stu(int id, int e, int i, int k) {
			this.id = id;
			this.e = e;
			this.i = i;
			this.k = k;
			this.total = e + i;
			choices = new int[k];
		}

		public String toString() {
			return id + "";
		}
	}

	static class Line {
		int num;
		ArrayList<Stu> list;

		public Line(int num) {
			this.num = num;
			list = new ArrayList<Stu>();
		}

		public String toString() {
			Collections.sort(list, new Comparator<Stu>() {
				@Override
				public int compare(Stu o1, Stu o2) {
					return o1.id - o2.id;
				}
			});
			String str = "";
			for (int i = 0; i < list.size(); i++) {
				str += " " + list.get(i);
			}
			if (str.equals(""))
				return str;
			return str.substring(1);
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		Line[] l = new Line[m];
		ArrayList<Stu> s = new ArrayList<Stu>(n);
		for (int i = 0; i < m; i++)
			l[i] = new Line(in.nextInt());
		for (int i = 0; i < n; i++) {
			Stu e = new Stu(i, in.nextInt(), in.nextInt(), k);
			for (int j = 0; j < k; j++)
				e.choices[j] = in.nextInt();
			s.add(e);
		}
		Collections.sort(s, new Comparator<Stu>() {
			@Override
			public int compare(Stu o1, Stu o2) {
				if (o1.total != o2.total)
					return o2.total - o1.total;
				else if (o1.e != o2.e)
					return o2.e - o1.e;
				else
					return 0;
			}
		});
		s.get(0).rank = 1;
		for (int i = 1; i < s.size(); i++) {
			if (s.get(i).total == s.get(i - 1).total && s.get(i).e == s.get(i - 1).e)
				s.get(i).rank = s.get(i - 1).rank;
			else
				s.get(i).rank = i + 1;
		}
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < k; j++) {
				if (l[s.get(i).choices[j]].list.size() < l[s.get(i).choices[j]].num) {
					l[s.get(i).choices[j]].list.add(s.get(i));
					break;
				} else if (l[s.get(i).choices[j]].list.size() >= l[s.get(i).choices[j]].num) {
					if (s.get(i).rank == l[s.get(i).choices[j]].list.get(l[s.get(i).choices[j]].list.size() - 1).rank) {
						l[s.get(i).choices[j]].list.add(s.get(i));
						break;
					}
				}
			}
		}
		for (int i = 0; i < l.length; i++)
			System.out.println(l[i]);
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