
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	char[] arr = br.readLine().toCharArray();
    	int[] dp = new int[N];
    	for(int i=0; i<N; i++) {
    		dp[i] = Integer.MAX_VALUE;
    	}
    	dp[0] = 0;
    	for(int i=1; i<N; i++) { //이후의 값 
    		for(int j=0; j<i; j++) { // 이전의 값 
    			if(arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
    				dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
    			} else if(arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
    				dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
    			} else if(arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
    				dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
    			}
    		}
    	}
    	if(dp[N-1] != Integer.MAX_VALUE) {
    		System.out.println(dp[N-1]);
    	} else {
    		System.out.println(-1);
    	}
    }
    
    

}