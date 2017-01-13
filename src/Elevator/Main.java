package Elevator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/Elevator/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int begin = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int temp = in.nextInt();
			int through = temp - begin;
			if (through >= 0)
				result += through * 6 + 5;
			else
				result += (-through) * 4 + 5;
			begin = temp;
		}
		System.out.println(result);
	}
}