package TheBestRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashMap<String, Integer> aMap = new HashMap<String, Integer>();
		List<Integer> aList = new ArrayList<Integer>();
		HashSet<Integer> aSet = new HashSet<Integer>();
		HashMap<String, Integer> cMap = new HashMap<String, Integer>();
		List<Integer> cList = new ArrayList<Integer>();
		HashSet<Integer> cSet = new HashSet<Integer>();
		HashMap<String, Integer> mMap = new HashMap<String, Integer>();
		List<Integer> mList = new ArrayList<Integer>();
		HashSet<Integer> mSet = new HashSet<Integer>();
		HashMap<String, Integer> eMap = new HashMap<String, Integer>();
		List<Integer> eList = new ArrayList<Integer>();
		HashSet<Integer> eSet = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int C = in.nextInt();
			int M = in.nextInt();
			int E = in.nextInt();
			int A = (C + M + E) / 3;
			aMap.put(name, A);
			aSet.add(A);
			cMap.put(name, C);
			cSet.add(C);
			mMap.put(name, M);
			mSet.add(M);
			eMap.put(name, E);
			eSet.add(E);
		}
		aList = sort(aSet);
		cList = sort(cSet);
		mList = sort(mSet);
		eList = sort(eSet);
		for (int i = 0; i < m; i++) {
			String name = in.next();
			getIndex(aList.indexOf(aMap.get(name)), cList.indexOf(cMap.get(name)), mList.indexOf(mMap.get(name)),
					eList.indexOf(eMap.get(name)));
		}
	}

	private static void getIndex(int A, int C, int M, int E) {
		if (A == -1)
			A = Integer.MAX_VALUE;
		if (C == -1)
			C = Integer.MAX_VALUE;
		if (M == -1)
			M = Integer.MAX_VALUE;
		if (E == -1)
			E = Integer.MAX_VALUE;
		int min = Math.min(Math.min(A, C), Math.min(M, E));
		if (min == Integer.MAX_VALUE)
			System.out.println("N/A");
		else if (A == min)
			System.out.println(min + 1 + " " + "A");
		else if (C == min)
			System.out.println(min + 1 + " " + "C");
		else if (M == min)
			System.out.println(min + 1 + " " + "M");
		else if (E == min)
			System.out.println(min + 1 + " " + "E");
	}

	private static List<Integer> sort(HashSet<Integer> set) {
		List<Integer> arrayList = new ArrayList<Integer>(set);
		Collections.sort(arrayList, Collections.reverseOrder());
		return arrayList;
	}
}