/*
ID: richgtx1
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;

public class transform {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("transform.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("transform.out");
		
		int N = in.nextInt();
		in.nextLine();
		char[][] array;
		char[][] ans;
		
		array = new char[N][N];
		for(int i = 0; i < N; i++) {
			String arrString = "";
			arrString += in.nextLine();
			for(int j = 0; j < N; j++) {
				array[i][j] = arrString.charAt(j);
			}
		}
		
		ans = new char[N][N];
		for(int i = 0; i < N; i++) {
			String arrString = "";
			arrString += in.nextLine();
			for(int j = 0; j < N; j++) {
				ans[i][j] = arrString.charAt(j);
			}
		}
		
		//print2d(array);
		//print2d(ans);
		
		//calculations
		char[][] array1 = rotate(array);
		char[][] array2 = rotate(array1);
		char[][] array3 = rotate(array2);
		char[][] array4 = reflect(array);
		char[][] array5 = reflect(array1);
		char[][] array6 = reflect(array2);
		char[][] array7 = reflect(array3);
		
		/*
		
		if (Arrays.deepEquals(array1, ans)) {
			System.out.println("1");
		}
		else if (Arrays.deepEquals(array2, ans)) {
			System.out.println("2");
		}
		else if (Arrays.deepEquals(array3, ans)) {
			System.out.println("3");
		}
		else if (Arrays.deepEquals(array4, ans)) {
			System.out.println("4");
		}
		else if (Arrays.deepEquals(array5, ans) || Arrays.deepEquals(array6, ans) || Arrays.deepEquals(array7, ans)) {
			System.out.println("5");
		}
		else if (Arrays.deepEquals(array, ans)) {
			System.out.println("6");
		}
		else {
			System.out.println("7");
		}
		*/
		
		
		if (Arrays.deepEquals(array1, ans)) {
			out.println("1");
		}
		else if (Arrays.deepEquals(array2, ans)) {
			out.println("2");
		}
		else if (Arrays.deepEquals(array3, ans)) {
			out.println("3");
		}
		else if (Arrays.deepEquals(array4, ans)) {
			out.println("4");
		}
		else if (Arrays.deepEquals(array5, ans) || Arrays.deepEquals(array6, ans) || Arrays.deepEquals(array7, ans)) {
			out.println("5");
		}
		else if (Arrays.deepEquals(array, ans)) {
			out.println("6");
		}
		else {
			out.println("7");
		}
		
		in.close();
		out.close();
	}
	
	public static char[][] rotate(char[][] array) {
		int N = array.length;
		char[][] ans = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int nj = N - 1 - i;
				int ni = j;
				ans[ni][nj] = array[i][j];
			}
		}
		return ans;
	}
	
	public static char[][] reflect(char[][] array) {
		int N = array.length;
		char[][] ans = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int nj = N - 1 - j;
				ans[i][nj] = array[i][j];
			}
		}
		return ans;
	}
	
	public static void print2d(char[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}


