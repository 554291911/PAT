package A1037MagicCoupon25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		InputReader in = new InputReader(System.in);
		int c = in.nextInt();
		long[] cou = new long[c];
		for (int i = 0; i < c; i++)
			cou[i] = Long.parseLong(in.next());
		Arrays.sort(cou);
		int p = in.nextInt();
		long[] pro = new long[p];
		for (int i = 0; i < p; i++)
			pro[i] = Long.parseLong(in.next());
		Arrays.sort(pro);
		int result = 0;
		while (cou[--c] > 0 && pro[--p] > 0)
			result += cou[c] * pro[p];
		c = 0;
		p = 0;
		while (cou[c] < 0 && pro[p] < 0)
			result += cou[c++] * pro[p++];
		System.out.println(result);
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