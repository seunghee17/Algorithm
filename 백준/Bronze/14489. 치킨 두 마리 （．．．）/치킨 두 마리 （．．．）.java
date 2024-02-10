import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st1 = br.readLine();
		StringTokenizer st = new StringTokenizer(st1);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
	
		int c = Integer.parseInt(br.readLine());
		if(a+b >= 2*c) {
			System.out.println(a+b - (2*c));
		}else {
			System.out.println(a+b);
		}
		br.close();
	}
	
}
