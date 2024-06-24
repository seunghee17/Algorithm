import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[] dx = {0,0,1,-1}; //
	static int[] dy = {1,-1,0,0}; //행 
	static int n=0;
	static int m=0;
	static int wall=3;
	static int[][] graph;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); //행 
		m = Integer.parseInt(st.nextToken()); //열 
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setwall(0);
		System.out.println(max);
		
		
	}
	//벽은 모든 경우에 한번씩 세워서 완탐을 진행한다 
	static void setwall(int cnt) {
		if(cnt == 3) {
			//바이러스 퍼진뒤 모습으로 그래프 만드는 함수 호출 
			bfs();			
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(graph[i][j] == 0) {
					graph[i][j] = 1;
					setwall(cnt+1);
					//계속 그래프를 돌려써야하기에 다시 원상복구 
					graph[i][j] = 0; 
				}
			}
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[][] graph1 = new int[n][m];
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph[i].length; j++) {
				graph1[i][j] = graph[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(graph[i][j] == 2) {
					q.offer(new int[] {i,j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				int x = now[0] +dx[i];
				int y = now[1] + dy[i];
				//범위 내부에 있는가? 
				if(x>=0 && x < n && y>=0 && y<m) {
					if(graph1[x][y] == 0) {
						q.add(new int[] {x,y});
						graph1[x][y] = 2;
					}
				}
			}
		}
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(graph1[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(cnt, max);
	}
	
}