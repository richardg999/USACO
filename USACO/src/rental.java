/*
ID: richgtx1
LANG: JAVA
TASK: rental
*/
import java.util.*;
import java.io.*;

public class rental {

	public static TreeMap<Integer, Integer> milk;
	public static ArrayList<Integer> milkSet;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(new File("rental.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("rental.out");
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		StringTokenizer token1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token1.nextToken());
		int M = Integer.parseInt(token1.nextToken());
		int R = Integer.parseInt(token1.nextToken());
		
		int sum = 0;
		ArrayList<Integer> cowList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			cowList.add(a);
			sum += a;
		}
		Collections.sort(cowList);
		
		TreeMap<Integer, Integer> market = new TreeMap<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			if (market.containsKey(a)) {
				market.put(a, market.get(a) + b);
			}
			else {
				market.put(a, b);
			}
		}
		market.put(0, Integer.MAX_VALUE);
		
		ArrayList<Integer> rentals = new ArrayList<>(N);
		for (int i = 0; i < R; i++) {
			int a = Integer.parseInt(br.readLine());
			rentals.add(a);
		}
		Collections.sort(rentals);
		
		//System.out.println(cowList);
		//System.out.println(market);
		//System.out.println(rentals);
		
		ArrayList<Integer> marketPrice = new ArrayList<>();
		marketPrice.addAll(market.keySet());
		
		milk = new TreeMap<>();
		long profit = 0;
		for (int i = marketPrice.size() - 1; i >= 0; i--) {
			if (sum == 0) break;
			int price = marketPrice.get(i);
			int q = market.get(price);
			//System.out.println(profit);
			if (sum > q) {
				sum -= q;
				profit += price * q;
				milk.put(price, q);
			}
			else {
				profit += price * sum;
				
				milk.put(price, sum);
				break;
			}
			
		}
		
		//System.out.println(profit);
		milkSet = new ArrayList<>();
		milkSet.addAll(milk.keySet());
		
		
		int rentIndex = R - 1;
		for (int i = 0; i < N; i++) {
			long milkValue = retrieveMilk(cowList.get(i));
			long rentValue = rentals.get(rentIndex);
			//System.out.println(milkValue + " " + rentValue);
			if (milkValue >= rentValue) {
				break;
			}
			else {
				profit += rentValue;
				profit -= milkValue;
				rentIndex--;
				if (rentIndex < 0) break;
			}
		}
		System.out.println(profit);
		
		
		
		
		/*
		int N = in.nextInt();
		int M = in.nextInt();
		int R = in.nextInt();
		
		ArrayList<Integer> cowList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			int a = in.nextInt();
			cowList.add(a);
		}
		
		TreeMap<Integer, Integer> market = new TreeMap<>();
		for (int i = 0; i < M; i++) {
			
			int a = in.nextInt();
			int b = in.nextInt();
			if (market.containsKey(a)) {
				market.put(a, market.get(a) + b);
			}
			else {
				market.put(a, b);
			}
		}
		System.out.println(cowList);
		System.out.println(market);
		
		ArrayList<Integer> rentals = new ArrayList<>(N);
		for (int i = 0; i < R; i++) {
			int a = in.nextInt();
			System.out.println(a);
			rentals.add(a);
		}
		System.out.println(cowList);
		System.out.println(market);
		System.out.println(rentals);
		*/
		
		//in.close();
		br.close();
		out.close();
	}
	
	public static long retrieveMilk(int quant) {
		long ans = 0;
		for (int i = 0; i < milkSet.size(); i++) {
			if (quant == 0) break;
			int price = milkSet.get(i);
			int q = milk.get(price);
			//System.out.println(price + " " + q);
			if (q != 0) {
				if (quant < q) {
					ans += price * quant;
					milk.put(price, milk.get(price) - quant);
					break;
				}
				else {
					ans += price * q;
					quant -= q;
					milk.put(price, 0);
				}
			}
		}
		return ans;
	}

}
