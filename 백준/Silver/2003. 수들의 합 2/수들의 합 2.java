import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int left = 0;
    	int right =0;
    	int cnt=0;
    	int sum=0;
    	while(true) {
    		if(sum >= m) {
    			sum -= arr[left++];
    		}
    		else if(right == n) {
    			break;
    			
    		} else {
    			sum += arr[right++];
    		}
    		if(sum==m) cnt++; 
    	}
    	
    	System.out.println(cnt);
    } 
    
   
   
}