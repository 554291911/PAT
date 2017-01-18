package yachtRental;

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
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int num = 0;
		int result = 0;
		while (in.hasNext()) {
			int name = in.nextInt();
			if (name == -1)
				return;
			String status = in.next();
			String t = in.next();
			if (name == 0) {
				if (num != 0) {
					System.out.print(num + " ");
					System.out.println((result % num == 1) ? result / num + 1 : result / num);
				} else
					System.out.println(0 + " " + 0);
				num = 0;
				result = 0;
				continue;
			}
			String[] temp = t.split(":");
			int hour = Integer.parseInt(temp[0]);
			int minute = Integer.parseInt(temp[1]);
			int time = hour * 60 + minute;
			if (status.equals("S") && map.get(name) == null)
				map.put(name, time);
			else if (status.equals("E") && map.get(name) != null) {
				result += time - map.get(name);
				num++;
				map.remove(name);
			}
		}
	}
}