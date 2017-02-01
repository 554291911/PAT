package Sharing;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static class Node {
		int next;
		String data;
		boolean flag;

		public Node(String data, int next) {
			this.data = data;
			this.next = next;
			this.flag = false;
		}

		public String toString() {
			return data;
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
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while (in.hasNextLine()) {
			int a = in.nextInt();
			int b = in.nextInt();
			int num = in.nextInt();
			if (num == 0)
				return;
			Node[] map = new Node[100000];
			for (int i = 0; i < num; i++) {
				int start = in.nextInt();
				String data = in.next();
				int next = in.nextInt();
				map[start] = new Node(data, next);
			}
			while (a != -1) {
				map[a].flag = true;
				a = map[a].next;
			}
			boolean flag = false;
			while (!flag && b != -1) {
				if (map[b].flag) {
					System.out.printf("%05d", b);
					flag = true;
					break;
				} else {
					b = map[b].next;
				}
			}
			if (!flag)
				System.out.println("-1");
		}
	}
}