import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int n;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int sum=0;
    	int[] A = new int[n];
    	int[] B = new int[n];
    	//왜 Integer??
    	Integer[] idxB = new Integer[n];
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		B[i] = a;
    		idxB[i] = i;
    	}
    	Arrays.sort(A);
    	//이것의 의미 
    	Arrays.sort(idxB, (i,j) -> B[j] - B[i]);
    	for(int i=0; i<n; i++) {
    		sum += A[i] * B[idxB[i]];
    	}
    	System.out.println(sum);
    }
    
    

}
