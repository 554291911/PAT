package AplusBforMatrices;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static class People {
		String name;
		int weight;
		int zu;

		public People(String name, int weight, int zu) {
			this.name = name;
			this.weight = weight;
			this.zu = zu;
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
		while (true) {
			int M = in.nextInt();
			if (M == 0)
				return;
			int N = in.nextInt();
			int[][] A = new int[M][N];
			int[][] B = new int[M][N];
			int[][] C = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] = in.nextInt();
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					B[i][j] = in.nextInt();
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					C[i][j] = A[i][j] + B[i][j];
				}
			}
			int total = 0;
			for (int i = 0; i < M; i++) {
				boolean flag = true;
				for (int j = 0; j < N; j++) {
					if (C[i][j] != 0) {
						flag = false;
						break;
					}
				}
				if (flag)
					total++;
			}
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < M; j++) {
					if (C[j][i] != 0) {
						flag = false;
						break;
					}
				}
				if (flag)
					total++;
			}
			System.out.println(total);
		}
	}
}