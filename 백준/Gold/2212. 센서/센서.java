
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int k = Integer.parseInt(br.readLine());
    	int[] sensor= new int[n];
    	Integer[] diff = new Integer[n-1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		sensor[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(sensor);
    	for(int i=0; i<n-1; i++) {
    		diff[i] = sensor[i+1] - sensor[i];
    	}
    	Arrays.sort(diff, Collections.reverseOrder());
    	int sum=0; 
    	for(int i=k-1; i<n-1; i++) {
    		sum += diff[i];
    	}
    	if(k >= n) {
    		System.out.println(0);
    	} else {
    		System.out.println(sum);
    	}
    
    }
   
}