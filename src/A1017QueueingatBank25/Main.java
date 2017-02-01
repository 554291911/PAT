package A1017QueueingatBank25;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Line {
	ArrayList<String> list;

	public Line(int num) {
		list = new ArrayList<String>(num);
		for (int i = 0; i < num; i++)
			list.add(new String("08:00:00"));
	}

	public int add(String key, Integer value) {
		int p = 0;
		String r = "24:60:60";
		for (int i = 0; i < list.size(); i++) {
			if (r.compareTo(list.get(i)) > 0) {
				r = list.get(i);
				p = i;
			}
		}
		String[] t = key.split(":");
		String[] free = r.split(":");
		int wait = 0;
		int time = parseInt(t);
		int ftime = parseInt(free);
		String waitTime = reverseString(time);
		if (ftime > time) {
			wait += ftime - time;
			list.set(p, reverseString(ftime + value * 60));
		} else {
			list.set(p, reverseString(time + value * 60));
		}
		return wait;
	}

	private String reverseString(int time) {
		int hour = time / (60 * 60);
		time -= hour * 60 * 60;
		int min = time / 60;
		int s = time - min * 60;
		String result = "";
		if (hour < 10)
			result += "0";
		result += hour + ":";
		if (min < 10)
			result += "0";
		result += min + ":";
		if (s < 10)
			result += "0";
		result += s;
		return result;
	}

	private int parseInt(String[] s) {
		return Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
	}

}

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int num = in.nextInt();
		Line l = new Line(num);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String key = in.next();
			int value = in.nextInt();
			if (key.compareTo("17:00:00") < 0)
				map.put(key, value);
		}
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		int wait = 0;
		for (int i = 0; i < list.size(); i++)
			wait += l.add(list.get(i).getKey(), list.get(i).getValue());
		int ave = wait / list.size();
		double d = ave / 60 + (ave - ave / 60 * 60) / 60.0;
		System.out.println(new BigDecimal(d).setScale(1, RoundingMode.HALF_UP));
	}
}