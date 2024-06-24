
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	static int[] cal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			if(st.hasMoreTokens()) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}
		cal = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int idx, int sum) {
		if(idx == n-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		idx++;
		for(int i=0; i<4; i++) {
			if(cal[i] >0 ) {
				cal[i]--;
				switch(i) {
				case 0: 
					dfs(idx, sum + arr[idx]);
					break;
				case 1: 					
					dfs(idx, sum - arr[idx]);
					break;
				case 2: 					
					dfs(idx, sum * arr[idx]);					
					break;
				case 3: 					
					dfs(idx, sum / arr[idx]);
					break;
				}
				cal[i]++;	
			}
		}
	}
}