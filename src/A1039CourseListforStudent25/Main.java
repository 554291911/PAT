package A1039CourseListforStudent25;

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
		int c = in.nextInt();
		String[] s = new String[c + 1];
		for (int i = 0; i < s.length; i++)
			s[i] = "";
		for (int i = 0; i < c; i++) {
			int co = in.nextInt();
			int num = in.nextInt();
			for (int j = 0; j < num; j++)
				s[co] += " " + in.next();
		}
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String result = "";
			int len = 0;
			for (int j = 1; j < s.length; j++) {
				if (s[j].contains(name)) {
					result += " " + j;
					len++;
				}
			}
			result = name + " " + len + result;
			System.out.println(result);
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