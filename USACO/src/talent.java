/*
ID: richgtx1
LANG: JAVA
TASK: talent
*/
import java.util.*;



import java.io.*;

public class talent {

	public static Point[] arr;
	public static double globalMax = 0;
	public static int W;
	public static HashMap<String, Integer> mapWeight;
	public static HashMap<String, Integer> mapTalent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("talent.in"));
		PrintWriter out = new PrintWriter("talent.out");
		BufferedReader br = new BufferedReader(new FileReader("talent.in"));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		W = Integer.parseInt(token.nextToken());
		arr = new Point[N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		mapWeight = new HashMap<>();
		mapTalent = new HashMap<>();
		/*
		int totalWeight = 0;
		int totalTalent = 0;
		int index = arr.length - 1;
		while (totalWeight < W) {
			totalWeight += arr[index].x;
			totalTalent += arr[index].y;
			index--;
		}
		*/
		for (int i = 0; i < N; i++) {
			recurse(new HashSet<Integer>(), i, 0, 0);
		}
		int ans = (int) (globalMax * 1000);
		out.println(ans);

		//in.close();
		out.close();
		br.close();
	}
	
	public static void recurse(HashSet<Integer> origSet, int index, int totalWeight, int totalTalent) {
		HashSet<Integer> set = new HashSet<>(origSet);
		
		if (mapWeight.containsKey(set.toString())) {
			totalWeight = arr[index].x + mapWeight.get(set.toString());
			totalTalent = arr[index].y + mapTalent.get(set.toString());
			set.add(index);
			mapWeight.put(set.toString(), totalWeight);
			mapTalent.put(set.toString(), totalTalent);
			System.out.println("hoy");
		}
		else {
			totalWeight += arr[index].x;
			totalTalent += arr[index].y;
			set.add(index);
			mapWeight.put(set.toString(), totalWeight);
			mapTalent.put(set.toString(), totalTalent);
		}
		
		
		
		if (totalWeight >= W) {
			double newRatio = (double) totalTalent / totalWeight;
			if (globalMax < newRatio) {
				globalMax = newRatio;
			}
			return;
		}
		for (int i = index - 1; i >= 0; i--) {
			recurse(set, i, totalWeight, totalTalent);
		}
	}
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + "," + y;
		}
		public int compareTo(Point p) {
			double ratio1 = (double) this.y / this.x;
			double ratio2 = (double) p.y / p.x;
			if (ratio1 > ratio2)
				return 1;
			else if (ratio2 > ratio1)
				return -1;
			else 
				return 0;
		}
		public boolean equals(Point p) {
			return this.x == p.x && this.y == p.y;
		}
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

}
