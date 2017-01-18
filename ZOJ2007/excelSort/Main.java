package excelSort;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

public class Main {
	static class Student implements Comparable<Student> {
		String id;
		String name;
		int score;
		char type;

		public Student(String id, String name, int score, char type) {
			this.id = id;
			this.name = name;
			this.score = score;
			this.type = type;
		}

		@Override
		public int compareTo(Student stu) {
			if (this.type == '1')
				return this.id.compareTo(stu.id);
			else if (this.type == '2') {
				if (this.name.equals(stu.name))
					return this.id.compareTo(stu.id);
				return this.name.compareTo(stu.name);
			} else if (this.type == '3') {
				if (this.score == stu.score)
					return this.id.compareTo(stu.id);
				return this.score - stu.score;
			}
			return 0;
		}
	}

	public static void printInfo(PriorityQueue<Student> s) {
		StringBuilder sb = new StringBuilder();
		while (s.size() > 0) {
			Student stu = s.poll();
			sb.append(stu.id).append(" ").append(stu.name).append(" ").append(stu.score).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static String reader(InputStream cin) throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while ((ch = cin.read()) != -1) {
			if ((ch == '\n') || (ch == ' '))
				return sb.toString();
			else
				sb.append((char) ch);
			if (ch == -1)
				System.exit(0);
		}
		if (sb.length() != 0)
			return sb.toString();
		return null;
	}

	public static void main(String[] args) throws Exception, IOException {
		int n = 0, flag = 0;
		char c;
		InputStream cin = System.in;
		while (System.in != null) {
			n = Integer.parseInt(reader(cin));
			if (n == 0) {
				cin.close();
				break;
			}
			flag++;
			c = reader(cin).charAt(0);
			PriorityQueue<Student> stu = new PriorityQueue<Student>(n);
			for (int i = 0; i < n; i++)
				stu.add(new Student(reader(cin), reader(cin), Integer.parseInt(reader(cin)), c));
			System.out.println("Case " + flag + ":");
			printInfo(stu);
		}
	}
}