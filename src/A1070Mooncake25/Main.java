package A1070Mooncake25;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static class Type {
		int tons;
		int price;

		public Type(int tons, double price) {
			this.tons = tons;
			this.price = (int) (price * 1000);
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
		int n = in.nextInt();
		int total = in.nextInt();
		ArrayList<Type> list = new ArrayList<Type>(n);
		int[] a = new int[n];
		double[] b = new double[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			b[i] = in.nextDouble();
		for (int i = 0; i < n; i++)
			list.add(new Type(a[i], b[i]));
		Collections.sort(list, new Comparator<Type>() {
			@Override
			public int compare(Type o1, Type o2) {
				return o2.price / o2.tons - o1.price / o1.tons;
			}
		});
		int r = 0;
		int i = 0;
		int result = 0;
		for (i = 0; i < list.size(); i++) {
			r += list.get(i).tons;
			result += list.get(i).price;
			if (r >= total) {
				result -= ((r - total) * 1.0) / list.get(i).tons * list.get(i).price;
				break;
			}
		}
		System.out.println(new BigDecimal(result / 1000.0).setScale(2, RoundingMode.HALF_UP));
	}
}