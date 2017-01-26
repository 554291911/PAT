package stillXxxLaw;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		while (in.hasNext()) {
			int num = in.nextInt();
			if (num == 0)
				return;
			int k = 0;
			int n = num;
			String tag = "";
			while (num != 1) {
				k++;
				if (num % 2 == 0)
					num = num >> 1;
				else {
					num = 3 * num + 1;
					num = num >> 1;
				}
				tag += num + " ";
			}
			// System.out.println(n + ":" + tag);
			String result = "";
			for (int i = 0; i < n; i++) {
				num = in.nextInt();
				int z = num;
				String p = "";
				while (num != 1) {
					k++;
					if (num % 2 == 0)
						num = num >> 1;
					else {
						num = 3 * num + 1;
						num = num >> 1;
					}
					set.add(num);
					p += num + " ";
				}
				// System.out.println(z + ":" + p);
				if (p.endsWith(tag) && !set.contains(z) && z > 1)
					result = " " + z + result;
			}
			System.out.println(result.substring(1));
		}
	}
}