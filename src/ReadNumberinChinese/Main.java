package ReadNumberinChinese;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/ReadNumberinChinese/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] print = { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" };
		Scanner in = new Scanner(System.in);
		String n = in.next();
		char[] c = n.toCharArray();
		int length = c.length;
		if (c[0] == '-') {
			System.out.print("Fu ");
			for (int i = 0; i < c.length; i++)
				c[i] = c[i + 1];
			length--;
		}
		int[] nums = new int[length];
		for (int i = 0; i < nums.length; i++)
			nums[i] = Integer.parseInt(c[i] + "");
		if (nums[0] != 0 && length == 9)
			System.out.print(print[nums[0]] + " Yi");
		if (length >= 5 && length <= 8) {
		}
	}
}