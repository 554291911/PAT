package Median;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/Median/input.txt"));
		} catch (FileNotFoundException e) {
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