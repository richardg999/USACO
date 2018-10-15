/*
ID: richgtx1
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;

public class namenum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("namenum.in"));
		//Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter("namenum.out");
		Scanner scan = new Scanner(new File("dict.txt"));
		
		ArrayList<String> dict = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		while (scan.hasNext()) {
			String word = scan.next();
			dict.add(word);
			String num = translate(word);
			list.add(num);
		}
		//System.out.println(list);
		
		String a = in.next();
		
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(a.equals(list.get(i))) {
				ans.add(dict.get(i));
			}
		}
		
		for (int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
		
		if (ans.size() == 0) {
			out.println("NONE");
		}

		scan.close();
		in.close();
		out.close();
	}
	
	public static String translate(String word) {
		String num = "";
		for(int i = 0; i < word.length(); i++) {
			char let = word.charAt(i);
			if(let == 'A' || let == 'B' || let == 'C') {
				num += "2";
			}
			else if(let == 'D' || let == 'E' || let == 'F') {
				num += "3";
			}
			else if(let == 'G' || let == 'H' || let == 'I') {
				num += "4";
			}
			else if(let == 'J' || let == 'K' || let == 'L') {
				num += "5";
			}
			else if(let == 'M' || let == 'N' || let == 'O') {
				num += "6";
			}
			else if(let == 'P' || let == 'R' || let == 'S') {
				num += "7";
			}
			else if(let == 'T' || let == 'U' || let == 'V') {
				num += "8";
			}
			else if(let == 'W' || let == 'X' || let == 'Y') {
				num += "9";
			}
			else {
				num += "1";
			}
		}
		return num;
	}

}
