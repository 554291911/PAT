package AplusB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		while (in.hasNextLine()) {
			ArrayList<String> A = new ArrayList<String>();
			while (in.hasNext()) {
				String temp = in.next();
				if (temp.equals("+"))
					break;
				else
					A.add(temp);
			}
			ArrayList<String> B = new ArrayList<String>();
			while (in.hasNext()) {
				String temp = in.next();
				if (temp.equals("="))
					break;
				else
					B.add(temp);
			}
			int a = get(A, map);
			int b = get(B, map);
			if (a == 0 && b == 0)
				return;
			System.out.println(a + b);
		}
	}

	private static int get(ArrayList<String> list, HashMap<String, Integer> map) {
		int r = 0;
		int result = 0;
		for (int i = list.size() - 1; i >= 0; i--)
			result += map.get(list.get(i)) * Math.pow(10, r++);
		return result;
	}
}