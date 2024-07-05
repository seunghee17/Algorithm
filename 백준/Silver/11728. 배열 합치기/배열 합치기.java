import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[] A = new int[n];
    	int[] B = new int[m];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<m; i++) {
    		B[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int pointa = 0;
    	int pointb = 0;
    	while(pointa <n && pointb<m) {
    		if(A[pointa] < B[pointb]) {//pointa가 더 작다 
    			sb.append(A[pointa++]).append(" ");
    		} else {
    			sb.append(B[pointb++]).append(" ");
    		}
    	}
    	//남은 것들 
    	if(pointb == m) { //pointa는 아직 남았다 
    		for(int i=pointa; i<n; i++) {
    			sb.append(A[i]).append(" ");
    		}
    	}
    	if(pointa == n) {
    		for(int i=pointb; i<m; i++) {
    			sb.append(B[i]).append(" ");
    		}
    	}
    	System.out.println(sb.toString());
    } 
    
  
   
}
     