package A1041BeUnique20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] a;
	static int[] table = new int[1001];

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int num = in.nextInt();
		a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = in.nextInt();
			table[a[i]]++;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < num; i++) {
			if (table[a[i]] == 1) {
				ans = a[i];
				break;
			}
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println("NONE");
		else
			System.out.println(ans);
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