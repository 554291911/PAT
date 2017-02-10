package A1064CompleteBinarySearchTree30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static InputReader in = new InputReader(System.in);
	static int[] a;
	static int[] CBT;
	static int index = 0;
	static String s = "";
	static int n;

	public static void main(String[] args) {
		n = in.nextInt();
		a = new int[n];
		CBT = new int[n + 1];
		for (int i = 0; i < a.length; i++)
			a[i] = in.nextInt();
		Arrays.sort(a);
		inOrder(1);
		for (int i = 1; i <= n; i++) {
			System.out.print(CBT[i]);
			if (i < n)
				System.out.print(" ");
		}
	}

	static void inOrder(int root) {
		if (root > n)
			return;
		inOrder(root * 2);
		CBT[root] = a[index++];
		inOrder(root * 2 + 1);
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