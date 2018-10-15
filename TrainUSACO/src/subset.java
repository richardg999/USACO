/*
ID: richgtx1
LANG: JAVA
TASK: subset
*/
import java.util.*;
import java.io.*;

public class subset {

	public static int N;
	public static int subSum;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("subset.in"));
		PrintWriter out = new PrintWriter("subset.out");
		//BufferedReader br = new BufferedReader(new FileReader("subset.in"));
		
		N = in.nextInt();
		int sum = N * (N + 1) / 2;
		
		
		
		subSum = sum / 2;
		count = 0;
		/*if (sum % 2 == 0) {
			System.out.println(subSum);
			recurse(N + 1, 0);
			System.out.println(count / 2);
		}
		else {
			System.out.println("0");
		}*/
		
		/*for (int i = 1; i <= 10; i++) {
			count = 0;
			subSum = i;
			recurseSpecial(subSum + 1, 0, 0);
			System.out.print(i + ":" + count + " ");
		}
		System.out.println();*/
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				count = 0;
				subSum = j;
				recurseSpecial(subSum + 1, 0, i);
				System.out.print(j + ":" + count + " ");
			}
			System.out.println();
		}
		
		in.close();
		out.close();
		//br.close();
	}
	
	// this is outdated code
	public static void recurse(int index, int sum) {
		//System.out.println(index + " " + sum);
		if (sum == subSum) {
			count++;
		}
		else if (sum < subSum) {
			//int startIndex = Math.min(subSum - index, index - 1);
			int startIndex = index - 1;
			for (int i = startIndex; i >= 1; i--) {
				//if (i == 1) continue;
				recurse(i, sum + i);
			}
		}
	}
	
	public static void recurseSpecial(int index, int sum, int special) {
		//System.out.println(index + " " + sum);
		if (sum == subSum) {
			count++;
		}
		else if (sum < subSum) {
			//int startIndex = Math.min(subSum - index, index - 1);
			int startIndex = index - 1;
			for (int i = startIndex; i >= 1; i--) {
				if (i == special) break;
				recurseSpecial(i, sum + i, special);
			}
		}
	}
	
	

}
