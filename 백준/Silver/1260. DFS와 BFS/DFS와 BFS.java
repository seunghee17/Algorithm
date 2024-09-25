import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static int v;
	static int[][] graph;
	static boolean[] visit;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	v = Integer.parseInt(st.nextToken());
    	graph= new int[n+1][n+1];
    	visit = new boolean[n+1];
    	for(int i=0; i<m; i++) {
    		StringTokenizer sr = new StringTokenizer(br.readLine());
    		int first = Integer.parseInt(sr.nextToken());
    		int second = Integer.parseInt(sr.nextToken());
    		graph[first][second] = 1;
    		graph[second][first] = 1;
    	}
    	
    	dfs(v);
    	System.out.println();
    	visit = new boolean[n+1];
    	bfs(v);
    	
    }
    
    static void dfs(int start) {
    	visit[start] = true;
    	System.out.print(start + " ");
    	for(int i=1; i<=n; i++) {
    		if(graph[start][i] == 1 && !visit[i]) {
    			dfs(i);
    		}
    	}
    }
    
    static Queue<Integer> queue = new LinkedList<>();
    static void bfs(int node) {
    	queue.add(node);
    	visit[node] = true;
    	while(!queue.isEmpty()) {
    		int now = queue.poll();
    		System.out.print(now + " ");
    		for(int i=1; i<=n; i++) {
    			if(graph[now][i] == 1 && !visit[i]) {
    				queue.offer(i);
    				visit[i] = true;
    			}
    		}
    	}
    }
    

}