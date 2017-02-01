package A1065AplusBandC64bit20;

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
			for (int i = 0; i < num; i++) {
				long A = Long.parseLong(in.next());
				long B = Long.parseLong(in.next());
				long C = Long.parseLong(in.next());
				long r = A + B;
				boolean flag;
				if (A > 0 && B > 0 && r < 0)
					flag = true;
				else if (A < 0 && B < 0 && r >= 0)
					flag = false;
				else if (r > C)
					flag = true;
				else
					flag = false;
				if (flag)
					System.out.println("Case #" + (i + 1) + ": true");
				else
					System.out.println("Case #" + (i + 1) + ": false");
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