import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n+1];
    	int[][] dp = new int[n+1][n+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i=1; i<=n; i++) {
    		arr[i] =  Integer.parseInt(st.nextToken());
    		for(int j=1; j<=i; j++) {
    			if(i==j) {
    				dp[j][i] = 1;
    			}
    			else if(i-j == 1) {
    				if(arr[i] == arr[j]) dp[j][i] = 1;
    			}
    			else {
    				if(arr[j] == arr[i] && dp[j+1][i-1]==1) {
    					dp[j][i] = 1;
    				}
    			}
    		}
    	}
    	int m = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	while(m-->0) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		sb.append(dp[s][e]).append("\n");
    	}
    	System.out.println(sb.toString());
    }
   
    
}