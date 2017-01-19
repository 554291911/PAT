package SignInandSignOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = Integer.parseInt(in.nextLine());
			ArrayList<String> listIn = new ArrayList<String>();
			ArrayList<String> listOut = new ArrayList<String>();
			HashMap<String, String> mapIn = new HashMap<String, String>();
			HashMap<String, String> mapOut = new HashMap<String, String>();
			for (int i = 0; i < n; i++) {
				String temp = in.nextLine();
				String[] strs = temp.split(" ");
				listIn.add(strs[1]);
				listOut.add(strs[2]);
				mapIn.put(strs[1], strs[0]);
				mapOut.put(strs[2], strs[0]);
			}
			Collections.sort(listIn);
			Collections.sort(listOut);
			System.out.println(mapIn.get(listIn.get(0)) + " " + mapOut.get(listOut.get(listOut.size() - 1)));
		}
	}
}