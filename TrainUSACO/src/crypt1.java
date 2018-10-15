/*
ID: richgtx1
LANG: JAVA
TASK: crypt1
*/
import java.util.*;
import java.io.*;

public class crypt1 {

	public static String[] set;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("crypt1.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("crypt1.out");
		
		int N = in.nextInt();
		set = new String[N];
		
		for (int i = 0; i < N; i++) {
			set[i] = in.next();
		}
		
		int[] threeNum = new int[N * N * N];
		int index1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					String temp = set[i] + set[j] + set[k];
					threeNum[index1] = Integer.parseInt(temp);
					index1++;
				}
			}
		}
		
		int[] twoNum = new int[N * N];
		index1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String temp = set[i] + set[j];
				twoNum[index1] = Integer.parseInt(temp);
				index1++;
			}
		}
		
		int ans = 0;
		
		for (int i = 0; i < threeNum.length; i++) {
			for (int j = 0; j < twoNum.length; j++) {
				int product = threeNum[i] * twoNum[j];
				String prodStr = Integer.toString(product);
				//System.out.println(product + " ");
				if (/*prodStr.length() == 4 &&*/ test(prodStr)) {
					//System.out.println(product);
					String twoNumStr = Integer.toString(twoNum[j]);
					int first = Integer.parseInt(twoNumStr.substring(0,1));
					int second = Integer.parseInt(twoNumStr.substring(1,2));
					String prod1 = Integer.toString(threeNum[i] * first);
					String prod2 = Integer.toString(threeNum[i] * second);
					if (prod1.length() == 3 && prod2.length() == 3 && test(prod1) == true && 
							test(prod2) == true) {
						ans++;
					}
				}
				
			}
		}
		
		//System.out.println(Arrays.toString(threeNum));
		//System.out.println(Arrays.toString(twoNum));
		
		System.out.println(ans);
		

		in.close();
		out.close();
	}
	
	public static boolean test(String strNum) {
		//String strNum = Integer.toString(num);
		for (int i = 0; i < strNum.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < set.length; j++) {
				if (set[j].equals(strNum.substring(i, i + 1))) {
					flag = true;
				}
			}
			if (flag == false) {
				return false;
			}
		}
		return true;
	}

}
