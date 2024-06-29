import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int m,n;
	static int[][] graph;
	static int[] chess1 = {1,0,1,0,1,0,1,0};
	static int[] chess2 = {0,1,0,1,0,1,0,1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	graph = new int[m][n];
    	int firstmin = Integer.MAX_VALUE;
    	int secondmin = Integer.MAX_VALUE;
    	for(int i=0; i<m; i++) {
    		String s = br.readLine();
    		for(int j=0; j<n; j++) {
    			if(s.charAt(j) == 'W') {
    				graph[i][j] = 1;
    			} else {
    				graph[i][j] = 0;
    			}
    		}
    		
    	}
    	for(int i=0; i<m-7; i++) {
    		for(int j=0; j<n-7; j++) {
    			firstmin = Math.min(firstmin
    					, first(i,j));
    			secondmin = Math.min(secondmin, second(i,j));
    		}
    	}
    	
    	int result = Math.min(firstmin, secondmin);
    	System.out.println(result);
    	
    }
    static int first(int col, int row) {//wbwbwb bwbwbw
    	
    	int cnt=0;
    	
    	for(int i=0; i<8; i++) {
    		for(int j=0; j<8; j++) {
    			if(i % 2==0) {
    				if(graph[col+i][row+j] != chess1[j]) cnt++;
    			} else {
    				if(graph[col+i][row+j] != chess2[j]) cnt++;
    			}
    		}
    	}
    	return cnt;
    	
    }
    
    static int second(int col, int row) {//bwbwbw wbwbwb chess2 chess1 순으로 
    	int cnt=0;
    	
    	for(int i=0; i<8; i++) {
    		for(int j=0; j<8; j++) {
    			if(i % 2==0) {
    				if(graph[col+i][row+j] != chess2[j]) cnt++;
    			} else {
    				if(graph[col+i][row+j] != chess1[j]) cnt++;
    			}
    		}
    	}
    	return cnt;
    }
    
}