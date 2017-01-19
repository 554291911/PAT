package BattleOverCities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Num {
	int pos;
	int num;
	int start;

	public Num(int pos, int num) {
		this.num = num;
		this.pos = pos;
	}
}

class Line {
	int num;
	ArrayList<Num> list;
	int popTime;

	public Line(int num, int sort) {
		this.popTime = 0;
		this.num = num;
		list = new ArrayList<Num>(num);
	}

	public Num out() {
		if (list.size() == 1) {
			popTime = Integer.MAX_VALUE;
			return list.remove(0);
		}
		Num n = list.remove(0);
		popTime = list.get(0).num;
		return n;
	}

	public Integer get() {
		return list.get(0).num;
	}

	public void put(int p, int n) {
		list.add(new Num(p, n));
	}

}

public class Main {
	public static void main(String args[]) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		int Q = in.nextInt();
		ArrayList<Line> list = new ArrayList<Line>(N);
		HashMap<Integer, Num> result = new HashMap<Integer, Num>();
		HashMap<Line, Integer> times = new HashMap<Line, Integer>();
		for (int i = 0; i < N; i++) {
			Line l = new Line(M, i);
			list.add(l);
			times.put(l, 0);
		}
		int p = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				list.get(j).put(p++, in.nextInt());
			}
		}
		for (int i = N * M; i < K; i++) {
			Line l = getFirst(list);
			Num n = l.out();
			n.start = times.get(l);
			times.put(l, times.get(l) + n.num);
			int t = in.nextInt();
			l.put(p++, t);
			result.put(n.pos, n);
		}
		for (int i = 0; i < N * M; i++) {
			Line l = getFirst(list);
			Num n = l.out();
			n.start = times.get(l);
			times.put(l, times.get(l) + n.num);
			result.put(n.pos, n);
		}
		for (int i = 0; i < Q; i++) {
			Num n = result.get(in.nextInt());
			int mi = n.start + n.num;
			if (n.start >= 540) {
				System.out.println("Sorry");
				continue;
			}
			int hour = 8 + mi / 60;
			int min = mi - mi / 60 * 60;
			String time = "";
			if (hour < 10)
				time += "0";
			time += hour + ":";
			if (min < 10)
				time += "0";
			time += min;
			System.out.println(time);
		}
	}

	private static Line getFirst(ArrayList<Line> list) {
		int min = Integer.MAX_VALUE;
		Line l = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).popTime < min) {
				min = list.get(i).popTime;
				l = list.get(i);
			}
		}
		return l;
	}
}