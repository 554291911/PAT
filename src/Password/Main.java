package Password;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/Password/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String temp = in.nextLine();
			String[] str = temp.split(" ");
			boolean print = false;
			if (str[1].contains("1")) {
				str[1] = str[1].replaceAll("1", "@");
				print = true;
			}
			if (str[1].contains("0")) {
				str[1] = str[1].replaceAll("0", "%");
				print = true;
			}
			if (str[1].contains("l")) {
				str[1] = str[1].replaceAll("l", "L");
				print = true;
			}
			if (str[1].contains("O")) {
				str[1] = str[1].replaceAll("O", "o");
				print = true;
			}
			if (print)
				list.add(str[0] + " " + str[1]);
		}
		if (list.size() == 0 && n == 1) {
			System.out.println("There is " + n + " account and no account is modified");
			return;
		}
		if (list.size() == 0 && n > 1) {
			System.out.println("There are " + n + " accounts and no account is modified");
			return;
		}
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}