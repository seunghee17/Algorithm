import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	int[] range = new int[100001];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int left=0; 
    	int right=0;
    	int max=0;
    	while(right<n) {
    		while(right < n && range[arr[right]] +1 <= k) {
    			range[arr[right]] +=1;
        		right++;
    			
    		} 
    		max = Math.max(max, right-left);
			range[arr[left]] -= 1;
			left++;
    		
    	}
    	System.out.println(max);
    	
    } 
  
}
