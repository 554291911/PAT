package Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			int n = in.nextInt();
			if (n == 0)
				return;
			int m = in.nextInt();
			int line = in.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			HashMap<String, Integer> rank = new HashMap<String, Integer>();
			for (int i = 0; i < m; i++)
				map.put(i + 1, in.nextInt());
			for (int i = 0; i < n; i++) {
				String name = in.next();
				int total = in.nextInt();
				int score = 0;
				for (int j = 0; j < total; j++)
					score += map.get(in.nextInt());
				if (score >= line)
					rank.put(name, score);
			}
			ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(rank.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					if (o1.getValue() == o2.getValue())
						return o1.getKey().compareTo(o2.getKey());
					return o2.getValue() - o1.getValue();
				}
			});
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
			}
		}
	}
}