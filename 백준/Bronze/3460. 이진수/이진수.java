import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 1
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int index = 0;
			while(n>0) {
				if(n % 2 ==1) {
					System.out.print(index + " ");
				}
				n /=2;
				index++;
			}
			System.out.println();
		}
		br.close();
		
	}
	
}
