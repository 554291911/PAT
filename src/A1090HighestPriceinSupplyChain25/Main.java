package A1090HighestPriceinSupplyChain25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long s;

	static {
		try {
			s = System.currentTimeMillis();
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static InputReader in = new InputReader(System.in);

	public static void main(String[] args) {

		int n = in.nextInt();
		double price = in.nextDouble();
		double rate = in.nextDouble();
		Node[] map = new Node[n];
		int root = 0;
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			if (t == -1)
				root = i;
			map[i] = new Node(i, t);
		}
		int[] nums = new int[n];
		int deep = Integer.MIN_VALUE;
		for (int i = 0; i < map.length; i++) {
			if (map[i].add == -1)
				continue;
			int father = map[i].add;
			int k = 0;
			while (father != root) {
				father = map[father].father;
				k++;
			}
			nums[k]++;
			if (k > deep)
				deep = k;
		}
		System.out.printf("%.2f %d\n", price * Math.pow(1 + rate / 100.0, deep), nums[deep]);
		System.out.println(System.currentTimeMillis() - s);
	}

	static class Node {
		int add;
		int father;

		public Node(int add, int father) {
			this.add = add;
			this.father = father;
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