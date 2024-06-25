
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] p = new int[n];
    	Integer[] idx = new Integer[n];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		p[i] = Integer.parseInt(st.nextToken());
    		idx[i] = i;
    	}
    	int[] d = new int[n];
    	Arrays.sort(idx, (i,j) -> p[i]- p[j]);
    	d[0] = p[idx[0]];
    	for(int i=1; i<n; i++) {
    		d[i] = d[i-1] + p[idx[i]];
    	}
    	int sum=0;
    	for(int i=0; i<n; i++) {
    		sum += d[i];
    	}
    	System.out.println(sum);
    }
    
    

}