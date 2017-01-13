package MaximumSubsequenceSum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/MaximumSubsequenceSum/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = in.nextInt();
		int thisSum = 0, maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			thisSum+=arr[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}
		System.out.println(maxSum);
	}
}