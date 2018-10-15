/*
ID: richgtx1
LANG: JAVA
TASK: sort
*/
import java.util.*;
import java.io.*;

public class sort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("sort.in"));
		PrintWriter out = new PrintWriter("sort.out");
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			if (map.containsKey(num)) {
				map.get(num).add(i);
			}
			else {
				HashSet<Integer> set = new HashSet<>();
				set.add(i);
				map.put(num, set);
			}
		}
		System.out.println(map);
		int ans1 = bubbleSort(arr);
		System.out.println(ans1);
		
		int ans2 = altMethod(arr, map);
		System.out.println(ans2);

		//in.close();
		out.close();
		br.close();
	}
	
	public static int bubbleSort(int[] orig) {
		int[] arr = Arrays.copyOf(orig, orig.length);
		int ans = 0;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			ans++;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					sorted = false;
				}
			}
		}
		return ans;
	}
	
	public static int altMethod(int[] arr, Map<Integer, Set<Integer>> map) {
		int N = arr.length;
		
		int[] indexArray = new int[N];
		int idx = 0;
		for (int key : map.keySet()) {
			for (int num : map.get(key)) {
				indexArray[idx] = num;
				idx++;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(indexArray));
		int ans = 0;
		if (N % 2 == 0) {
			int mark1 = N / 2 - 1;
			int mark2 = N / 2;
			for (int i = 0; i <= N - mark2; i++) {
				
				if (indexArray[mark1] > indexArray[mark2]) {
					//check to see if indexArray[mark1] is min and indexArray[mark2] is max
					if (mark1 == 0) break;
					int leeway = N / 2 - i;
					for (int j = 0; j < mark1 - 1; j++) {
						if (indexArray[j] >= indexArray[mark1]) leeway--;
					}
					if (leeway <= 0) {
						ans++;
						continue;
					}
					leeway = N / 2 - i;
					for (int j = mark2 + 1; j < N; j++) {
						if (indexArray[j] <= indexArray[mark2]) leeway--;
					}
					if (leeway <= 0) {
						ans++;
						continue;
					}
					ans++;
				}
				mark1--;
				mark2++;
				
			}
		}
		return ans;
	}

}
