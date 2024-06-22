import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = 0;
		int max = 0;
		StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(sb.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
	
	
	
		while(min < max) {
			int mid = (min + max) / 2;
			long sum=0;
			for(int height : arr) {
				if(height-mid > 0) {
					sum += (height - mid);
				}
			}
			if(sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min-1);
	}
	
}	
	