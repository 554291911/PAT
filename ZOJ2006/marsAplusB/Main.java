package marsAplusB;

import java.util.Scanner;

public class Main {

	static int[] su = new int[30];

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		getSuArr();
		while (in.hasNext()) {
			String a = in.next();
			String b = in.next();
			if (a.equals("0") && b.equals("0"))
				return;
			String result = plus(a, b);
			System.out.println(result);
		}
	}

	private static String plus(String a, String b) {
		int jin = 0;
		String[] At = a.split(",");
		String[] Bt = b.split(",");
		int cha = At.length - Bt.length;
		String[] A;
		String[] B;
		if (cha > 0) {
			A = new String[At.length + 1];
			B = new String[At.length + 1];
			A[0] = "0";
			B[0] = "0";
			for (int i = 1; i < A.length; i++)
				A[i] = At[i - 1];
			for (int j = 0; j < cha + 1; j++)
				B[j] = "0";
			for (int i = ++cha; i < B.length; i++)
				B[i] = Bt[i - cha];
		} else if (cha < 0) {
			cha = -cha;
			A = new String[Bt.length + 1];
			B = new String[Bt.length + 1];
			A[0] = "0";
			B[0] = "0";
			for (int i = 1; i < B.length; i++)
				B[i] = Bt[i - 1];
			for (int j = 1; j < cha + 1; j++)
				A[j] = "0";
			for (int i = ++cha; i < A.length; i++)
				A[i] = At[i - cha];
		} else {
			A = new String[At.length + 1];
			B = new String[At.length + 1];
			A[0] = "0";
			B[0] = "0";
			for (int i = 1; i < A.length; i++)
				A[i] = At[i - 1];
			for (int i = 1; i < B.length; i++)
				B[i] = Bt[i - 1];
		}
		int[] r = getResult(A, B);
		String result = "";
		boolean flag = false;
		for (int i = 0; i < r.length - 1; i++) {
			if (r[i] != 0)
				flag = true;
			if (flag)
				result += r[i] + ",";
		}
		result += r[r.length - 1];
		return result;
	}

	private static int[] getResult(String[] a, String[] b) {
		int jin = 0;
		int k = 0;
		int r = a.length - 1;
		int[] result = new int[a.length];
		for (int i = b.length - 1; i >= 0; i--) {
			int sum = Integer.parseInt(a[i]) + Integer.parseInt(b[i]) + jin;
			jin = sum / su[k];
			int yu = sum % su[k++];
			result[r--] = yu;
		}
		return result;
	}

	private static void getSuArr() {
		su[0] = 2;
		su[1] = 3;
		su[2] = 5;
		su[3] = 7;
		int[] map = new int[120];
		for (int i = 0; i < map.length; i++) {
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
				map[i] = 1;
		}
		int start = 4;
		for (int i = 4; i < su.length; i++) {
			for (int j = start; j < map.length; j++) {
				if (map[j] == 0) {
					start = j + 1;
					map[j] = 1;
					break;
				}
			}
			su[i] = start - 1;
		}
	}
}