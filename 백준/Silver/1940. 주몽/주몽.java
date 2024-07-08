import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine()); //재료의 개수 
    	int m = Integer.parseInt(br.readLine()); //갑옷만드는데 필요한 수 
    	int[] arr = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		
    	}
    	int cnt=0;
    	for(int i=0; i<n; i++) {
    		for(int j=i+1; j<n; j++) {
    			if(arr[i] + arr[j] == m) cnt++;
    		}
    	}
    	System.out.println(cnt);
    } 
    
 
   
}
