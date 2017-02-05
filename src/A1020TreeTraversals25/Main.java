package A1020TreeTraversals25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static InputReader in = new InputReader(System.in);
	private int n;
	static int[] posOrder;
	static int[] inOrder;
	static String result = "";

	public static void main(String[] args) {
		int n = in.nextInt();
		posOrder = new int[n];
		inOrder = new int[n];
		for (int i = 0; i < n; i++)
			posOrder[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			inOrder[i] = in.nextInt();
		Node res = pre(n - 1, 0, n - 1);
		printByLevel(res);
		System.out.println(result.trim());
	}

	static Node pre(int root, int start, int end) {
		if (start > end)
			return null;
		int i = start;
		while (i < end && inOrder[i] != posOrder[root])
			i++;
		Node res = new Node(posOrder[root]);
		res.left = pre(root - 1 - end + i, start, i - 1);
		res.right = pre(root - 1, i + 1, end);
		return res;
	}

	static void printByLevel(Node head) {
		if (head == null)
			return;
		Node last = head;
		Node nextLast = null;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.pop();
			result += head.value + " ";
			if (head.left != null) {
				queue.offer(head.left);
				nextLast = head.left;
			}
			if (head.right != null) {
				queue.offer(head.right);
				nextLast = head.right;
			}
			if (head == last && !queue.isEmpty()) {
				last = nextLast;
			}
		}
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