package Median;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = in.nextInt();
		}
		int n = in.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
		int middle = (m + n + 1) / 2;
		int count = 0;
		int i = 0;
		int j = 0;
		int result = 0;
		while (count < middle) {
			if (a[i] < b[j])
				result = a[i++];
			else
				result = b[j++];
			count++;
		}
		System.out.println(result);
	}
}