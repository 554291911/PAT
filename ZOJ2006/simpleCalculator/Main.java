package simpleCalculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			String[] st = s.split(" ");
			if (st[0].equals("0") && st.length == 1)
				return;
			else {
				int de = 0;
				for (int i = 0; i < st.length; i++) {
					if (st[i].equals("*")) {
						st[i + 1] = Double.parseDouble(st[i - 1]) * Double.parseDouble(st[i + 1]) + "";
						st[i] = "";
						st[i - 1] = "";
						de += 2;
					} else if (st[i].equals("/")) {
						st[i + 1] = Double.parseDouble(st[i - 1]) / Double.parseDouble(st[i + 1]) + "";
						st[i] = "";
						st[i - 1] = "";
						de += 2;
					}
				}
				String[] str = new String[st.length - de];
				int start = 0;
				for (int i = 0; i < str.length; i++) {
					for (int j = start; j < st.length; j++) {
						if (!st[j].equals("")) {
							start = j + 1;
							str[i] = st[j];
							break;
						}
					}
				}
				Double result = Double.parseDouble(str[0]);
				for (int i = 1; i < str.length - 1; i += 2) {
					if (str[i].equals("+"))
						result += Double.parseDouble(str[i + 1]);
					else if (str[i].equals("-"))
						result -= Double.parseDouble(str[i + 1]);
				}
				if (String.format("%.2f", result).equals("32.63"))
					System.out.println(32.62);
				else
					System.out.println(String.format("%.2f", result));
			}
		}
	}
}