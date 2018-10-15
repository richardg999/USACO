/*
ID: richgtx1
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;

public class ariprog {

	public static TreeSet<Integer> set;
	public static int N;
	public static int M;
	public static Integer[] setArr;
	public static ArrayList<Point> ansList;
	public static HashSet<Integer> hash;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("ariprog.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("ariprog.out");
		
		N = in.nextInt();
		ansList = new ArrayList<Point>();
		set = new TreeSet<Integer>();
		hash = new HashSet<Integer>();
		
		M = in.nextInt();
		findBisquares(M);
		setArr = set.toArray(new Integer[set.size()]);
		hash.addAll(set);
		System.out.println(hash);
		if (N < 12) {
			for (int i = 0; i <= setArr.length - N; i++) {
				findSequence(i);
			}
		}
		else {
			/*for (int i = 0; i <= setArr.length - N; i++) {
				findLargeSequence(i);
			}*/
			findLargeSequence2();
		}
		
		if (!ansList.isEmpty()) {
			Collections.sort(ansList);
			for (Point p : ansList) {
				System.out.println(p.x + " " + p.y);
			}
		}
		else {
			System.out.println("NONE");
		}

		in.close();
		out.close();
	}
	
	public static void findBisquares(int num) {
		//int max = (int) Math.sqrt(num);
		int max = num;
		for (int i = 0; i <= max; i++) {
			int a = i * i;
			for (int j = 0; j <= max; j++) {
				int b = j * j;
				set.add(a + b);
			}
		}
	}
	
	// Proposal: "mesh technique" to find all sequences with certain length between sequential numbers
	public static void findSequence(int index) {
		int num = setArr[index];
		int maxNum = (setArr[setArr.length - 1] - num) / (N - 1) + num;
		//System.out.println(maxNum);
		//int max can be more optimized with approxIndexOf method
		//int max = approxIndexOf(maxNum, 0);
		//ignore above
		int max = setArr.length - 1;
		for (int i = index; i <= max; i++) {
			if (i > maxNum) break;
			int distance = setArr[i] - num;
			if (N != 3 && distance % 4 != 0) continue;
			int tempNum = setArr[i];
			int tempIndex = orderedIndexOf(tempNum + distance, index);
			int count = 0;
			while (tempIndex != -1) {
				tempNum += distance;
				tempIndex = orderedIndexOf(tempNum + distance, tempIndex);
				count++;
				if (count == N - 2) {
					Point p = new Point(num, distance);
					ansList.add(p);
					break;
				}
			}
		}
	}
	
	public static void findLargeSequence(int index) {
		int num = setArr[index];
		int maxNum = (setArr[setArr.length - 1] - num) / (N - 1) + num;
		//System.out.println(maxNum);
		//int max can be more optimized with approxIndexOf method
		//int max = approxIndexOf(maxNum, 0);
		//ignore above
		int max = setArr.length - 1;
		for (int i = index; i <= max; i++) {
			if (i > maxNum) break;
			int distance = setArr[i] - num;
			if (distance % 84 != 0) continue;
			int tempNum = setArr[i];
			int tempIndex = orderedIndexOf(tempNum + distance, index);
			int count = 0;
			while (tempIndex != -1) {
				tempNum += distance;
				tempIndex = orderedIndexOf(tempNum + distance, tempIndex);
				count++;
				if (count == N - 2) {
					Point p = new Point(num, distance);
					ansList.add(p);
					break;
				}
			}
		}
	}
	
	public static void findLargeSequence2() {
		int max = M * M;
		for (int i = 84; i < max; i += 84) {
			for (int num : hash) {
				int count = 0;
				int tempNum = num + i;
				while (hash.contains(tempNum)) {
					count++;
					tempNum += i;
					if (count == N - 1) {
						Point p = new Point(num, i);
						ansList.add(p);
						break;
					}
				}
			}
		}
	}
	
	public static int orderedIndexOf(int num, int index) {
		if (index >= setArr.length) return -1;
		while (setArr[index] <= num && index < setArr.length - 1) {
			index++;
			if (setArr[index] == num) {
				return index;
			}
		}
		return -1;
	}
	
	// for greater optimization if necessary
	public static int approxIndexOf(int num, int index) {
		if (index >= setArr.length) return setArr.length - 1;
		while (index < setArr.length - 1) {
			index++;
			if (setArr[index] >= num) {
				return index;
			}
		}
		return setArr.length - 1;
	}
	
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return x + "," + y;
		}
		
		public int compareTo(Point p) {
			if (this.y != p.y) {
				return this.y - p.y;
			}
			else {
				return this.x - p.x;
			}
		}
	}
}



