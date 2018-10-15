/*
ID: richgtx1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class ride {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("ride.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("ride.out");
		
		String word = in.next();
		String word2 = in.next();
		int sum1 = 1;
		for(int i = 0; i < word.length(); i++)
		{
			int let = word.charAt(i) - 64;
			sum1 *= let;
			//System.out.println(let);
		}
		int sum2 = 1;
		for(int i = 0; i < word2.length(); i++)
		{
			int let = word2.charAt(i) - 64;
			sum2 *= let;
		}
		if(sum1 % 47 == sum2 % 47)
			out.println("GO");
		else
			out.println("STAY");
		//System.out.println(sum1 + " " + sum2);
		in.close();
		out.close();

	}

}
