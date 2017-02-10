package A1043IsItaBinarySearchTree25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		int n = in.nextInt();
		Node[] map = new Node[n];
		for (int i = 0; i < map.length; i++) {
			map[i] = new Node(Integer.MAX_VALUE);
			int left = in.nextInt();
			int right = in.nextInt();
			if (left != -1)
				map[i].left = new Node(Integer.MAX_VALUE);
			if (right != -1)
				map[i].right = new Node(Integer.MAX_VALUE);
		}

	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
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

		public Double nextDouble() {
			return Double.parseDouble(next());
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