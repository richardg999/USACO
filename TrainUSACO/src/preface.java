/*
ID: richgtx1
LANG: JAVA
TASK: preface
*/
import java.util.*;
import java.io.*;

public class preface {
	// terminology: "ones" are the analogous to I and "fives" are analogous to V
	// independent digit by digit analysis
	
	public static int[] ansArr;
	public static char[] romanNums = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	public static int[] digitOnes = {0, 1, 2, 3, 1, 0, 1, 2, 3, 1};
	public static int[] digitFives = {0, 0, 0, 0, 1, 1, 1, 1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("preface.in"));
		PrintWriter out = new PrintWriter("preface.out");
		//BufferedReader br = new BufferedReader(new FileReader("preface.in"));
		
		int N = in.nextInt();
		// extra cover at end of array to prevent error
		ansArr = new int[8];
		
		for (int i = 1; i <= N; i++) {
			//System.out.println(i);
			generateRomanNum(i);
			//System.out.println(Arrays.toString(ansArr));
		}
		
		int index = 6;
		for (int i = 6; i >= 0; i--) {
			if (ansArr[i] != 0) {
				index = i;
				break;
			}
		}
		for (int i = 0; i <= index; i++) {
			out.println(romanNums[i] + " " + ansArr[i]);
		}

		in.close();
		out.close();
		//br.close();
	}
	
	public static void generateRomanNum(int num) {
		String numStr = Integer.toString(num);
		for (int i = numStr.length() - 1; i >= 0; i--) {
			int digit = numStr.charAt(i) - 48;
			int index = numStr.length() - 1 - i;
			//System.out.println(digit + " " + index);
			int one = 2 * index;
			int five = 2 * index + 1;
			ansArr[one] += digitOnes[digit];
			ansArr[five] += digitFives[digit];
			if (digit == 9) {
				ansArr[one + 2] += 1;
			}
		}
	}

}
