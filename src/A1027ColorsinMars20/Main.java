package A1027ColorsinMars20;

import java.util.Scanner;

public class Main {
	static void rever(int num) {
		int high = num / 13;
		if (high == 10)
			System.out.print("A");
		else if (high == 11)
			System.out.print("B");
		else if (high == 12)
			System.out.print("C");
		else
			System.out.print(high);
		int low = num % 13;
		if (low == 10)
			System.out.print("A");
		else if (low == 11)
			System.out.print("B");
		else if (low == 12)
			System.out.print("C");
		else
			System.out.print(low);
	}

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		Scanner in = new Scanner(System.in);
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		System.out.print("#");
		rever(red);
		rever(green);
		rever(blue);
	}
}