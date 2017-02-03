package A1074ReversingLinkedList25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
		int start = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		Node[] a = new Node[n];
		Node[] map = new Node[100000];
		for (int i = 0; i < n; i++) {
			int add = in.nextInt();
			int data = in.nextInt();
			int next = in.nextInt();
			map[add] = new Node(add, data, next);
		}
		int num = 0;
		Comparator<Node> c = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.rank - o1.rank;
			}
		};
		int flag = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			a[i] = map[start];
			a[i].rank = i + 1;
			if (++num == k) {
				Arrays.sort(a, i - k + 1, i + 1, c);
				num = 0;
			}
			start = map[start].next;
			if (start == -1) {
				flag = i;
				break;
			}
		}
		try {
			for (int i = 0; i < a.length - 1; i++)
				System.out.printf("%05d %d %05d\n", a[i].add, a[i].data, a[i + 1].add);
		} catch (NullPointerException e) {
			System.out.printf("%05d %d -1\n", a[flag].add, a[flag].data);
			return;
		}
		System.out.printf("%05d %d -1\n", a[a.length - 1].add, a[a.length - 1].data);
	}

	static class Node {
		int add;
		int data;
		int next;
		int rank;

		public Node(int add, int data, int next) {
			this.add = add;
			this.data = data;
			this.next = next;
		}

		public String toString() {
			return "rank:" + rank + " " + String.format("%05d", add) + " " + data + " " + String.format("%05d", next);
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