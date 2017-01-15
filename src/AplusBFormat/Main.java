package AplusBFormat;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		String result = in.nextInt() + in.nextInt() + "";
		String[] str = result.split("");
		int dou = 0;
		int length = str.length - 1;
		if (str[1].equals("-"))
			length--;
		dou = length / 3;
		if (length % 3 == 0)
			dou--;
		String[] results = new String[dou + str.length - 1];
		int s = str.length - 1;
		int flag = 0;
		for (int i = results.length - 1; i >= 0; i--) {
			if (flag++ == 3 && dou != 0) {
				results[i] = ",";
				dou--;
				flag = 0;
			} else
				results[i] = str[s--];
		}
		String st = "";
		for (int i = 0; i < results.length; i++) {
			st += results[i];
		}
		System.out.println(st);
	}
}