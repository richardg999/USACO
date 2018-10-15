/*
ID: richgtx1
LANG: JAVA
TASK: outofplace
*/
import java.util.*;
import java.io.*;

public class outofplace {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("outofplace.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("outofplace.out");
		
		int N = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			list.add(in.nextInt());
		}
		ArrayList<Integer> correctList = new ArrayList<>(N);
		correctList.addAll(list);
		Collections.sort(correctList);
		
		int bessie = list.get(0);
		int bessieIndex = 0;
		for (int i = 0; i < N; i++) {
			int a = list.get(i);
			int b = correctList.get(i);
			if (a != b) {
				if (list.get(i + 1) >= a) {
					bessie = b;
					bessieIndex = list.lastIndexOf(b);
					break;
				}	
				else {
					bessie = a;
					bessieIndex = i;
					break;
				}
			}
		}
		
		
		int count = 0;
		while (!list.equals(correctList)) {
			int cow = correctList.get(bessieIndex);
			list.set(bessieIndex, cow);
			bessieIndex = list.indexOf(cow);
			if (list.get(bessieIndex).equals(correctList.get(bessieIndex)))
				bessieIndex = list.lastIndexOf(cow);
			list.set(bessieIndex, bessie);
			count++;
		}
		/*while (!list.equals(correctList)) {
			int cowIndex = correctList.indexOf(bessie);
			if (list.get(cowIndex))
		}*/
		System.out.println(count);

		in.close();
		out.close();
	}

}
