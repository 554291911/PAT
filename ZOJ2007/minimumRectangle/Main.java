package minimumRectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		while (in.hasNext()) {
			int x = in.nextInt();
			int y = in.nextInt();
			if (x == 0 && y == 0) {
				if (!X.isEmpty() && !Y.isEmpty())
					build(X, Y);
				X = new ArrayList<Integer>();
				Y = new ArrayList<Integer>();
			} else {
				X.add(x);
				Y.add(y);
			}
		}
	}

	private static void build(ArrayList<Integer> x, ArrayList<Integer> y) {
		Collections.sort(x);
		Collections.sort(y);
		int[] result = new int[4];
		result[0] = x.get(0);
		result[1] = y.get(0);
		System.out.println(x.get(0) + " " + y.get(0) + " " + x.get(x.size() - 1) + " " + y.get(y.size() - 1));
	}
}