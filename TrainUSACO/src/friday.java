/*
ID: richgtx1
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

public class friday {

	public static int[] normalYear = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
	public static int[] leapYear = {31, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("friday.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("friday.out");
		
		int[] ans = {2, 1, 1, 3, 1, 2, 2};
		int N = in.nextInt();
		//skip to Dec 31 1900
		int start = 5;
		int year = 1901;
		
		for(int i = 0; i < N - 1; i++)
		{
			if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			{
				for(int j = 0; j < leapYear.length; j++)
				{
					start += leapYear[j];
					start %= 7;
					ans[start] += 1;
				}
			}
			else
			{
				for(int j = 0; j < normalYear.length; j++)
				{
					start += normalYear[j];
					start %= 7;
					ans[start] += 1;
				}
			}
			year++;
			
		}
		
		for(int i = 0; i < 6; i++)
		{
			out.print(ans[i] + " ");
		}
		out.println(ans[6]);
		
		

		in.close();
		out.close();
	}

}
