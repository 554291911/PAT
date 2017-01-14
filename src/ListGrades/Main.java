package ListGrades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/ListGrades/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			String[] strs = s.split(" ");
			map.put(Integer.parseInt(strs[2]), strs[0] + " " + strs[1]);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = iter.next();
			list.add((int) entry.getKey());
		}
		Collections.sort(list);
		int result = 0;
		String[] s = in.nextLine().split(" ");
		int low = Integer.parseInt(s[0]);
		int high = Integer.parseInt(s[1]);
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) >= low && list.get(i) <= high){
				System.out.println(map.get(list.get(i)));
				result++;
			}
		}
		if(result==0)
			System.out.println("NONE");
	}
}