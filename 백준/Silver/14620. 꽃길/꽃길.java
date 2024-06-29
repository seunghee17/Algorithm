import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	graph = new int[n][n];
    	visited = new boolean[n][n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine().trim());
    		for(int j=0; j<n; j++) {
    			graph[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	solution(0,0);
    	System.out.println(min);
    	
    }
   
    static void solution(int flower, int sum) {
    	if(flower == 3) {
    		min = Math.min(sum, min);
    		return;
    	} 
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(!visited[i][j] && isvalid(i,j)) {
    				int cost = graph[i][j];
    				visited[i][j] = true;
    				
    				for(int k=0; k<4; k++) {
    					int nx = i+dx[k];
    					int ny = j+dy[k];
    					visited[nx][ny] = true;
    					cost += graph[nx][ny];
    				}
    				solution(flower+1, sum+cost);
    				visited[i][j] = false;
    				for(int k=0; k<4; k++) {
    					int nx = i+dx[k];
    					int ny = j+dy[k];
    					visited[nx][ny] = false;
    				} 
    			}
    		}
    	}
    }
    static boolean isvalid(int x, int y) {
    	for(int i=0; i<4; i++) {
    		int nx = x+dx[i];
    		int ny = y + dy[i];
    		if(nx>=0 && nx < n && ny>=0 && ny<n && !visited[nx][ny]) continue;
    		else return false; //범위 초과하거나 누군가 visit했거나 
    	}
    	return true;
    }
}
