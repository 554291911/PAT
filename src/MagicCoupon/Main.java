package MagicCoupon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		long[] cou = new long[c];
		for (int i = 0; i < c; i++)
			cou[i] = in.nextLong();
		Arrays.sort(cou);
		int p = in.nextInt();
		long[] pro = new long[p];
		for (int i = 0; i < p; i++)
			pro[i] = in.nextLong();
		Arrays.sort(pro);
		int result = 0;
		while (cou[--c] > 0 && pro[--p] > 0)
			result += cou[c] * pro[p];
		c = 0;
		p = 0;
		while (cou[c] < 0 && pro[p] < 0)
			result += cou[c++] * pro[p++];
		System.out.println(result);
	}
}