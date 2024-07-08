
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int cnt=0;
    	int left=1;
    	int right=1;
    	int sum=0;
    	while(true) {
    		if(left==n) break;
    		if(right == left) {
    			sum = 0;
    		}
    		if(sum < n) {
    			sum += right;
    			right++;
    		}
    		else if(sum >= n) {
    			if(sum==n) {
    				cnt++;
    			}
    			left++;
    			right=left;
    		}
    	}
    	System.out.println(cnt+1);
    	
    } 
    
  
   
}