package Radix;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static Map<Character, Integer> map = new TreeMap<Character, Integer>();

	static {
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
	}

	static boolean flag = true;

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		String[] temp = new String[3];
		String a;
		String b;
		for (int i = 0; i < temp.length; i++)
			temp[i] = in.next();
		long radix = in.nextLong();
		if (temp[2].equals("1")) {
			a = temp[0];
			b = temp[1];
		} else {
			b = temp[0];
			a = temp[1];
		}
		solution(a, b, radix);
		if (flag)
			System.out.println("Impossible");
	}

	private static void solution(String know1, String unknow, long radix) {
		long know = to10Radix(know1, radix);
		findRadix(know, unknow);
	}

	private static void findRadix(long know, String unknow1) {
		long low = 2;
		long high = Long.MAX_VALUE;
		if (unknow1.matches(".*[a-z].*"))
			low = 10;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			long unknow = to10Radix(unknow1, middle);
			if (unknow == know) {
				System.out.println(middle);
				flag = false;
				return;
			} else {
				if (unknow < know)
					low = middle + 1;
				else
					high = middle - 1;
			}
		}
	}

	private static long to10Radix(String n, long radix) {
		long know = 0;
		char[] num = n.toCharArray();
		int r = 0;
		for (int i = num.length - 1; i >= 0; i--)
			know += map.get(num[i]) * Math.pow(radix, r++);
		return know;
	}

}