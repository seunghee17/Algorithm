import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	int[] dp = new int[k+1];
    	dp[0] = 1;
    	for(int i=0; i<n; i++) {
    		for(int j=1; j<=k; j++) {
    			if(j >= arr[i]) {
    				dp[j] += dp[j-arr[i]];
    			}
    		}
    	}
    	System.out.println(dp[k]);
    }
}