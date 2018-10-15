/*
ID: richgtx1
LANG: JAVA
TASK: lifeguards2
*/
import java.util.*;
import java.io.*;

public class lifeguards2 {

	public static ArrayList<Integer> starts;
	public static ArrayList<Integer> ends;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("lifeguards.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("lifeguards.out");
		
		N = in.nextInt();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++ ) {
			map.put(in.nextInt(), in.nextInt());
		}
		
		starts = new ArrayList<>(N);
		starts.addAll(map.keySet());
		
		ends = new ArrayList<>(N);
		ends.addAll(map.values());
		
		
		int ans = Integer.MAX_VALUE;
		int total = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < N - 1; i++) {
			if (ends.get(i + 1) < ends.get(i)) {
				ends.set(i + 1, ends.get(i));
				ans = 0;
			}
			int space = starts.get(i + 1) - ends.get(i);
			if (space > 0) 
			{
				total += space;
				
				b = i;
				int temp = testBlock(a, b);
				if (temp < ans) 
				{
					if (temp <= 0) 
					{
						ans = 0;
						break;
					}
					else 
					{
						ans = temp;
					}
				}
				a = i + 1;
			}
			
		}
		b = N - 1;
		
		int temp = testBlock(a, b);
		if (temp < ans) 
		{
			if (temp <= 0) 
			{
				ans = 0;
			}
			else 
			{
				ans = temp;
			}
		}
		
		int realAns = ends.get(N - 1) - starts.get(0) - total - ans;
		
		out.println(realAns);

		in.close();
		out.close();
	}
	
	public static int testBlock(int a, int b) {
		if (a == N - 1 || b == 0) return Integer.MAX_VALUE;
		int ans = starts.get(a + 1) - starts.get(a);
		int temp = ends.get(b) - ends.get(b - 1);
		if (temp < ans) {
			if (temp <= 0) {
				return 0;
			}
			else {
				ans = temp;
			}
		}
		
		for (int i = a + 1; i < b; i++) {
			int value = starts.get(i + 1) - ends.get(i - 1);
			if (value < ans) {
				if (value <= 0) {
					return 0;
				}
				else {
					ans = value;
				}
			}
		}
		return ans;
	}

}
