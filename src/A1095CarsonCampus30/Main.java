package A1095CarsonCampus30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		InputReader in = new InputReader(System.in);
		TreeMap<String, String> pass = new TreeMap<String, String>();
		TreeMap<String, String> out = new TreeMap<String, String>();
		int n = in.nextInt();
		int l = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String time = in.next();
			String type = in.next();
			if (type.equals("in"))
				pass.put(time, name);
			else
				out.put(time, name);
		}
		for (int i = 0; i < args.length; i++) {

		}
		System.out.println();
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