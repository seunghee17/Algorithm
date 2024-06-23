import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		long min = 0;
		long max = 0;
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<K; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		max++;
		while(min < max) {
			int sum = 0;
			long mid = (max + min) / 2;
			for(int height: arr) {
				sum += height/mid;
			}
			if(sum < N) {
				max = mid;
			} else {
				min = mid + 1;
			
			}
		}
		System.out.println(min-1);
		
	}
	
}	