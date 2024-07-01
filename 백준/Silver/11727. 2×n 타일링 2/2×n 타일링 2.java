import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static long[] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	dp = new long[1001];
    	dp[1] = 1;
    	dp[2] = 3;
    	for(int i=3; i<=n; i++) {
    		dp[i] = -1;
    	}
    	
    	System.out.println(solution(n));
    }
    static long solution(int n) {
    	if(dp[n] != -1) {
    		return dp[n];
    	}
    	 return dp[n] = (solution(n-1) + 2*solution(n-2)) % 10007;
    			
    }
    
   
}