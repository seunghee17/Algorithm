
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	static int[] arr;
	static int s,n=0;
	static int cnt=0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	s = Integer.parseInt(st.nextToken());
    	arr = new int[n];
    	
    	StringTokenizer sr = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(sr.nextToken());
    	}
    	find(0,0);
    	if(s==0) {
    		System.out.println(cnt-1);
    	} else {
    		System.out.println(cnt);
    	}
    	
    }
    static void find(int depth, int sum) {
    	if(depth==n) {
    		if(sum==s) {
        		cnt++;
        	}
    		return;
    	}
    	find(depth+1, sum+arr[depth]); //현재 원소를 포함하는 경
    	find(depth+1, sum); //현재 원소를System.out.println(cnt-1); 포함하지 않는 경우 
    	
    }
  
}