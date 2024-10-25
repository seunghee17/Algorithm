import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] dp = new int[N+2];
    	int[][] arr = new int[N+1][2];
    	for(int i=1; i<N+1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		arr[i][0] = Integer.parseInt(st.nextToken()); //시간 
    		arr[i][1] = Integer.parseInt(st.nextToken()); // 비용 
    	}
    	
    	for(int i=1; i<N+1; i++) {
    		dp[i] = Math.max(dp[i], dp[i-1]);
    		if(i+arr[i][0] <N+2) {
    			dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i]+arr[i][1]);
    		}
    		
    	}
    	int max = Math.max(dp[N], dp[N+1]);
    	System.out.println(max);
    }
    
    

}