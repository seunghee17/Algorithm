
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	arr = new int[n];
    	int max = Integer.MIN_VALUE;
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(arr);
    	
    	for(int i = arr.length-1; i>=0; i--) {
    		max = Math.max(max, sum(i,n));
    	}
    	System.out.println(max);
    }
    static int sum(int idx,int n) {
    	int small = Integer.MAX_VALUE;
    	int sum=0;
    	for(int i=idx; i<n; i++) {
    		if(small > arr[i]) small = arr[i];
    	}
    	return small*(n-idx);
    }
    
   
}