/*
ID: richgtx1
LANG: JAVA
TASK: milk2
*/
import java.util.*;
import java.io.*;

public class milk2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("milk2.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("milk2.out");
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = in.nextInt();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		
		for(int i = 0; i < N; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			Integer temp = map.put(a, b);
			if(temp != null && temp > map.get(a)) {
				map.put(a, temp);
			}
			arr[i] = a;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			arr2[i] = map.get(arr[i]);
		}
		
		//System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(arr2));
		
		int interval1 = 0;
		int interval2 = 0;
		int index = arr[0];
		int index2 = arr2[0];
		for(int i = 0; i < N; i++) {
			if(index2 < arr2[i]) {
				if(index2 >= arr[i]) {
					index2 = arr2[i];
				}
				else {
					if(index2 - index > interval1) {
						interval1 = index2 - index;
					}
					if(arr[i] - index2 > interval2) {
						interval2 = arr[i] - index2;
					}
					
					index = arr[i];
					index2 = arr2[i];
				}
				//System.out.println(index + " " + index2);
			}
			
		}
		if(index2 - index > interval1) {
			interval1 = index2 - index;
		}
		
		out.println(interval1 + " " + interval2);

		in.close();
		out.close();
	}

}
