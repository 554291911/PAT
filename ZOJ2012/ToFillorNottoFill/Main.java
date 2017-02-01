package ToFillorNottoFill;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class Node {
		double price;
		double distance;

		public Node(double price, double distance) {
			this.price = price;
			this.distance = distance;
		}

		public String toString() {
			return this.price + " " + this.distance;
		}
	}

	static boolean LOCAL = System.getSecurityManager() == null;

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(System.in);
		int cmax = in.nextInt();
		double D = in.nextDouble();
		int avg = in.nextInt();
		int N = in.nextInt();
		Node[] map = new Node[N];
		for (int i = 0; i < N; i++)
			map[i] = new Node(in.nextDouble(), in.nextDouble());
		Arrays.sort(map, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.distance - o2.distance);
			}
		});
		Node now = map[0];
		float result = 0;
		double have = 0;
		int ml = 0;
		double min = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			boolean flag = false;
			for (int j = i; map[j].distance <= now.distance + cmax * avg; j++) {
				if (map[j].price <= now.price) {
					result += (map[j].distance - now.distance) / avg * now.price;
					now = map[j];
					i = j;
					have = 0;
					flag = true;
					break;
				} else if (map[j].price <= min) {
					min = map[j].price;
					ml = j;
					flag = false;
				}
			}
			if (!flag) {
				result += now.price * (cmax - have);
				have = cmax - (map[ml].distance - now.distance) / avg;
				min = Integer.MAX_VALUE;
			}
		}
		System.out.println(result);
	}
}