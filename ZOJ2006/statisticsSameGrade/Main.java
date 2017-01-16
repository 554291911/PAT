package statisticsSameGrade;

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
			int N = in.nextInt();
			if (N == 0)
				return;
			int[] m = new int[101];
			for (int i = 0; i < N; i++)
				m[in.nextInt()]++;
			System.out.println(m[in.nextInt()]);
		}
	}
}