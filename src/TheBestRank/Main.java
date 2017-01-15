package TheBestRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		HashMap<String, Integer> Amap = new HashMap<String, Integer>();
		HashMap<Integer, Integer> AmapOrder = new HashMap<Integer, Integer>();
		HashSet<Integer> Aset = new HashSet<Integer>();
		HashMap<String, Integer> Cmap = new HashMap<String, Integer>();
		HashMap<Integer, Integer> CmapOrder = new HashMap<Integer, Integer>();
		HashSet<Integer> Cset = new HashSet<Integer>();
		HashMap<String, Integer> Mmap = new HashMap<String, Integer>();
		HashMap<Integer, Integer> MmapOrder = new HashMap<Integer, Integer>();
		HashSet<Integer> Mset = new HashSet<Integer>();
		HashMap<String, Integer> Emap = new HashMap<String, Integer>();
		HashMap<Integer, Integer> EmapOrder = new HashMap<Integer, Integer>();
		HashSet<Integer> Eset = new HashSet<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int C = in.nextInt();
			int M = in.nextInt();
			int E = in.nextInt();
			int A = (C + M + E) / 3;
			Amap.put(name, A);
			Aset.add(A);
			Cmap.put(name, C);
			Cset.add(C);
			Mmap.put(name, M);
			Mset.add(M);
			Mmap.put(name, M);
			Mset.add(M);
			Emap.put(name, E);
			Eset.add(E);
		}
		AmapOrder = removeDuplicate(Aset);
		CmapOrder = removeDuplicate(Cset);
		MmapOrder = removeDuplicate(Mset);
		EmapOrder = removeDuplicate(Eset);
		for (int i = 0; i < m; i++) {
			String name = in.next();
			try {
				getIndex(name, Amap, AmapOrder, Cmap, CmapOrder, Mmap, MmapOrder, Emap, EmapOrder);
			} catch (NullPointerException e) {
				System.out.println("N/A");
			}
		}
	}

	private static void getIndex(String name, HashMap<String, Integer> Amap, HashMap<Integer, Integer> amapOrder,
			HashMap<String, Integer> Cmap, HashMap<Integer, Integer> cmapOrder, HashMap<String, Integer> Mmap,
			HashMap<Integer, Integer> mmapOrder, HashMap<String, Integer> Emap, HashMap<Integer, Integer> emapOrder) {
		int score = Amap.get(name);
		int min = Integer.MAX_VALUE;
		String menu = "";
		int i = amapOrder.get(score);
		if (min > i) {
			min = i;
			menu = "A";
		}
		score = Cmap.get(name);
		i = cmapOrder.get(score);
		if (min > i) {
			min = i;
			menu = "C";
		}
		score = Mmap.get(name);
		i = mmapOrder.get(score);
		if (min > i) {
			min = i;
			menu = "M";
		}
		score = Emap.get(name);
		i = emapOrder.get(score);
		if (min > i) {
			min = i;
			menu = "E";
		}
		System.out.println(min + 1 + " " + menu);
	}

	public static HashMap<Integer, Integer> removeDuplicate(HashSet<Integer> set) {
		ArrayList<Integer> h = new ArrayList<Integer>(set);
		Collections.sort(h, Collections.reverseOrder());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(h.size());
		for (int i = 0; i < h.size(); i++)
			map.put(h.get(i), i);
		return map;
	}
}