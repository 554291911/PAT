package A1100MarsNumbers20;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (Exception e) {
		}
	}

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String[] low = { "tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec" };
		String[] high = { "tret", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou" };
		HashMap<String, Integer> highs = new HashMap<String, Integer>();
		highs.put("tret", 0);
		highs.put("tam", 1);
		highs.put("hel", 2);
		highs.put("maa", 3);
		highs.put("huh", 4);
		highs.put("tou", 5);
		highs.put("kes", 6);
		highs.put("hei", 7);
		highs.put("elo", 8);
		highs.put("syy", 9);
		highs.put("lok", 10);
		highs.put("mer", 11);
		highs.put("jou", 12);
		HashMap<String, Integer> lows = new HashMap<String, Integer>();
		lows.put("tret", 0);
		lows.put("jan", 1);
		lows.put("feb", 2);
		lows.put("mar", 3);
		lows.put("apr", 4);
		lows.put("may", 5);
		lows.put("jun", 6);
		lows.put("jly", 7);
		lows.put("aug", 8);
		lows.put("sep", 9);
		lows.put("oct", 10);
		lows.put("nov", 11);
		lows.put("dec", 12);
		int n = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			if (s.matches("[0-9]+")) {
				int k = Integer.parseInt(s);
				int h = k / 13;
				int l = k % 13;
				if (h == 0 && l == 0)
					System.out.println("tret");
				else if (h != 0 && l != 0)
					System.out.println(high[h] + " " + low[l]);
				else if (h == 0 && l != 0)
					System.out.println(low[l]);
				else if (h != 0 && l == 0)
					System.out.println(high[h]);
			} else {
				int result = 0;
				if (s.length() <= 4) {
					if (lows.get(s) != null)
						result += lows.get(s);
					else
						result += 13 * highs.get(s);
				} else {
					String[] ss = s.split(" ");
					result += 13 * highs.get(ss[0]);
					result += lows.get(ss[1]);
				}
				System.out.println(result);
			}
		}
	}
}