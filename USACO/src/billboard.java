/*
ID: richgtx1
LANG: JAVA
TASK: billboard
*/
import java.util.*;
import java.io.*;

public class billboard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("billboard.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("billboard.out");
		
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int a1 = in.nextInt();
		int b1 = in.nextInt();
		int a2 = in.nextInt();
		int b2 = in.nextInt();
		
		int ans = (x2 - x1) * (y2 - y1);
		if (b2 >= y2 && b1 <= y1) {
			int distance = 0;
			if (a1 <= x1 && a2 >= x2)
				ans = 0;
			else if (a1 <= x1)
				distance = a2 - x1;
			else if (a2 >= x2)
				distance = x2 - a1;
			ans -= distance * (y2 - y1);
		}
		else if (a2 >= x2 && a1 <= x1) {
			int distance = 0;
			if (b2 >= y2 && b1 <= y1)
				ans = 0;
			else if (b2 >= y2)
				distance = y2 - b1;
			else if (b1 <= y1)
				distance = b2 - y1;
			ans -= distance * (x2 - x1);
		}
		out.println(ans);

		in.close();
		out.close();
	}

}
