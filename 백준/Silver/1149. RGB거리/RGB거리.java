
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[][] cost;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	cost = new int[n][3];//모든 정보는 여기에 있다 
    	dp = new int[n][3];
    	StringTokenizer st;
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine().trim());
    		cost[i][0] = Integer.parseInt(st.nextToken());
    		cost[i][1] = Integer.parseInt(st.nextToken());
    		cost[i][2] = Integer.parseInt(st.nextToken());
    	}
    	for(int i=1; i<n; i++) {
    		cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
    		cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
    		cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
    	}
    	System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));
    }
    
   
}
