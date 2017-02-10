package A1099BuildABinarySearchTree30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
	static int p = 0;
	static String s = "";

	public static void main(String[] args) {
		int n = in.nextInt();
		Node[] map = new Node[n];
		a = new int[n];
		for (int i = 0; i < map.length; i++)
			map[i] = new Node(Integer.MAX_VALUE);
		for (int i = 0; i < map.length; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			if (left != -1)
				map[i].left = map[left];
			if (right != -1)
				map[i].right = map[right];
		}
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		Arrays.sort(a);
		inOrder(map[0]);
		levelTravel(map[0]);
		System.out.println(s.trim());
	}

	static void levelTravel(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			s += temp.data + " ";
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	static void inOrder(Node head) {
		if (head == null)
			return;
		inOrder(head.left);
		head.data = a[p++];
		inOrder(head.right);
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