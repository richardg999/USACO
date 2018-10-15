/*
ID: richgtx1
LANG: JAVA
TASK: skidesign
*/
import java.util.*;
import java.io.*;

public class skidesign {

	public static List<Integer> list;
	public static List<Integer> vals;
	public static int index1;
	public static int index2;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("skidesign.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("skidesign.out");
		
		int N = in.nextInt();
		list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		
		vals = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			vals.add(0);
		}
		
		int sum = 0;
		while (Collections.max(list) - Collections.min(list) > 17) {
			int front = testFront();
			int back = testBack();
			if (front < back) {
				setFront();
				sum += front;
			} else {
				setBack();
				sum += back;
			}
		}
		
		out.println(sum);

		in.close();
		out.close();
	}
	
	
	public static int testFront() {
		index1 = 0;
		int min = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != min) {
				index1 = i;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < index1; i++) {
			sum += giveIncrease(vals.get(i));
		}
		
		return sum;
	}
	
	
	public static int testBack() {
		index2 = 0;
		int max = list.get(list.size() - 1);
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i) != max) {
				index2 = i;
				break;
			}
		}
		int sum = 0;
		for (int i = list.size() - 1; i > index2; i--) {
			sum += giveIncrease(vals.get(i));
		}
		
		return sum;
	}
	
	
	public static void setFront() {
		for (int i = 0; i < index1; i++) {
			list.set(i, list.get(i) + 1);
			vals.set(i, vals.get(i) + 1);
		}
	}
	
	public static void setBack() {
		for (int i = list.size() - 1; i > index2; i--) {
			list.set(i, list.get(i) - 1);
			vals.set(i, vals.get(i) + 1);
		}
	}	
	
	
	public static int giveIncrease(int val) {
		int ans = 2 * val + 1;
		return ans;
	}

}
