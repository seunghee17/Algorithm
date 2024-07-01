
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static char[] first;
	static char[] second;
	static Integer[][] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	first = br.readLine().toCharArray();
    	second = br.readLine().toCharArray();
    	dp = new Integer[first.length][second.length];
    	int result = LCS(first.length-1, second.length-1);
    	System.out.println(result);
    } 
    static int LCS(int x, int y) {
    	if(x == -1 || y== -1) {
    		return 0;
    	}
    	if(dp[x][y] == null) {
    		dp[x][y] = 0;
    		
    		//만약 마지막 문자가 서로 같다면 
    		if(first[x] == second[y]) {
        		dp[x][y] = LCS(x-1, y-1) + 1;
        	}
        	//같지 않다면 
        	else {
        		dp[x][y] = Math.max(LCS(x-1, y), LCS(x,y-1));
        	}
    	}
    	
    	
    	return dp[x][y];
    }
    
}