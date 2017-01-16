package ReversiblePrimes;

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
			int num = in.nextInt();
			if (num < 0)
				return;
			int radix = in.nextInt();
			if (num == 1) {
				System.out.println("No");
				continue;
			}
			int num1 = (int) Math.sqrt(num) + 1;
			boolean flag = true;
			for (int i = 2; i < num1; i++) {
				if (num % i == 0) {
					flag = false;
				}
			}
			if (!flag) {
				System.out.println("No");
				continue;
			}
			int s = toRadix(num, radix);
			if (s <= 1) {
				System.out.println("No");
				continue;
			}
			int s2 = (int) Math.sqrt(s) + 1;
			flag = true;
			for (int i = 2; i < s2; i++) {
				if (s % i == 0) {
					flag = false;
				}
			}
			if (flag)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	private static int toRadix(int num, int radix) {
		String result = "";
		while (num != 0) {
			result += num % radix;
			num /= radix;
		}
		String[] r = result.split("");
		int k = result.length() - 1;
		int ret = 0;
		for (int i = 1; i < r.length; i++)
			ret += Integer.parseInt(r[i]) * Math.pow(radix, k--);
		return ret;
	}
}