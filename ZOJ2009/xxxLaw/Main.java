package xxxLaw;

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
			if (num == 0)
				return;
			int k = 0;
			while (num != 1) {
				k++;
				if (num % 2 == 0)
					num = num >> 1;
				else {
					num = 3 * num + 1;
					num = num >> 1;
				}
			}
			System.out.println(k);
		}
	}
}