package A1079TotalSalesofSupplyChain25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
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

	public static void main(String[] args) {
		int n = in.nextInt();
		double price = in.nextDouble();
		double rate = in.nextDouble();
		HashMap<Integer, Node> leaves = new HashMap<Integer, Node>();
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (num == 0) {
				Node value = new Node(i, in.nextInt());
				leaves.put(i, value);
				map.put(i, value);
			} else {
				int[] a = new int[num];
				for (int j = 0; j < a.length; j++)
					a[j] = in.nextInt();
				map.put(i, new Node(i, a));
			}
		}
		Iterator<Entry<Integer, Node>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Node> e = it.next();
			int m = (e.getValue().next == null) ? 0 : e.getValue().next.length;
			int[] arr = e.getValue().next;
			for (int i = 0; i < m; i++) {
				map.get(arr[i]).root = false;
				map.get(arr[i]).father = e.getValue();
			}
		}
		Iterator<Entry<Integer, Node>> it2 = map.entrySet().iterator();
		Node root = null;
		while (it2.hasNext()) {
			Entry<Integer, Node> e = it2.next();
			if (e.getValue().root) {
				root = e.getValue();
				break;
			}
		}
		Iterator<Entry<Integer, Node>> it3 = leaves.entrySet().iterator();
		double result = 0.0;
		while (it3.hasNext()) {
			Entry<Integer, Node> e = it3.next();
			int k = 1;
			Node father = e.getValue().father;
			while (father != root) {
				father = father.father;
				k++;
			}
			result += e.getValue().data * Math.pow(1 + rate / 100.0, k);
		}
		result *= price;
		System.out.printf("%.1f", result);
	}

	static class Node {
		boolean root;
		int add;
		int data;
		int[] next;
		Node father;

		public Node(int add, int data) {
			this.add = add;
			this.data = data;
			this.root = true;
		}

		public Node(int add, int... next) {
			this.add = add;
			this.next = next;
			this.root = true;
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