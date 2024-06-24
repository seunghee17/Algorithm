import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] dist = new int[n-1];
    	int[] city = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	//거리입력 
    	for(int i=0; i<n-1; i++) {
    		dist[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine(), " ");
    	//리터당 금액 입력 
    	for(int i=0; i<n; i++) {
    		city[i] = Integer.parseInt(st.nextToken());
    	}
    	long sum =0; 
    	long minCost = city[0];
    	for(int i=0; i<n-1; i++) {
    		if(city[i] < minCost) {
    			minCost = city[i];
    		}
    		sum += minCost * dist[i];
    	}
    	System.out.println(sum);
    }
    
    
   
}
