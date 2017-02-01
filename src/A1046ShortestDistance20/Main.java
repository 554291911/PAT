package A1046ShortestDistance20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
		InputReader in = new InputReader(System.in);
		Task solver = new Task();
		solver.solve(in);
	}

	static class Task {
		public void solve(InputReader in) {
			int num = in.nextInt();
			int[] map = new int[num + 1];
			int sum = 0;
			for (int i = 2; i < num + 1; i++) {
				int t = in.nextInt();
				sum += t;
				map[i] = sum;
			}
			sum += in.nextInt();
			map[0] = sum;
			num = in.nextInt();
			for (int i = 0; i < num; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int max = (x > y) ? x : y;
				int min = (x < y) ? x : y;
				int r1 = map[max] - map[min];
				int r2 = sum - r1;
				System.out.println((r1 < r2) ? r1 : r2);
			}
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