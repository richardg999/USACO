/*
ID: richgtx1
LANG: JAVA
TASK: snowboots
*/
import java.util.*;
import java.io.*;

public class snowboots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("snowboots.in"));
		PrintWriter out = new PrintWriter("snowboots.out");
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		int[] depths = new int[N];
		for (int i = 0; i < N; i++) {
			depths[i] = Integer.parseInt(token.nextToken());
		}
		int[] bootDepths = new int[B];
		int[] stepSizes = new int[B];
		for (int i = 0; i < B; i++) {
			token = new StringTokenizer(br.readLine());
			bootDepths[i] = Integer.parseInt(token.nextToken());
			stepSizes[i] = Integer.parseInt(token.nextToken());
		}
		
		for (int i = 0; i < B; i++) {
			boolean flag = true;
			int bootDepth = bootDepths[i];
			
			int j = 0;
			while (j < N) {
				// 
				/*for (int k = stepSizes[i]; k >= 1; k--) {
					int temp = j + k;
					if (temp >= N || bootDepths[i] >= depths[temp]) {
						j = temp;
						flag2 = true;
						break;
					}
				}*/
				boolean flag2 = true;
				int stepDistance = 1;
				if (depths[j] > bootDepth) {
					flag2 = false;
					for (int k = stepSizes[i] - 1; k >= 1; k--) {
						if (j + k >= N || bootDepth >= depths[j + k]) {
							flag2 = true;
							stepDistance = k;
							break;
						}
					}
				}
				
				if (!flag2) {
					flag = false;
					break;
				}
				j += stepDistance;
			}
			
			if (flag) {
				out.println(1);
			}
			else {
				out.println(0);
			}
		}

		//in.close();
		out.close();
		br.close();
	}

}
