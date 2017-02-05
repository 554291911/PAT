package A1086TreeTraversalsAgain25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static InputReader in = new InputReader(System.in);
	static int[] preOrder;
	static int[] inOrder;
	static String result = "";

	public static void main(String[] args) {
		int n = in.nextInt();
		preOrder = new int[n];
		inOrder = new int[n];
		int push = 0;
		int pop = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 2 * n; i++) {
			String type = in.next();
			if (type.equals("Push")) {
				int num = in.nextInt();
				s.push(num);
				preOrder[push++] = num;
			} else
				inOrder[pop++] = s.pop();
		}
		Node res = pre(0, 0, n - 1);
		posOrder1(res);
		System.out.println(result.trim());
	}

	static void posOrder1(Node head) {
		if (head == null)
			return;
		posOrder1(head.left);
		posOrder1(head.right);
		result += head.value + " ";
	}

	static Node pre(int root, int start, int end) {
		if (start > end)
			return null;
		int i = start;
		while (i < end && inOrder[i] != preOrder[root])
			i++;
		Node res = new Node(inOrder[i]);
		res.left = pre(root + 1, start, i - 1);
		res.right = pre(i + 1, i + 1, end);
		return res;
	}

	static class Node {

		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
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