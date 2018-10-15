/*
ID: richgtx1
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("beads.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("beads.out");
		
		int N = in.nextInt();
		N *= 2;
		String beadsOriginal = in.next();
		//System.out.println(beadsOriginal);
		String beads = beadsOriginal + beadsOriginal;
		
		ArrayList<Character> color = new ArrayList<>();
		ArrayList<Integer> value = new ArrayList<>();
		char temp = 'a';
		int length1 = 0;
		
		for(int i = 0; i < N; i++)
		{
			char let = beads.charAt(i);
			if (temp != let)
			{
				temp = let;
				color.add(temp);
				value.add(length1);
				length1 = 1;
			}
			else
			{
				length1++;
			}
		}
		value.remove(0);
		value.add(length1);
		//System.out.println(color);
		//System.out.println(value);
		
		
		temp = 'a';
		
		for(int i = 0; i < color.size(); i++)
		{
			char let = color.get(i);
			if(let == 'b' || let == 'r')
			{
				if(temp == let)
				{
					//System.out.println("hi");
					value.set(i, value.get(i) + value.get(i - 1) + value.get(i - 2));
					value.set(i - 1, 0);
					value.set(i - 2, 0);
				}
				temp = let;
				//System.out.println(temp);
			}
		}
		
		//System.out.println(color);
		//System.out.println(value);
		
		
		for(int i = 0; i < value.size(); i++)
		{
			if(value.get(i) == 0)
			{
				value.remove(i);
				color.remove(i);
				i--;
			}
		}
		
		//hooray fragments have been consolidated
		//System.out.println(color);
		//System.out.println(value);
		
		//now its time to fix the edge
		
		
		
		//finally time for calculations
		int max = -1;
		for(int i = 2; i < value.size() - 2; i++)
		{
			int tempValue = 0;
			if(color.get(i) == 'w')
			{
				tempValue = value.get(i) + value.get(i - 1) + value.get(i + 1);
				if(color.get(i - 2) == 'w')
					tempValue += value.get(i - 2);
				if(i < value.size() - 2 && color.get(i + 2) == 'w')
					tempValue += value.get(i + 2);
			}
			else
			{
				tempValue = value.get(i) + value.get(i + 1);
				if(color.get(i - 1) == 'w')
					tempValue += value.get(i - 1);
				if(i < value.size() - 2 && color.get(i + 2) == 'w')
					tempValue += value.get(i + 2);
			}
			//System.out.print(tempValue + " ");
			if(tempValue > max)
			{
				max = tempValue;
			}
			
		}
		//System.out.println(max);
		
		//all this is old code for finding edge case
		/*
		//edge case
		int sum = 0;
		char firstLet = 'a';
		for(int i = 0; i < value.size() - 1; i++)
		{
			char let = color.get(i);
			if(let == 'b' || let == 'r')
			{
				firstLet = let;
				for(int j = 0; j <= i; j++)
				{
					sum += value.get(j);
					//System.out.println(sum);
				}
				if(color.get(i + 1) == 'w')
				{
					sum += value.get(i + 1);
				}
				break;
			}
		}
		System.out.println(sum);
		/*for(int i = value.size() - 1; i >= 1; i--) 
		{
			char let = color.get(i);
			if(let == 'w' || let == firstLet)
			{
				//empty here
			}
			else
			{
				for(int j = value.size() - 1; j >= i; j--)
				{
					sum += value.get(j);
				}
				if(color.get(i - 1) == 'w')
				{
					sum += value.get(i - 1);
				}
				break;
			}
		}
		for(int i = value.size() - 1; i >= 1; i--) 
		{
			char let = color.get(i);
			if(let == firstLet)
			{
				for(int j = value.size() - 1; j >= i; j--)
				{
					sum += value.get(j);
				}
				if(color.get(i - 1) == 'w')
				{
					sum += value.get(i - 1);
				}
				break;
			}
			else if(let == 'w')
			{
				
			}
			else
			{
				
			}
		}
		
		
		System.out.println(sum);
		if(sum > max)
		{
			max = sum;
		}
		*/
		
		if(max == -1)
		{
			max = beadsOriginal.length();
		}
		
		if(max > beadsOriginal.length())
		{
			max = beadsOriginal.length();
		}
		out.println(max);

		in.close();
		out.close();
	}
// 8 rbwwbrbr
//77 rwrwrwrwrwrwrwrwrwrwrwrwbwrwbwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwr
}
