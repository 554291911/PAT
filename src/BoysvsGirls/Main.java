package BoysvsGirls;

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
		int n = Integer.parseInt(in.nextLine());
		ArrayList<Integer> boy = new ArrayList<Integer>();
		ArrayList<Integer> girl = new ArrayList<Integer>();
		HashMap<Integer, String> boyMap = new HashMap<Integer, String>();
		HashMap<Integer, String> girlMap = new HashMap<Integer, String>();
		for (int i = 0; i < n; i++) {
			String temp = in.nextLine();
			String[] str = temp.split(" ");
			if (str[1].equals("M")) {
				boy.add(Integer.parseInt(str[3]));
				boyMap.put(Integer.parseInt(str[3]), str[0] + " " + str[2]);
			} else {
				girl.add(Integer.parseInt(str[3]));
				girlMap.put(Integer.parseInt(str[3]), str[0] + " " + str[2]);
			}
		}
		Collections.sort(boy);
		Collections.sort(girl);
		String M = "";
		String F = "";
		if (girl.size() != 0)
			F = girlMap.get(girl.get(girl.size() - 1));
		if (boy.size() != 0)
			M = boyMap.get(boy.get(0));
		if (F.equals("") && !M.equals("")) {
			System.out.println("Absent");
			System.out.println(M);
			System.out.println("NA");
		} else if (!F.equals("") && M.equals("")) {
			System.out.println(F);
			System.out.println("Absent");
			System.out.println("NA");
		} else if (F.equals("") && M.equals("")) {
			System.out.println("Absent");
			System.out.println("Absent");
			System.out.println("NA");
		} else if (!F.equals("") && !M.equals("")) {
			System.out.println(F);
			System.out.println(M);
			System.out.println(girl.get(girl.size() - 1) - boy.get(0));
		}
	}
}