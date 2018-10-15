/*
ID: richgtx1
LANG: JAVA
TASK: milk3
*/
import java.util.*;
import java.io.*;

public class milk3 {

	public static int a;
	public static int b;
	public static int c;
	public static int[] max;
	public static TreeSet<Integer> ans;
	public static ArrayList<int[]> dp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("milk3.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("milk3.out");
		
		max = new int[3];
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		max[0] = a;
		max[1] = b;
		max[2] = c;
		
		dp = new ArrayList<int[]>();
		ans = new TreeSet<Integer>();
		
		/*
		int[] test = {1,2,3};
		test = pourBucket(test, 0, 1);
		System.out.println(Arrays.toString(test));*/
		
		int[] start = new int[3];
		start[2] = c;
		
		
		pour(start, 30);
		
		String ansStr = "";
		for (int num : ans) {
			ansStr += num + " ";
		}
		ansStr = ansStr.trim();
		out.println(ansStr);
		
		//System.out.println(Arrays.toString(test));

		in.close();
		out.close();
	}
	
	
	public static void pour(int[] arr, int count) {
		if (count == 0) return;
		else if (arr[0] == 0) {
			ans.add(arr[2]);
		}
		for (int[] listArr : dp) {
			if (Arrays.equals(arr, listArr)) {
				return;
			}
		}
		
		dp.add(arr);
		
		int[] newArr;
		for (int i = 0; i < 3; i++) {
			newArr = new int[3];
			for (int j = 0; j < 3; j++) {
				if (i == j) continue;
				newArr = pourBucket(arr, i, j);
				//System.out.println(Arrays.toString(newArr));
				pour(newArr, count - 1);
			}
		}
		
	}
	
	// pour b1 into b2
	public static int[] pourBucket(int[] arr, int b1, int b2) {
		int[] newArr = Arrays.copyOf(arr, 3);
		
		int posFill = max[b2] - arr[b2];
		//System.out.println(posFill);
		if (arr[b1] > posFill) {
			newArr[b2] += posFill;
			newArr[b1] -= posFill;
		}
		else {
			newArr[b2] += arr[b1];
			newArr[b1] = 0;
		}
		
		return newArr;
	}

}
