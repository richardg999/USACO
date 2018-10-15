/*
ID: richgtx1
LANG: JAVA
TASK: barn1
*/
import java.util.*;
import java.io.*;

public class barn1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("barn1.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("barn1.out");
		
		int M = in.nextInt();
		int S = in.nextInt();
		int C = in.nextInt();
		
		int[] cows = new int[C];
		for (int i = 0; i < C; i++) {
			cows[i] = in.nextInt();
		}
		
		Arrays.sort(cows);
		
		ArrayList<Integer> difs = new ArrayList<>();
		for (int i = 0; i < C - 1; i++) {
			int dif = cows[i + 1] - cows[i];
			if (dif > 1) {
				difs.add(dif - 1);
			}
		}
		Collections.sort(difs);
		//System.out.println(difs);
		
		int ans = cows[cows.length - 1] - cows[0] + 1;
		//System.out.println(ans);
		
		int length = difs.size();
		M--;
		if (M > length) {
			M = length;
		}
		for (int i = 0; i < M; i++) {
			int dif = difs.get(length - 1 - i);
			ans -= dif;
		}
		out.println(ans);

		in.close();
		out.close();
	}

}
