/*
ID: richgtx1
LANG: JAVA
TASK: holstein
*/
import java.util.*;
import java.io.*;

public class holstein {

	public static int G;
	public static int[] vitamins;
	// best example of BFS
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("holstein.in"));
		PrintWriter out = new PrintWriter("holstein.out");
		BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
		
		int V = Integer.parseInt(br.readLine());
		vitamins = new int[V];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			vitamins[i] = Integer.parseInt(token.nextToken());
		}
		G = Integer.parseInt(br.readLine());
		int[][] feed = new int[G][V];
		for (int i = 0; i < G; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				feed[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		Queue<Node> q = new LinkedList<Node>();
		int[] arr = new int[V];
		boolean[] arr2 = new boolean[G];
		Node node = new Node(arr, arr2, -1);
		q.add(node);
		
		
		while (!node.isDone()) {
			node = q.poll();
			boolean[] previous = node.previous;
			for (int i = node.index + 1; i < previous.length; i++) {
				if (!previous[i]) {
					previous[i] = true;
					q.add(new Node(sumArrays(feed[i], node.values), previous, i));
					previous[i] = false;
				}
			}
			
		}
		out.println(node);
		

		//in.close();
		out.close();
		br.close();
	}
	
	static class Node {
		int[] values;
		boolean[] previous;
		int index;
		public Node(int[] arr, boolean[] arr2, int index) {
			values = Arrays.copyOf(arr, arr.length);
			previous = Arrays.copyOf(arr2, arr2.length);
			this.index = index;
		}
		public boolean isDone() {
			for (int i = 0; i < values.length; i++) {
				if (values[i] < vitamins[i]) return false;
			}
			return true;
		}
		@Override
		public String toString() {
			//return Arrays.toString(values);
			int count = 0;
			String ans = "";
			for (int i = 0; i < previous.length; i++) {
				boolean flag = previous[i];
				if (flag == true) {
					count++;
					ans += " " + (i + 1);
				}
			}
			return count + ans;
		}
	}
	
	public static int[] sumArrays(int[] arr, int[] arr2) {
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[i] = arr[i] + arr2[i];
		}
		return ans;
	}

}
