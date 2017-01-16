package stillUnimpededProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			if (N == 0)
				return;
			int length = N * (N - 1) / 2;
			int[][] map = new int[N + 1][N + 1];
			int start = 0;
			int end = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < length; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int d = in.nextInt();
				if (d < min) {
					min = d;
					start = x;
					end = y;
				}
				map[x][y] = d;
				map[y][x] = d;
			}
			int result = min;
			map[start][end] = 0;
			map[end][start] = 0;
			int[] a = new int[N + 1];
			result += prim(map, start, end, a);
			System.out.println(result);
		}
	}

	private static int prim(int[][] map, int x, int y, int[] a) {
		int result = 0;
		int k = 1;
		a[x] = k;
		a[y] = k;
		for (int l = 1; l < map.length - 2; l++) {
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					if (map[i][j] < min && map[i][j] != 0) {
						min = map[i][j];
						x = i;
						y = j;
					}
				}
			}
			if (a[x] == 0 && a[y] == 0) {
				a[x] = ++k;
				a[y] = k;
				result += min;
			} else if (a[x] == 0 && a[y] != 0) {
				a[x] = a[y];
				result += min;
			} else if (a[x] != 0 && a[y] == 0) {
				a[y] = a[x];
				result += min;
			} else if (a[x] != 0 && a[y] != 0 && a[x] != a[y]) {
				int n = (a[x] < a[y]) ? a[x] : a[y];
				int m = (a[x] > a[y]) ? a[x] : a[y];
				for (int i = 1; i < a.length; i++) {
					if (a[i] == m)
						a[i] = n;
				}
				result += min;
			} else {
				l--;
			}
			map[x][y] = 0;
			map[y][x] = 0;
		}
		return result;
	}
}