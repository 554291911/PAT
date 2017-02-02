package A1063SetSimilarity25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		HashSet<Integer>[] c = new HashSet[n + 1];
		for (int i = 1; i < c.length; i++) {
			c[i] = new HashSet<Integer>();
			int len = in.nextInt();
			for (int j = 0; j < len; j++)
				c[i].add(in.nextInt());
		}
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			Iterator<Integer> it = c[a].iterator();
			int nc = 0, nt = c[b].size();
			while (it.hasNext()) {
				Integer e = it.next();
				if (c[b].contains(e))
					nc++;
				else
					nt++;
			}
			System.out.printf("%.1f", (nc * 100.0 / nt));
			System.out.println("%");
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