package A1084BrokenKeyboard20;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	static boolean LOCAL = System.getSecurityManager() == null;

	public static void main(String[] args) {
		if (LOCAL) {
			try {
				System.setIn(new java.io.FileInputStream(Main.class.getResource("input.txt").toString().substring(6)));
			} catch (FileNotFoundException e) {
				LOCAL = false;
			}
		}
		Scanner in = new Scanner(System.in);
		String flag = in.nextLine();
		char[] tag = flag.toCharArray();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < tag.length; i++)
			map.put((tag[i] + "").toUpperCase(), true);
		flag = in.nextLine();
		char[] tag2 = flag.toCharArray();
		for (int i = 0; i < tag2.length; i++)
			map.put((tag2[i] + "").toUpperCase(), false);
		Iterator<Entry<String, Boolean>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Boolean> e = it.next();
			if (e.getValue())
				set.add(e.getKey());
		}
		for (int i = 0; i < tag.length; i++) {
			if (set.contains((tag[i] + "").toUpperCase())) {
				System.out.print((tag[i] + "").toUpperCase());
				set.remove((tag[i] + "").toUpperCase());
			}
		}
	}
}