/*
ID: richgtx1
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;

public class palsquare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("palsquare.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("palsquare.out");
		
		int radix = in.nextInt();
		
		for (int i = 1; i < 301; i++) {
			int squared = i * i;
			String ans1 = Integer.toString(i, radix);
			ans1 = ans1.toUpperCase();
			String str1 = Integer.toString(squared, radix);
			str1 = str1.toUpperCase();
			//System.out.println(str1);
			String str2 = reverse(str1);
			if (str1.equals(str2)) {
				out.println(ans1 + " " + str1);
			}
			
		}

		in.close();
		out.close();
	}
	
	public static String reverse(String str) {
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			ans += str.charAt(str.length() - i - 1);
		}
		return ans;
	}

}
