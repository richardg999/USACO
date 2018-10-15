/*
ID: richgtx1
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;

public class sprime {

	public static Set<Integer> primes;
	public static String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public static String[] recurseNums = {"1", "3", "7", "9"};
	public static String[] firstRecurseNums = {"2", "3", "5", "7"};
	public static List<Integer> ansList;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("sprime.in"));
		PrintWriter out = new PrintWriter("sprime.out");
		//BufferedReader br = new BufferedReader(new FileReader("sprime.in"));

		primes = new TreeSet<Integer>();
		generatePrimes(10000);
		
		ansList = new ArrayList<Integer>();
		
		int N = in.nextInt();
		
		firstRecurse("", N);
		
		for (int ans : ansList) {
			out.println(ans);
		}
		
		
		in.close();
		out.close();
		//br.close();
	}
	
	public static void firstRecurse(String value, int count) {
		if (count == 0) {
			ansList.add(Integer.parseInt(value));
			return;
		}
		for (int i = 0; i < firstRecurseNums.length; i++) {
			recurse(value + firstRecurseNums[i], count - 1);
		}
	}
	
	public static void recurse(String value, int count) {
		if (!checkPrime(Integer.parseInt(value))) return;
		else if (count == 0) {
			ansList.add(Integer.parseInt(value));
			return;
		}
		
		for (int i = 0; i < recurseNums.length; i++) {
			recurse(value + recurseNums[i], count - 1);
		}
	}

	
	public static void generatePrimes(int max) {
		boolean[] arr = new boolean[max + 1];
		Arrays.fill(arr, true);
		for (int i = 2; i <= max; i++) {
			if (arr[i] == true) {
				primes.add(i);
				for (int j = i; j <= max; j += i) {
					arr[j] = false;
				}
			}
		}
	}
	
	public static boolean checkPrime(int num) {
		if (num < 10000) {
			return primes.contains(num);
		}
		for (int prime : primes) {
			if (num % prime == 0 && num != prime) {
				return false;
			}
		}
		return true;
	}

}
