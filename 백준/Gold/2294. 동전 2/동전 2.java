import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] coin = new int[n];
    	for(int i=0; i<n; i++) {
    		coin[i] = Integer.parseInt(br.readLine());
    	}
    	int[] dp = new int[k+1];
    	for(int i=1; i<=k; i++) {
    		dp[i] = Integer.MAX_VALUE-1;
    	}
    	for(int i=0; i<n; i++) {
    		for(int j=coin[i]; j<=k; j++) {
    			dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
    		}
    	}
    	if(dp[k] == Integer.MAX_VALUE-1) {
    		System.out.println(-1);
    		
    	} else {
    		System.out.println(dp[k]);
    	}
    }
}