import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static int graph[][];
	static int visited[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	graph = new int[n+1][m+1];
    	visited = new int [n+1][m+1];
    	for(int i=1; i<=n; i++) {
    		char[] line = br.readLine().toCharArray();
    		for(int j=1; j<=m; j++) {
    			graph[i][j] = line[j-1] - '0';
    		}
    	}
    	miro();
    	System.out.println(visited[n][m]);
    	
    }
    static void miro() {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {1,1});
    	visited[1][1] = 1;
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
        	int nx = now[0];
        	int ny = now[1];
        	for(int i=0; i<4; i++) {
        		int nextx = nx+dx[i];
        		int nexty = ny + dy[i];
        		if(nextx>=1 && nextx<n+1 && nexty >=1 && nexty < m+1) {
        			if(graph[nextx][nexty] == 1 && visited[nextx][nexty] ==0) {
        				visited[nextx][nexty] = visited[nx][ny]+1;
        				q.offer(new int[] {nextx, nexty});
        			}
        		}
        	}
    	}
    }

}