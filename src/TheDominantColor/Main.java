package TheDominantColor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/ListGrades/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int row = in.nextInt();
		int col = in.nextInt();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int temp = in.nextInt();
				if (map.get(temp) == null)
					map.put(temp, 1);
				else
					map.put(temp, map.get(temp) + 1);
			}
		}
		int result = 0;
		int count = 0;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			if (entry.getValue() > result){
				result = entry.getValue();
				count = entry.getKey();
			}
		}
		System.out.println(count);
	}
}