package stillAplusB;

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
			int a = in.nextInt();
			int b = in.nextInt();
			int K = in.nextInt();
			if (a == 0 && b == 0)
				return;
			String A = a + "";
			int lA = A.length();
			for (int i = 0; i < 8 - lA; i++)
				A = "0" + A;
			String B = b + "";
			int lB = B.length();
			for (int i = 0; i < 8 - lB; i++)
				B = "0" + B;
			if (A.substring(8 - K).equals(B.substring(8 - K)))
				System.out.println(-1);
			else
				System.out.println(a + b);
		}
	}
}