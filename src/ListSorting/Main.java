package ListSorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
	String id;
	String name;
	int score;
	int method;

	public Student(String id, String name, int score, int method) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.method = method;
	}

	@Override
	public int compareTo(Student o) {
		if (o.method == 1) {
			return this.id.compareTo(o.id);
		} else if (o.method == 2) {
			if (name.equals(o.name))
				return this.id.compareTo(o.id);
			else
				return this.name.compareTo(o.name);
		} else {
			if (score == o.score)
				return this.id.compareTo(o.id);
			else
				return score - o.score;
		}

	}

	public String toString() {
		return id + " " + name + " " + score;
	}

}

public class Main {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:/Users/xxh/Desktop/workspace/PAT/src/ListSorting/input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int method = Integer.parseInt(s[1]);
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			String temp = in.nextLine();
			String[] str = temp.split(" ");
			list.add(new Student(str[0], str[1], Integer.parseInt(str[2]), method));
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}