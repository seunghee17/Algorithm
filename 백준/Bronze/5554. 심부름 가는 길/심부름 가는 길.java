import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[4];
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = Arrays.stream(arr).sum();
		int[] total = new int[2];
		total[0] = sum/60;
		total[1] = sum%60;
		for(int i =0; i<2; i++) {
			System.out.println(total[i]);
		}
		
		br.close();
		
	}
	
}