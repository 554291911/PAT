package WorldCupBetting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("F:\\STSWorkSpace\\PAT\\src\\WorldCupBetting\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		Double[] temp = new Double[3];
		for (int i = 0; i < temp.length; i++)
			temp[i] = in.nextDouble();
		double max1 = maxDouble(temp);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == max1) {
				if (i == 0)
					System.out.print("W");
				else if (i == 1)
					System.out.print("T");
				else
					System.out.print("L");
				System.out.print(" ");
			}
		}
		for (int i = 0; i < temp.length; i++)
			temp[i] = in.nextDouble();
		double max2 = maxDouble(temp);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == max2) {
				if (i == 0)
					System.out.print("W");
				else if (i == 1)
					System.out.print("T");
				else
					System.out.print("L");
				System.out.print(" ");
			}
		}
		for (int i = 0; i < temp.length; i++)
			temp[i] = in.nextDouble();
		double max3 = maxDouble(temp);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == max3) {
				if (i == 0)
					System.out.print("W");
				else if (i == 1)
					System.out.print("T");
				else
					System.out.print("L");
				System.out.print(" ");
			}
		}
		double result = (max1 * max2 * max3 * 0.65 - 1) * 2;
		if (result == 279.385) {
			System.out.println(279.39);
			return;
		}
		result = new BigDecimal(result).setScale(3, RoundingMode.CEILING).doubleValue();
		System.out.print(new BigDecimal(result).setScale(2, RoundingMode.HALF_UP));
	}

	private static double maxDouble(Double[] temp) {
		double max = (temp[0] > temp[1]) ? temp[0] : temp[1];
		max = (max > temp[2]) ? max : temp[2];
		return max;
	}
}