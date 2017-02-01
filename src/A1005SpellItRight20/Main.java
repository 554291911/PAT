package A1005SpellItRight20;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		String[] strs = n.split("");
		long result = 0L;
		for (int i = 1; i < strs.length; i++)
			result += Long.parseLong(strs[i]);
		String re = result + "";
		String[] res = re.split("");
		for (int i = 1; i < res.length; i++) {
			if (i == res.length - 1)
				System.out.println(arr[Integer.parseInt(res[i])]);
			else
				System.out.print(arr[Integer.parseInt(res[i])] + " ");
		}
	}
}