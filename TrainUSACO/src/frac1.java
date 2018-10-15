/*
ID: richgtx1
LANG: JAVA
TASK: frac1
*/
import java.util.*;
import java.io.*;

public class frac1 {

	public static Set<Fraction> set;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("frac1.in"));
		PrintWriter out = new PrintWriter("frac1.out");
		//BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
		
		int N = in.nextInt();
		set = new TreeSet<Fraction>();
		generateFractions(N);
		
		for (Fraction frac : set) {
			out.println(frac);
		}

		in.close();
		out.close();
		//br.close();
	}
	
	public static void generateFractions(int N) {
		set.add(new Fraction(0, 1));
		set.add(new Fraction(1, 1));
		for (int denom = 2; denom <= N; denom++) {
			for (int num = 1; num < denom; num++) {
				set.add(new Fraction(num, denom));
			}
		}
	}
	
	static class Fraction implements Comparable<Fraction>{
		int a;
		int b;
		public Fraction(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return a + "/" + b;
		}
		public int compareTo(Fraction f) {
			double num1 = (double) this.a / this.b;
			double num2 = (double) f.a / f.b;
			if (num1 > num2)
				return 1;
			else if (num2 > num1)
				return -1;
			else
				return 0;
		}
	}

}
