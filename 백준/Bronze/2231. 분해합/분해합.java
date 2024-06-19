import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result =0;
		for(int i=0; i<n; i++) {
			int num = i;
			int sum = i; 
			while(num != 0) {
				sum += num % 10;
				num /=10;
			}
			if(sum == n) {
				result = i;
				break;
			}
		}
		System.out.println(result);
 	}
	
}