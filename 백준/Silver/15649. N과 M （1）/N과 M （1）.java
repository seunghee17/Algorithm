
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static boolean[] visited;
	static int[] arr;
	static int n,m;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	visited = new boolean[n];
    	arr = new int[m]; //수열을 출력하는 용도 
    	find(0);
    }
    
    static void find(int depth) {
    	if(depth ==m) {
    		for(int i: arr) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			arr[depth] = i+1;
    			find(depth+1);
    			visited[i] = false;
    		}
    	}
    	return;
    }
  
}
