package RationalSum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int gcd(int m, int n) {
		while (m % n != 0) {
			int a = n;
			n = m % a;
			m = a;
		}
		return n;
	}

	static String add(String m, String n) {
		int a = Integer.parseInt(m.split("/")[0]);
		int b = Integer.parseInt(n.split("/")[0]);
		int c = Integer.parseInt(m.split("/")[1]);
		int d = Integer.parseInt(n.split("/")[1]);
		int num = Math.abs(c * d / gcd(c, d));
		return a * num / c + b * num / d + "/" + num;
	}

	static String result(String result) {
		String[] strs = result.split("/");
		int numUp = Integer.parseInt(strs[0]);
		int numDown = Integer.parseInt(strs[1]);
		int num = numUp / numDown;// 整数部分
		numUp = numUp - numDown * num;// 余数分子部分
		int gcd = Math.abs(gcd(numUp, numDown));// 最大公约数
		numUp /= gcd;
		numDown /= gcd;
		String re = "";
		if (num != 0)
			re += num;
		if (num != 0 && numUp != 0)
			re += " ";
		if (numUp != 0)
			re += numUp + "/" + numDown;
		if (re == "")
			re += 0;
		return re;
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/RationalSum/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++)
			strs[i] = in.next();
		String result = strs[0];
		for (int i = 1; i < strs.length; i++)
			result = add(result, strs[i]);
		System.out.print(result(result));
	}
}