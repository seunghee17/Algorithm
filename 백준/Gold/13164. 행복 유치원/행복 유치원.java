import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	Integer[] diff = new Integer[n-1];
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		
    	}
    	Arrays.sort(arr);
    	for(int i=0; i<n-1; i++) {
    		diff[i] = arr[i+1] - arr[i];
    	}
    	Arrays.sort(diff);
    	int sum=0; 
    	
    	for(int i=0; i<n-k; i++) {
    		sum += diff[i];
    	}
    	
    	System.out.println(sum);
    }
    
   
}
    