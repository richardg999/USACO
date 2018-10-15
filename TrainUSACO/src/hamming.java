/*
ID: richgtx1
LANG: JAVA
TASK: hamming
*/
import java.util.*;
import java.io.*;

public class hamming {

	public static int[] reference;
	public static Set<Integer> nums;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("hamming.in"));
		PrintWriter out = new PrintWriter("hamming.out");
		//BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
		
		int N = in.nextInt();
		int B = in.nextInt();
		int D = in.nextInt();
		
		reference = new int[B];
		for (int i = 0; i < B; i++) {
			reference[i] = (int) Math.pow(2, i);
		}
		
		generateNumbers(D - 1);
		
		List<Integer> ansList = new ArrayList<Integer>();
		
		int maxNum = (int) Math.pow(2, B);
		int count = 0;
		for (int i = 0; i < maxNum; i++) {
			if (count == N) break;
			boolean flag = true;
			for (int ans : ansList) {
				int temp = ans ^ i;
				if (nums.contains(temp)) flag = false;
			}
			if (flag == true) {
				count++;
				ansList.add(i);
			}
		}
		
		for (int i = 0; i < ansList.size(); i++) {
			// if it is multiple of 10 or last index
			if ((i + 1) % 10 == 0 || i == ansList.size() - 1) {
				out.println(ansList.get(i));
			}
			else {
				out.print(ansList.get(i) + " ");
			}
			
		}

		in.close();
		out.close();
		//br.close();
	}
	
	public static void generateNumbers(int max) {
		nums = new HashSet<Integer>();
		for (int i = 1; i <= max; i++) {
			genNums(0, -1, i);
		}
		
	}
	
	public static void genNums(int sum, int index, int count) {
		if (count == 0) {
			nums.add(sum);
			return;
		}
		for (int i = index + 1; i < reference.length; i++) {
			genNums(sum + reference[i], i, count - 1);
		}
	}

}
