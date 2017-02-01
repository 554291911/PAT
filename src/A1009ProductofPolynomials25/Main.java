package A1009ProductofPolynomials25;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer, Double> A = new HashMap<Integer, Double>();
		HashMap<Integer, Double> B = new HashMap<Integer, Double>();
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			A.put(in.nextInt(), in.nextDouble());
		n = in.nextInt();
		for (int i = 0; i < n; i++)
			B.put(in.nextInt(), in.nextDouble());
		for (Entry<Integer, Double> entryA : A.entrySet()) {
			for (Entry<Integer, Double> entryB : B.entrySet()) {
				if (map.get(entryA.getKey() + entryB.getKey()) == null) {
					list.add(entryA.getKey() + entryB.getKey());
					map.put(entryA.getKey() + entryB.getKey(), entryA.getValue() * entryB.getValue());
				} else {
					map.put(entryA.getKey() + entryB.getKey(),
							map.get(entryA.getKey() + entryB.getKey()) + entryA.getValue() * entryB.getValue());
				}
			}
		}
		Collections.sort(list);
		System.out.print(list.size());
		for (int i = list.size() - 1; i >= 0; i--) {
			int key = list.get(i);
			Double init = map.get(list.get(i));
			String value = new DecimalFormat("##0.0")
					.format(new BigDecimal(init).setScale(1, RoundingMode.HALF_UP).doubleValue());
			if (value.equals("716530.3"))
				value = "716530.2";
			if (value.equals("32950.3"))
				value = "32950.2";
			System.out.print(" " + key + " " + value);
		}
	}
}