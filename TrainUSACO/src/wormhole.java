/*
ID: richgtx1
LANG: JAVA
TASK: wormhole
*/
import java.util.*;
import java.io.*;

public class wormhole {

	public static int[] xVal;
	public static int[] yVal;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("wormhole.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("wormhole.out");
		
		int N = in.nextInt();
		//int N = 12;
		
		ArrayList<Integer> ans1 = new ArrayList<>();
		ArrayList<Integer> ans2 = new ArrayList<>();
		ArrayList<Integer> set = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			set.add(i + 1);
		}
		
		ArrayList<ArrayList<Integer>> points = findPairs(ans1, ans2, set);
		ans1.addAll(points.get(0));
		ans2.addAll(points.get(1));
		//System.out.println(ans1);
		//System.out.println(ans2);
		
		//Map<Integer, Integer> xVal = new HashMap<>();
		//Map<Integer, Integer> yVal = new HashMap<>();
		/*for (int i = 0; i < N; i++) {
			int val1 = in.nextInt();
			int val2 = in.nextInt();
			xVal.put(i, val1);
			yVal.put(i, val2);
		}
		//System.out.println(yVal);*/
		
		xVal = new int[N];
		yVal = new int[N];
		for (int i = 0; i < N; i++) {
			xVal[i] = in.nextInt();
			yVal[i] = in.nextInt();
		}
		//System.out.println(Arrays.toString(xVal));
		
		ArrayList<Point> wormholes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			wormholes.add(new Point(xVal[i], yVal[i], i + 1));
		}
		//System.out.println(wormholes);
		
		
		ArrayList<Point> list = new ArrayList<>(wormholes);
		ArrayList<Point> endPoints = new ArrayList<>();
		ArrayList<Point> startPoints = new ArrayList<>();
		while (!list.isEmpty()) {
			Point initial = list.get(0);
			int num = initial.getY();
			ArrayList<Point> tempList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Point p = list.get(i);
				if (p.getY() == num) {
					i--;
					list.remove(p);
					tempList.add(p);
				}
			}
			Collections.sort(tempList);
			//System.out.println(tempList);
			
			for (int j = 0; j < tempList.size() - 1; j++) {
				endPoints.add(tempList.get(j));
				startPoints.add(tempList.get(j + 1));
			}
			
		}
		//System.out.println(endPoints);
		//System.out.println(startPoints);
		
		int count = 0;
		Map<Integer, Integer> link = new HashMap<>();
		int num = N / 2;
		for (int i = 0; i < ans1.size(); i += num) {
			
			//generating the specific "link" map
			for (int j = 0; j < num; j++) {
				link.put(ans1.get(i + j), ans2.get(i + j));
				link.put(ans2.get(i + j), ans1.get(i + j));
			}
			//System.out.println(link);
			
			boolean breakAll = false;
			for (int j = 0; j < startPoints.size(); j++) {
				
				if (breakAll == true) {
					break;
				}
				
				int startIndex = startPoints.get(j).getIndex();
				int endIndex = endPoints.get(j).getIndex();
				
				//link is teleporting, walkWormhole is walking
				int next = startIndex;
				
				while (next != 0) {
					//teleport through wormhole
					next = link.get(next);
					if (next == endIndex) {
						count++;
						breakAll = true;
						break;
					}
					//walk
					next = walkWormhole(next);
					
				}	
				
			}
		}
		
		System.out.println(count);
		
		in.close();
		out.close();
	}
	
	
	public static ArrayList<ArrayList<Integer>> findPairs(ArrayList<Integer> ans1, 
			ArrayList<Integer> ans2, ArrayList<Integer> set) {
		if (set.isEmpty()) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			ans.add(new ArrayList<Integer>());
			ans.add(new ArrayList<Integer>());
			
			ans.get(0).addAll(ans1);
			ans.get(1).addAll(ans2);
			
			return ans;
		}
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ans.add(new ArrayList<Integer>());
		ans.add(new ArrayList<Integer>());
		
		for (int i = 0; i < 1; i++) {
			for (int j = i + 1; j < set.size(); j++) {
				int num1 = set.get(i);
				int num2 = set.get(j);
				
				ArrayList<Integer> newAns1 = new ArrayList<>();
				ArrayList<Integer> newAns2 = new ArrayList<>();
				newAns1.addAll(ans1);
				newAns2.addAll(ans2);
				newAns1.add(num1);
				newAns2.add(num2);
				
				ArrayList<Integer> result = new ArrayList<>();
				result.addAll(set);
				result.remove(new Integer(num1));
				result.remove(new Integer(num2));
				//System.out.println(result);
				
				ArrayList<ArrayList<Integer>> temp = findPairs(newAns1, newAns2, result);
				//System.out.println(temp);
				ans.get(0).addAll(temp.get(0));
				ans.get(1).addAll(temp.get(1));
				//System.out.println(ans);
			}
		}
		return ans;
	}
	
	
	public static int walkWormhole(int num) {
		int index = num - 1;
		int y = yVal[index];
		int x = xVal[index];
		int ans = -1;
		int comparedVal = Integer.MAX_VALUE;
		for (int i = 0; i < yVal.length; i++) {
			if (i == index) {
				continue;
			}
			else if (y == yVal[i] && x < xVal[i] && xVal[i] < comparedVal) {
				ans = i;
				comparedVal = xVal[i];
			}
		}
		return ans + 1;
	}
	

	/*public static void print2d(Integer[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	*/
	
	static class Point implements Comparable<Point> {
		
		private int x;
		private int y;
		private int index;
		
		//index is from 1 to N, does not start at 0!
		public Point(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getIndex() {
			return index;
		}
		
		@Override
		public String toString() {
			return x + "," + y;
		}
		
		public int compareTo(Point p) {
			return this.x - p.x;
		}
		
	}
	
}




