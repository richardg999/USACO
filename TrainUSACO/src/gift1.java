/*
ID: richgtx1
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

public class gift1 {

	public static String[] names;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("gift1.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("gift1.out");
		
		int NP = in.nextInt();
		names = new String[NP];
		int[] val = new int[NP];
		for(int i = 0; i < NP; i++) 
		{
			names[i] = in.next();
		}
		
		for(int counter = 0; counter < NP; counter++)
		{
			String friendName = in.next();
			int i = findFriend(friendName);
			int value = in.nextInt();
			val[i] += -1 * value;
			
			int numGive = in.nextInt();
			int valGive;
			int remainder;
			if(numGive > 0)
				{
					valGive = value / numGive;
					remainder = value % numGive;
				}
			else
			{
				valGive = 0;
				remainder = value;
			}
			val[i] += remainder;
			
			for(int j = 0; j < numGive; j++)
			{
				String friend = in.next();
				int friendNum = findFriend(friend);
				val[friendNum] += valGive;
			}
			//print(val);
		}
		
		for(int i = 0; i < NP; i++)
		{
			out.println(names[i] + " " + val[i]);
		}

		in.close();
		out.close();
	}
	
	public static int findFriend(String name)
	{
		for(int i = 0; i < names.length; i++)
		{
			if(names[i].equals(name))
			{
				return i;
			}
		}
		return 0;
	}
	
	static void print(int[] a){
        for(int i = 0; i < a.length; i++)
           System.out.print(a[i] + " ");
       System.out.println();
	}

}
