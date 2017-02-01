package HeadofaGang;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	static class People {
		String name;
		int weight;
		int zu;

		public People(String name, int weight, int zu) {
			this.name = name;
			this.weight = weight;
			this.zu = zu;
		}
	}

	static boolean LOCAL = System.getSecurityManager() == null;

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while (in.hasNextLine()) {
			HashMap<String, People> map = new HashMap<String, People>();
			int n = in.nextInt();
			int line = in.nextInt();
			int zu = 1;
			ArrayList<String> list = new ArrayList<String>();
			HashMap<Integer, Integer> zus = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> times = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				String a = in.next();
				String b = in.next();
				int length = in.nextInt();
				if (map.get(a) == null && map.get(b) == null) {
					if (zus.get(zu) == null || times.get(zu) == null) {
						zus.put(zu, 2);
						times.put(zu, length);
					}
					map.put(a, new People(a, length, zu));
					map.put(b, new People(b, length, zu++));
				} else if (map.get(a) == null && map.get(b) != null) {
					zus.put(map.get(b).zu, zus.get(map.get(b).zu) + 1);
					times.put(map.get(b).zu, times.get(map.get(b).zu) + length);
					map.put(a, new People(a, length, map.get(b).zu));
					map.get(b).weight += length;
				} else if (map.get(a) != null && map.get(b) == null) {
					zus.put(map.get(a).zu, zus.get(map.get(a).zu) + 1);
					times.put(map.get(a).zu, times.get(map.get(a).zu) + length);
					map.put(b, new People(b, length, map.get(a).zu));
					map.get(a).weight += length;
				} else {
					if (map.get(a).zu != map.get(b).zu) {
						int min = (map.get(a).zu < map.get(b).zu) ? map.get(a).zu : map.get(b).zu;
						int max = (map.get(a).zu > map.get(b).zu) ? map.get(a).zu : map.get(b).zu;
						zus.put(min, zus.get(min) + zus.get(max));
						times.put(min, times.get(min) + times.get(max));
						times.remove(max);
						zus.remove(max);
						Iterator<Entry<String, People>> it = map.entrySet().iterator();
						while (it.hasNext()) {
							Entry<String, People> e = it.next();
							if (e.getValue().zu == max)
								e.getValue().zu = min;
						}
					}
					times.put(map.get(a).zu, times.get(map.get(a).zu) + length);
					map.get(a).weight += length;
					map.get(b).weight += length;
				}
			}
			Iterator<Entry<Integer, Integer>> it = zus.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Integer> e = it.next();
				if (e.getValue() > 2 && times.get(e.getKey()) > line) {
					People flag = new People("", 0, e.getKey());
					Iterator<Entry<String, People>> it2 = map.entrySet().iterator();
					while (it2.hasNext()) {
						Entry<String, People> e2 = it2.next();
						if (e2.getValue().zu == flag.zu && e2.getValue().weight >= flag.weight)
							flag = e2.getValue();
						else if (e2.getValue().zu == flag.zu && e2.getValue().weight < flag.weight)
							it2.remove();
					}
					if (!flag.name.equals(""))
						list.add(flag.name + " " + zus.get(flag.zu));
				}
				it.remove();
			}
			Collections.sort(list);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
	}
}