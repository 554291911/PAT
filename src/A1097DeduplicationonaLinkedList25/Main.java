package A1097DeduplicationonaLinkedList25;

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
		int start = in.nextInt();
		int n = in.nextInt();
		Node[] map = new Node[100000];
		for (int i = 0; i < n; i++) {
			int add = in.nextInt();
			int data = in.nextInt();
			int next = in.nextInt();
			map[add] = new Node(add, data, next);
		}
		int p = 0;
		Node[] a = new Node[n];
		while (start != -1) {
			a[p++] = map[start];
			start = map[start].next;
		}
		int[] flag = new int[10001];
		Node[] keep = new Node[n];
		Node[] remove = new Node[n];
		int k = 0;
		int r = 0;
		for (int i = 0; i < p; i++) {
			if (flag[Math.abs(a[i].data)] == 0) {
				keep[k++] = a[i];
				flag[Math.abs(a[i].data)] = 1;
			} else
				remove[r++] = a[i];
		}
		int i = 0;
		for (i = 0; i < k - 1; i++)
			System.out.printf("%05d %d %05d\n", keep[i].add, keep[i].data, keep[i + 1].add);
		System.out.printf("%05d %d -1\n", keep[i].add, keep[i].data);
		for (i = 0; i < r - 1; i++)
			System.out.printf("%05d %d %05d\n", remove[i].add, remove[i].data, remove[i + 1].add);
		System.out.printf("%05d %d -1\n", remove[i].add, remove[i].data);
	}

	static class Node {
		int add;
		int data;
		int next;

		public Node(int add, int data, int next) {
			this.add = add;
			this.data = data;
			this.next = next;
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