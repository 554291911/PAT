package ProductofPolynomials;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/ProductofPolynomials/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer,Long> A = new HashMap<Integer,Long>();
		HashMap<Integer,Long> B = new HashMap<Integer,Long>();
		HashMap<Integer,Long> map = new HashMap<Integer,Long>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			A.put(in.nextInt(), in.nextLong());
		n = in.nextInt();
		for (int i = 0; i < n; i++) 
			B.put(in.nextInt(), in.nextLong());
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < B.size(); j++) {
				
			}
		}
	}
}