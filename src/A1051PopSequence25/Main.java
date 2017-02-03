package A1051PopSequence25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static InputReader in = new InputReader(System.in);

	public static void main(String[] args) {
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int T = in.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		int[] arr = new int[n2 + 1];
		while (T-- != 0) {
			if (!s.isEmpty())
				s.clear();
			boolean flag = true;
			int current = 1;
			for (int i = 1; i <= n2; i++)
				arr[i] = in.nextInt();
			for (int i = 1; i <= n2; i++) {
				s.push(i);
				if (s.size() > n1) {
					flag = false;
					break;
				}
				while (!s.isEmpty() && s.peek() == arr[current]) {
					s.pop();
					current++;
				}
			}
			if (s.isEmpty() && flag)
				System.out.println("YES");
			else
				System.out.println("NO");
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