package A1007MaximumSubsequenceSum25;

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
			int n = in.nextInt();
			if (n == 0)
				return;
			int[] arr = new int[n];
			int k = 0;
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
				if (arr[i] > 0)
					flag = false;
			}
			if (flag) {
				System.out.println(0 + " " + arr[0] + " " + arr[arr.length - 1]);
				continue;
			}
			int thisSum = 0, maxSum = 0;
			int start = 0;
			int end = 0;
			int temp = 0;
			for (int i = 0; i < arr.length; i++) {
				thisSum += arr[i];
				if (thisSum > maxSum) {
					maxSum = thisSum;
					end = i;
					start = temp;
				} else if (thisSum < 0) {
					thisSum = 0;
					temp = i + 1;
				} else if (maxSum < 0) {
					maxSum = 0;
					start = 0;
					end = arr.length - 1;
				}
			}
			System.out.println(maxSum + " " + arr[start] + " " + arr[end]);
		}
	}
}