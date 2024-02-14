import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		System.out.print(list.get(0) + " " + list.get(N-1));
		br.close();
	}
	
}