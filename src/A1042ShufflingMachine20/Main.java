package A1042ShufflingMachine20;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		String[] map = { "", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "H1",
				"H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13", "C1", "C2", "C3", "C4",
				"C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "D1", "D2", "D3", "D4", "D5", "D6", "D7",
				"D8", "D9", "D10", "D11", "D12", "D13", "J1", "J2" };
		String[] m = Arrays.copyOf(map, map.length);
		int num = in.nextInt();
		int[] sort = new int[55];
		for (int i = 1; i < 55; i++)
			sort[i] = in.nextInt();
		for (int i = 0; i < num; i++) {
			for (int j = 1; j < sort.length; j++)
				m[sort[j]] = map[j];
			map = Arrays.copyOf(m, m.length);
		}
		for (int i = 1; i < m.length; i++) {
			if (i != 54)
				System.out.print(map[i] + " ");
			else
				System.out.println(map[i]);
		}

	}
}