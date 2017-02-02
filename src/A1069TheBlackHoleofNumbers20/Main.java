package A1069TheBlackHoleofNumbers20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		int[] a = new int[4];
		while (true) {
			for (int i = 0; i < a.length; i++) {
				a[i] = n % 10;
				n /= 10;
			}
			Arrays.sort(a);
			int max = 0;
			int min = 0;
			for (int i = 0; i < a.length; i++)
				max += a[i] * Math.pow(10, i);
			int k = 0;
			for (int i = a.length - 1; i >= 0; i--)
				min += a[i] * Math.pow(10, k++);
			n = max - min;
			System.out.printf("%04d - %04d = %04d\n", max, min, n);
			if (n == 6174 || n == 0)
				break;
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