/*
ID: richgtx1
LANG: JAVA
TASK: sort3
*/
import java.util.*;
import java.io.*;

public class sort3 {

	public static int[] arr;
	public static int[] correctArr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("sort3.in"));
		PrintWriter out = new PrintWriter("sort3.out");
		BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		correctArr = Arrays.copyOf(arr, N);
		Arrays.sort(correctArr);
		
		int[][] matrix = new int[3][3];
		for (int i = 0; i < N; i++) {
			int a = arr[i] - 1;
			int b = correctArr[i] - 1;
			matrix[a][b] += 1;
		}
		
		// this is to count the "optimal" switches. Ex: 1,2 and 2,1
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) continue;
				int a = matrix[i][j];
				int b = matrix[j][i];
				if (a <= b) {
					matrix[i][j] -= a;
					matrix[j][i] -= a;
					count += a;
				}
			}
		}
		// these two below are just representative coordinates, I could have used 2,1 and 1,2 as well
		// it is used to find the "cycles" of 1,2 -- 2,3 -- 3,1, which require 2 switches
		count += 2 * Math.max(matrix[0][1], matrix[1][0]);
		
		out.println(count);

		//in.close();
		out.close();
		br.close();
	}
	
	/*
	public static void exchange(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	*/
}
