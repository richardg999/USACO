/*
ID: richgtx1
LANG: JAVA
TASK: milk
*/
import java.util.*;
import java.io.*;

public class milk {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("milk.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("milk.out");
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		/*int[] prices = new int[M];
		int[] amounts = new int[M];
		
		for (int i = 0; i < M; i++) {
			prices[i] = in.nextInt();
			amounts[i] = in.nextInt();
		}*/
		
		ArrayList<Integer> prices = new ArrayList<>(M);
		ArrayList<Integer> amounts = new ArrayList<>(M);
		
		for (int i = 0; i < M; i++) {
			prices.add(in.nextInt());
			amounts.add(in.nextInt());
		}
		//System.out.println(prices);
		//System.out.println(amounts);
		
		//Collections.sort(prices);
		//System.out.println(prices);
		
		int sum = 0;
		while (N > 0) {
			int min = Collections.min(prices);
			int index = prices.indexOf(min);
			int amount = amounts.get(index);
			//System.out.println(min + " " + amount);
			if (N - amount < 0) {
				sum += N * min;
				break;
			}
			else {
				N -= amount;
				sum += min * amount;
			}
			prices.remove(index);
			amounts.remove(index);
		}
		out.println(sum);
		

		in.close();
		out.close();
	}
	/*0 4456
3 7147
4 9614
4 9593
5 6955
5 2797
6 7698
9 4046
10 4623
13 8440
15 5798
16 2647
16 5102
16 3323
16 5905
21 6786
21 6525
917244*/

}
