import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	arr = new int[n];
    	visited = new boolean[n];
    	result = new int[m];
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	solution(0);
    	System.out.println(sb);
    }
    static void solution(int depth) {
    	if(depth == m) {
    		for(int i=0; i<m; i++) {
    		sb.append(result[i] + " ");
    		}
    		sb.append("\n");
    		
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			result[depth] = arr[i];
    			solution(depth+1);
    			visited[i] = false;
    		}
    	}
    	
    }
   
  
}
