package A1102InvertaBinaryTree25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
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
	static int[] preOrder;
	static int[] inOrder;
	static String zhong = "";
	static String ceng = "";

	public static void main(String[] args) {
		int n = in.nextInt();
		HashMap<String, Node> map = new HashMap<String, Node>();
		for (int i = 0; i < n; i++)
			map.put(i + "", new Node(i));
		for (int i = 0; i < n; i++) {
			String left = in.next();
			String right = in.next();
			if (!left.equals("-")) {
				map.get(i + "").left = map.get(left);
				map.get(left).head = false;
			}
			if (!right.equals("-")) {
				map.get(i + "").right = map.get(right);
				map.get(right).head = false;
			}
		}
		Iterator<Entry<String, Node>> it = map.entrySet().iterator();
		Node head = null;
		while (it.hasNext()) {
			Entry<String, Node> e = it.next();
			if (e.getValue().head) {
				head = e.getValue();
				break;
			}
		}
		head = reverse(head);
		printByLevel(head);
		inOrder1(head);
		System.out.println(ceng.trim() + "\n" + zhong.trim());
	}

	static void inOrder1(Node head) {
		if (head == null)
			return;
		inOrder1(head.left);
		zhong += head.value + " ";
		inOrder1(head.right);
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
			ceng += head.value + " ";
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

	static Node reverse(Node head) {
		if (head.left != null)
			reverse(head.left);
		if (head.right != null)
			reverse(head.right);
		Node t = head.right;
		head.right = head.left;
		head.left = t;
		return head;
	}

	static class Node {

		public int value;
		public Node left;
		public Node right;
		public boolean head;

		public Node(int data) {
			this.value = data;
			head = true;
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