package A1006SignInandSignOut25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
		}
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		ArrayList<String> listIn = new ArrayList<String>();
		ArrayList<String> listOut = new ArrayList<String>();
		HashMap<String, String> mapIn = new HashMap<String, String>();
		HashMap<String, String> mapOut = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String input = in.next();
			String output = in.next();
			listIn.add(input);
			listOut.add(output);
			mapIn.put(input, name);
			mapOut.put(output, name);
		}
		Collections.sort(listIn);
		Collections.sort(listOut);
		System.out.println(mapIn.get(listIn.get(0)) + " " + mapOut.get(listOut.get(listOut.size() - 1)));
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