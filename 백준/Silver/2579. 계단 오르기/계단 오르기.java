
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] stair = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		String r = br.readLine();
    		stair[i] = Integer.parseInt(r);
    	}
    	int[] dp = new int[n+1];
    	dp[1] = stair[1];
    	if(n>=2) {
    		dp[2] = stair[1] + stair[2]; //arrayindex 오류 주의!!
    	}
    	
    	
    	for(int i=3; i<=n; i++) {
    		dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
    	}
    	System.out.println(dp[n]);
    }
   
   
}