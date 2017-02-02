package A1092ToBuyorNottoBuy20;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (FileNotFoundException e) {
		}
		Scanner in = new Scanner(System.in);
		String flag = in.nextLine();
		char[] tag = flag.toCharArray();
		int[] m = new int[80];
		int miss = 0;
		for (int i = 0; i < tag.length; i++)
			m[change(tag[i])]++;
		flag = in.nextLine();
		char[] tag2 = flag.toCharArray();
		for (int i = 0; i < tag2.length; i++) {
			int id = change(tag2[i]);
			m[id]--;
			if (m[id] < 0)
				miss++;
		}
		if (miss == 0)
			System.out.println("Yes " + (tag.length - tag2.length));
		else
			System.out.println("No " + miss);
	}

	static int change(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		else if (c >= 'a' && c <= 'z')
			return c - 'a' + 10;
		else
			return c - 'A' + 36;
	}
}