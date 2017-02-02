package A1054TheDominantColor20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		InputReader in = new InputReader(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int row = in.nextInt();
		int col = in.nextInt();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int temp = in.nextInt();
				if (map.get(temp) == null)
					map.put(temp, 1);
				else
					map.put(temp, map.get(temp) + 1);
			}
		}
		int result = 0;
		int count = 0;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			if (entry.getValue() > result) {
				result = entry.getValue();
				count = entry.getKey();
			}
		}
		System.out.println(count);
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