package A1002AplusBforPolynomials25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int key = in.nextInt();
			double value = in.nextDouble();
			map.put(key, value);
			list.add(key);
		}
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int key = in.nextInt();
			double value = in.nextDouble();
			if (map.get(key) != null) {
				map.put(key, map.get(key) + value);
			} else {
				map.put(key, value);
				list.add(key);
			}
		}
		Collections.sort(list);
		String result = "";
		int k = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (!map.get(list.get(i)).equals(0.0)) {
				result += " " + list.get(i) + " " + String.format("%.1f", map.get(list.get(i)));
				k++;
			}
		}
		System.out.println(k + result);
	}
}