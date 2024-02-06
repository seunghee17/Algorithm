import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int date = Integer.parseInt(br.readLine());
		int[] cars = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<5; i++) {
			cars[i] = Integer.parseInt(st.nextToken());
		}
		int n = 0;
		for(int i=0; i<5; i++) {
			if(cars[i]==date) {
				n++;
			}
		}
		br.close();
		System.out.println(n);
		
	}
	
}