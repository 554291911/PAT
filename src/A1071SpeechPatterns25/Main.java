package A1071SpeechPatterns25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
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
		String s = in.nextLine();
		s = s.replaceAll("[^a-zA-Z0-9 ]", " ");
		String[] ss = s.split(" +");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ss.length; i++) {
			ss[i] = ss[i].toLowerCase();
			if (map.get(ss[i]) == null)
				map.put(ss[i], 1);
			else
				map.put(ss[i], map.get(ss[i]) + 1);
		}
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		int max = -1;
		String result = "";
		while (it.hasNext()) {
			Entry<String, Integer> e = it.next();
			if (e.getValue() > max) {
				max = e.getValue();
				result = e.getKey();
			} else if (e.getValue() == max) {
				if (result.compareTo(e.getKey()) > 0)
					result = e.getKey();
			}
		}
		System.out.println(result + " " + max);
	}

}