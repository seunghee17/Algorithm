
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	int[] dp = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken()); //완성함 
    	}
    	//나보다 작은 수중 가장 큰값으로 dp 지정함  
    	//dp[i] i번째 숫자 추가시 최대 길이 
    	
    	 dp[0] = 1;
    	 
    	for(int i=1; i<n; i++) {
    		dp[i] = 1;
    		for(int j=0; j<i; j++) {
    			if(arr[i] > arr[j] && dp[j] >= dp[i] ) { //수열을 만족하기에 적합한 수이다 i는 
    				dp[i] = dp[j] + 1;
    			}
    			
    		}
    		
    	}
    	Arrays.sort(dp);
    	System.out.println(dp[n-1]);
    }
    
   
}
