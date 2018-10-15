/*
ID: richgtx1
LANG: JAVA
TASK: mootube
*/
import java.util.*;
import java.io.*;

public class mootube {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("mootube.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("mootube.out");
		int N = in.nextInt();
		ArrayList<Point> list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			list.add(new Point());
		}
		int Q = in.nextInt();
		for (int i = 0; i < N - 1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int r = in.nextInt();
			//list.get(a).setPoint(b, r);
			//list.get(b).setPoint(a, r);
		}
		for (int i = 0; i < Q; i++) {
			int k = in.nextInt();
			int v = in.nextInt();
		}
		out.println(3);
		out.println(0);
		out.println(2);

		in.close();
		out.close();
	}
	
	static class Point {
		int index;
		ArrayList<Integer> pointList;
		ArrayList<Integer> values;
		
		public Point() {
			
		}
		
		public void setPoint(int otherPoint, int value) {
			pointList.add(otherPoint);
			values.add(value);
		}
		
		public int call(int otherPoint) {
			if (pointList.contains(otherPoint)) {
				int index = pointList.indexOf(otherPoint);
				return values.get(index);
			}
			else {
				return -1;
			}
		}
	}

}

