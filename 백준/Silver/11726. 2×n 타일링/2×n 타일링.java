import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static long[] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	arr = new long[1001];
    	arr[1] = 1;
    	arr[2] = 2;
    	for(int i=3; i<=n; i++) {
    		arr[i] = -1;
    	}
    	
    	System.out.println(recur(n));
    }
   static long recur(int n) {
	   if(arr[n] != -1) {
		   return arr[n];
	   }
	   return arr[n] = (recur(n-2) +recur(n-1)) % 10007;
   }
   
}