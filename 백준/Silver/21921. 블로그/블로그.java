import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[] visitor;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	int n = Integer.parseInt(st.nextToken());
    	int x = Integer.parseInt(st.nextToken());
    	visitor = new int[n];
    	st = new StringTokenizer(br.readLine().trim());
    	for(int i=0; i<n; i++) {
    		visitor[i] = Integer.parseInt(st.nextToken());
    	}
    	int sum=0;
    	for(int i=0; i<x; i++) {
    		sum += visitor[i];
    	}
    	int max = sum; //초기 일자의 합 설정 
    	int cnt=1;
    	for(int i=0; i<n-x; i++) { //작으면 굳이 갱신하지 않는다 
    		sum += visitor[i+x];
    		sum -= visitor[i];
    		if(sum == max) {
    			cnt++;
    		}
    		else if(sum > max) {
    			cnt=1;
    			max=sum; //max 값 갱신 
    		}
    	}
    	if(max ==0) {
    		System.out.println("SAD");
    		
    	} else {
    		System.out.println(max);
    		System.out.println(cnt);
    	}
    } 
    
  
   
}
       