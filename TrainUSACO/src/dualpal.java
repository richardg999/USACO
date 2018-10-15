/*
ID: richgtx1
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("dualpal.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("dualpal.out");
		
		int N = in.nextInt();
		int S = in.nextInt();
		
		int count = 0;
		int index = S + 1;
		while (count < N) {
			if (test(index) > 1) {
				count++;
				out.println(index);
			}
			index++;
		}

		in.close();
		out.close();
	}
	
	public static int test(int num) {
		int count = 0;
		for (int i = 2; i < 11; i++) {
			String convNum = Integer.toString(num, i);
			if (convNum.equals(reverse(convNum))) {
				count++;
			}
		}
		return count;
	}
	
	public static String reverse(String str) {
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			ans += str.charAt(str.length() - i - 1);
		}
		return ans;
	}

}
