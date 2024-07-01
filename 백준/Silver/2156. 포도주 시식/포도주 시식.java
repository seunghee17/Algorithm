
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] podo = new int[n+1];
    	int[] dp = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		podo[i] = Integer.parseInt(br.readLine());
    	}
    	dp[1] = podo[1];
    	if(n>1) {
    		dp[2] = podo[1] + podo[2];
    	}
    	
    	for(int i=3; i<=n; i++) {
    		dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + podo[i], dp[i-3] + podo[i-1] + podo[i]));
    	}
    	int max=0;
    	for(int i=0; i<=n; i++) {
    		if(max < dp[i]) {
    			max = dp[i];
    		}
    	}
    	System.out.println(max);
    }
    
   
}
