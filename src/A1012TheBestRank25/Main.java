package A1012TheBestRank25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> Amap = new HashMap<String, Integer>();
		ArrayList<Integer> Alist = new ArrayList<Integer>();
		HashMap<String, Integer> Cmap = new HashMap<String, Integer>();
		ArrayList<Integer> Clist = new ArrayList<Integer>();
		HashMap<String, Integer> Mmap = new HashMap<String, Integer>();
		ArrayList<Integer> Mlist = new ArrayList<Integer>();
		HashMap<String, Integer> Emap = new HashMap<String, Integer>();
		ArrayList<Integer> Elist = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int C = in.nextInt();
			int M = in.nextInt();
			int E = in.nextInt();
			int A = C + M + E;
			Amap.put(name, A);
			Alist.add(A);
			Cmap.put(name, C);
			Clist.add(C);
			Mmap.put(name, M);
			Mlist.add(M);
			Mmap.put(name, M);
			Mlist.add(M);
			Emap.put(name, E);
			Elist.add(E);
		}
		Collections.sort(Alist, Collections.reverseOrder());
		Collections.sort(Clist, Collections.reverseOrder());
		Collections.sort(Mlist, Collections.reverseOrder());
		Collections.sort(Elist, Collections.reverseOrder());
		for (int i = 0; i < m; i++) {
			String name = in.next();
			try {
				getIndex(name, Amap, Alist, Cmap, Clist, Mmap, Mlist, Emap, Elist);
			} catch (NullPointerException e) {
				System.out.println("N/A");
			}
		}
	}

	private static void getIndex(String name, HashMap<String, Integer> Amap, ArrayList<Integer> Alist,
			HashMap<String, Integer> Cmap, ArrayList<Integer> Clist, HashMap<String, Integer> Mmap,
			ArrayList<Integer> Mlist, HashMap<String, Integer> Emap, ArrayList<Integer> Elist) {
		int score = Amap.get(name);
		int min = Integer.MAX_VALUE;
		String menu = "";
		for (int i = 0; i < Alist.size(); i++) {
			if (Alist.get(i) == score) {
				if (min > i) {
					min = i;
					menu = "A";
				}
				break;
			}
		}
		score = Cmap.get(name);
		for (int i = 0; i < Clist.size(); i++) {
			if (Clist.get(i) == score) {
				if (min > i) {
					min = i;
					menu = "C";
				}
				break;
			}
		}
		score = Mmap.get(name);
		for (int i = 0; i < Mlist.size(); i++) {
			if (Mlist.get(i) == score) {
				if (min > i) {
					min = i;
					menu = "M";
				}
				break;
			}
		}
		score = Emap.get(name);
		for (int i = 0; i < Elist.size(); i++) {
			if (Elist.get(i) == score) {
				if (min > i) {
					min = i;
					menu = "E";
				}
				break;
			}
		}
		System.out.println(min + 1 + " " + menu);
	}
}