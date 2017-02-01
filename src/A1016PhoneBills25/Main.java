package A1016PhoneBills25;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Record {
	String name;
	String time;
	String tag;

	public Record(String name, String time, String tag) {
		this.name = name;
		this.time = time;
		this.tag = tag;
	}
}

public class Main {

	static boolean LOCAL = System.getSecurityManager() == null;
	static int[] times = new int[24];

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 24; i++)
			times[i] = in.nextInt();
		int n = in.nextInt();
		ArrayList<Record> list = new ArrayList<Record>();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			String time = in.next();
			String tag = in.next();
			list.add(new Record(name, time, tag));
		}
		Collections.sort(list, new Comparator<Record>() {
			@Override
			public int compare(Record o1, Record o2) {
				if (o1.name.equals(o2.name))
					return o1.time.compareTo(o2.time);
				else
					return o1.name.compareTo(o2.name);
			}
		});
		String name = list.get(0).name;
		int start = 0;
		for (int i = 1; i < list.size(); i++) {
			if (!list.get(i).name.equals(name)) {
				print(list, start, i - 1);
				start = i;
				name = list.get(i).name;
			}
			if (i == list.size() - 1)
				print(list, start, i);
		}
	}

	private static void print(ArrayList<Record> list, int start, int end) {
		System.out.println(list.get(start).name + " " + list.get(start).time.split(":")[0]);
		int result = 0;
		if (end == list.size() - 1)
			end--;
		for (int i = start; i < end + 1; i++) {
			if (list.get(i).tag.equals("on-line") && list.get(i + 1).tag.equals("off-line")) {
				result += build(i, list);
			}
		}
		System.out.println("Total amount: $" + new BigDecimal(result / 100.0).setScale(2, RoundingMode.HALF_UP));
	}

	private static double build(int sp, ArrayList<Record> list) {
		Record on = list.get(sp);
		Record off = list.get(sp + 1);
		String[] start = on.time.split(":");
		String[] end = off.time.split(":");
		int[] s = new int[4];
		for (int i = 0; i < s.length; i++)
			s[i] = Integer.parseInt(start[i]);
		int[] e = new int[4];
		for (int i = 0; i < e.length; i++)
			e[i] = Integer.parseInt(end[i]);
		int result = 0;
		int min = 0;
		while (s[0] != e[0] || s[1] != e[1] || s[2] != e[2] || s[3] != e[3]) {
			result += times[s[2]];
			s[3]++;
			min++;
			if (s[3] == 60) {
				s[3] = 0;
				s[2]++;
			}
			if (s[2] == 24) {
				s[2] = 0;
				s[1]++;
			}
		}
		System.out.println(start[1] + ":" + start[2] + ":" + start[3] + " " + end[1] + ":" + end[2] + ":" + end[3] + " "
				+ min + " $" + new BigDecimal(result / 100.0).setScale(2, RoundingMode.HALF_UP));
		return result;
	}

}