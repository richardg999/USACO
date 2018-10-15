/*
ID: richgtx1
LANG: JAVA
TASK: pprime
*/
import java.util.*;
import java.io.*;

public class pprime {
	
	public static String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public static Set<Integer> palindromes;
	public static List<String> segments;
	public static Set<Integer> primes;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("pprime.in"));
		PrintWriter out = new PrintWriter("pprime.out");
		//BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		primes = new TreeSet<Integer>();
		generatePrimes(10000);
		
		palindromes = new TreeSet<Integer>();
		segments = new ArrayList<String>();
		
		generatePalindromes(a, b);
		//System.out.println(palindromes);
		
		for (int pal : palindromes) {
			if (checkPrime(pal)) {
				System.out.println(pal);
			}
		}

		in.close();
		out.close();
		//br.close();
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
		for (int prime : primes) {
			if (num % prime == 0 && num != prime) {
				return false;
			}
		}
		return true;
	}
	
	public static void generatePalindromes(int min, int max) {
		String maxStr = Integer.toString(max);
		int maxLength = maxStr.length();
		String minStr = Integer.toString(min);
		int minLength = minStr.length();
		genPal(minLength, min, max);
		for (int i = minLength + 1; i <= maxLength - 1; i++) {
			genPal(i);
		}
		if (minLength != maxLength) {
			genPal(maxLength, min, max);
		}
		
	}
	
	public static void genPal(int num) {
		segments = new ArrayList<String>();
		int segLen = num / 2;
		firstRecurse("", segLen);
		if (num % 2 == 1) {
			for (String seg : segments) {
				String revSeg = new StringBuilder(seg).reverse().toString();
				for (int i = 0; i < 10; i++) {
					palindromes.add(Integer.parseInt(seg + digits[i] + revSeg));
				}
			}
		}
		else {
			for (String seg : segments) {
				String revSeg = new StringBuilder(seg).reverse().toString();
				palindromes.add(Integer.parseInt(seg + revSeg));
			}
		}
	}
	
	public static void genPal(int num, int min, int max) {
		segments = new ArrayList<String>();
		int segLen = num / 2;
		firstRecurse("", segLen);
		if (num % 2 == 1) {
			for (String seg : segments) {
				String revSeg = new StringBuilder(seg).reverse().toString();
				for (int i = 0; i < 10; i++) {
					int pal = Integer.parseInt(seg + digits[i] + revSeg);
					if (pal <= max && pal >= min)
						palindromes.add(pal);
				}
			}
		}
		else {
			for (String seg : segments) {
				String revSeg = new StringBuilder(seg).reverse().toString();
				int pal = Integer.parseInt(seg + revSeg);
				if (pal <= max && pal >= min)
					palindromes.add(pal);
			}
		}
	}
	
	public static void firstRecurse(String value, int count) {
		if (count == 0) {
			segments.add(value);
			return;
		}
		for (int i = 1; i < 10; i++) {
			recurse(value + digits[i], count - 1);
		}
	}
	
	public static void recurse(String value, int count) {
		if (count == 0) {
			segments.add(value);
			return;
		}
		for (int i = 0; i < 10; i++) {
			recurse(value + digits[i], count - 1);
		}
	}

}
