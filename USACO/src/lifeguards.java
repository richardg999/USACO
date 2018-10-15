/*
ID: richgtx1
LANG: JAVA
TASK: lifeguards
*/
import java.util.*;
import java.io.*;

public class lifeguards {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("lifeguards.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("lifeguards.out");
		
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(100000001);
		for (int i = 0; i < 100000001; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			for (int j = a; j < b; j++) {
				list.get(j).add(i);
			}
			map.put(i, 0);
		}
		
		int uncoveredTime = 0;
		for (int i = 0; i < 100000001; i++) {
			if (list.get(i).size() == 0) {
				uncoveredTime++;
			}
			else if (list.get(i).size() == 1) {
				int tempName = list.get(i).get(0);
				map.put(tempName, map.get(tempName) + 1);
			}
		}
		int timeLost = Collections.min(map.values());
		int coveredTime = 100000001 - uncoveredTime;
		System.out.println(coveredTime - timeLost);

		in.close();
		out.close();
	}
	
	//not sure what this does
	public static int findMode(ArrayList<Integer> list) {
		Collections.sort(list);
		int ans = list.get(0);
		int maxCount = 0;
		int track = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			if (track == temp) {
				count++;
				if (maxCount < count) {
					maxCount = count;
					ans = temp;
				}
			}
			else {
				track = temp;
				
				count = 1;
			}
		}
		return maxCount;
	}

}
