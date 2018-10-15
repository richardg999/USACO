/*
ID: richgtx1
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;

public class castle {

	public static int[] keys = {8, 4, 2, 1};
	public static int[] di = {1, 0, -1, 0};
	public static int[] dj = {0, 1, 0, -1};
	public static int[][] castle;
	public static boolean[][] checkedRooms;
	public static int M;
	public static int N;
	public static int roomSize;
	// to remove redundancy try finding the size of the largest room instead of using Collections.max(roomList)

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("castle.in"));
		PrintWriter out = new PrintWriter("castle.out");
		BufferedReader br = new BufferedReader(new FileReader("castle.in"));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		
		castle = new int[N][M];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		List<Integer> roomList = findRoomList();
		
		out.println(roomList.size());
		
		int maxRoom = Collections.max(roomList);
		out.println(maxRoom);
		
		List<Wall> wallList = new ArrayList<Wall>();
		// test wall to north of room
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (castle[i][j] % 4 >= 2) {
					castle[i][j] -= 2;
					castle[i - 1][j] -= 8;
					List<Integer> newList = findRoomList();
					int tempMaxRoom = Collections.max(newList);
					if (tempMaxRoom > maxRoom) {
						maxRoom = tempMaxRoom;
						wallList = new ArrayList<Wall>();
						wallList.add(new Wall(i, j, 'N'));
					}
					else if (tempMaxRoom == maxRoom) {
						wallList.add(new Wall(i, j, 'N'));
					}
					castle[i][j] += 2;
					castle[i - 1][j] += 8;
				}
			}
		}
		// test wall to east of room
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (castle[i][j] % 8 >= 4) {
					castle[i][j] -= 4;
					castle[i][j + 1] -= 1;
					List<Integer> newList = findRoomList();
					int tempMaxRoom = Collections.max(newList);
					if (tempMaxRoom > maxRoom) {
						maxRoom = tempMaxRoom;
						wallList = new ArrayList<Wall>();
						wallList.add(new Wall(i, j, 'E'));
					}
					else if (tempMaxRoom == maxRoom) {
						wallList.add(new Wall(i, j, 'E'));
					}
					castle[i][j] += 4;
					castle[i][j + 1] += 1;
				}
			}
		}
		
		System.out.println(maxRoom);
		
		Collections.sort(wallList);
		System.out.println(Collections.max(wallList));

		//in.close();
		out.close();
		br.close();
	}
	
	public static List<Integer> findRoomList() {
		checkedRooms = new boolean[N][M];
		List<Integer> roomList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (checkedRooms[i][j] == false) {
					roomSize = 0;
					floodfill(i, j);
					roomList.add(roomSize);
				}
			}
		}
		return roomList;
	}
	
	public static void floodfill(int a, int b) {
		if (a < 0 || b < 0 || a >= N || b >= M) return;
		else if (checkedRooms[a][b] == true) return;
		roomSize++;
		checkedRooms[a][b] = true;
		int square = castle[a][b];
		for (int i = 0; i < keys.length; i++) {
			if (square - keys[i] < 0) {
				floodfill(a + di[i], b + dj[i]);
			}
			else {
				square -= keys[i];
			}
		}
	}
	
	static class Wall implements Comparable<Wall>{
		int i;
		int j;
		char direction;
		
		public Wall(int i, int j, char direction) {
			this.i = i;
			this.j = j;
			this.direction = direction;
		}
		
		@Override
		// toString transforms coordinate from 0...N - 1 to 1...N.
		public String toString() {
			i += 1;
			j += 1;
			return i + " " + j + " " + direction;
		}
		
		// preferred is "maximum" in wallList
		public int compareTo(Wall w) {
			if (this.j != w.j)
				return w.j - this.j;
			else if (this.i != w.i)
				return this.i - w.i;
			else if (this.direction == 'N')
				return 1;
			else
				return -1;
		}
	}

}
