/*
ID: richgtx1
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;

public class numtri {

	public static int[][] arr;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(new File("numtri.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("numtri.out");
		BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
		//N = in.nextInt();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = new int[i + 1];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				//arr[i][j] = in.nextInt();
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		
		/*int ans = recurse(0, 0, 0);
		System.out.println(ans);*/
		
		for (int i = 1; i < N; i++) {
			arr[i][0] += arr[i - 1][0];
			arr[i][i] += arr[i - 1][i - 1];
			for (int j = 1; j < i; j++) {
				int num1 = arr[i - 1][j - 1];
				int num2 = arr[i - 1][j];
				if (num1 < num2)
					arr[i][j] += num2;
				else
					arr[i][j] += num1;
			}
		}
		//System.out.println(Arrays.deepToString(arr));
		
		int max = Integer.MIN_VALUE;
		for (int num : arr[N - 1]) {
			if (num > max)
				max = num;
		}
		out.println(max);
		
		//in.close();
		br.close();
		out.close();
	}
	
	public static int recurse(int a, int b, int sum) {
		if (a == N || b == N) return sum;
		sum += arr[a][b];
		
		int sum1 = recurse(a + 1, b, sum);
		int sum2 = recurse(a + 1, b + 1, sum);
		if (sum1 < sum2) return sum2;
		return sum1;
	}

}
