package A1060AreTheyEqual25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		double a = Double.parseDouble(in.next());
		double b = Double.parseDouble(in.next());
		int k = 0;
		while ((int) a != 0) {
			k++;
			a /= 10;
		}
		StringBuilder sa = new StringBuilder();
		sa = sa.append(a);
		sa = sa.append("0000");
		String ar = sa.substring(0, n + 2);
		int k2 = 0;
		while ((int) b != 0) {
			k2++;
			b /= 10;
		}
		sa = new StringBuilder();
		sa = sa.append(b);
		sa = sa.append("0000");
		String br = sa.substring(0, n + 2);
		if (ar.equals(br))
			System.out.println("YES " + ar + "*10^" + k);
		else
			System.out.println("NO " + ar + "*10^" + k + " " + br + "*10^" + k);
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