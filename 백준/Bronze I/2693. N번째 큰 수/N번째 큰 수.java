import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[10];
		int[] and = new int[N];
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				result[j] = Integer.parseInt(arr[j]);
			}
			Arrays.sort(result);
			and[i] = result[7];
		}
		for(int i =0; i<N; i++) {
			System.out.println(and[i]);
		}
		br.close();
	}
	
}