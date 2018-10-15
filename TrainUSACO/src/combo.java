/*
ID: richgtx1
LANG: JAVA
TASK: combo
*/
import java.util.*;
import java.io.*;

public class combo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("combo.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("combo.out");
		
		int N = in.nextInt();
		
		int[] num = new int[N + 4];
		num[0] = N - 1;
		num[1] = N;
		num[N + 2] = 1;
		num[N + 3] = 2;
		for (int i = 2; i < N + 2; i++) {
			num[i] = i - 1;
		}
		//System.out.println(Arrays.toString(num));
		
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int a3 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();
		int b3 = in.nextInt();
		
		ArrayList<String> ans1 = new ArrayList<>();
		for (int i = a1 - 1; i < a1 + 4; i++) {
			for (int j = a2 - 1; j < a2 + 4; j++) {
				for (int k = a3 - 1; k < a3 + 4; k++) {
					String temp = "" + num[i] + "," + num[j] + "," + num[k];
					ans1.add(temp);
				}
			}
		}
		//System.out.println(ans1);
		
		ArrayList<String> ans2 = new ArrayList<>();
		for (int i = b1 - 1; i < b1 + 4; i++) {
			for (int j = b2 - 1; j < b2 + 4; j++) {
				for (int k = b3 - 1; k < b3 + 4; k++) {
					String temp = "" + num[i] + "," + num[j] + "," + num[k];
					ans2.add(temp);
				}
			}
		}
		//System.out.println(ans2);
		
		/*int overlap = 0;
		for (int i = 0; i < ans1.size(); i++) {
			for (int j = 0; j < ans2.size(); j++) {
				if(ans1.get(i).equals(ans2.get(j))) {
					overlap++;
				}
			}
		}
		System.out.println(overlap); */
		
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < ans1.size(); i++) {
			if (!ans.contains(ans1.get(i))) {
				ans.add(ans1.get(i));
			}
			if (!ans.contains(ans2.get(i))) {
				ans.add(ans2.get(i));
			}
		}
		if (N == 1) {
			out.println("1");
		}
		else {
			//System.out.println(ans);
			out.println(ans.size());
		}
			
		
		/*int ans = ans1.size() + ans2.size() - overlap;
		if (N == 1) {
			ans = 1;
		}
		System.out.println(ans);*/

		in.close();
		out.close();
	}

}
