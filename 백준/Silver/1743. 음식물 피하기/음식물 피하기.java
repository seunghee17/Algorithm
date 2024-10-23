import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N;
	static int M;
	static int K;
	static int max = 0;
	static int[][] road;
	static int[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	road = new int[N+1][M+1];
    	visited= new int[N+1][M+1];
    	//쓰레기 위치가 포함된 2차원 배열 완성 
    	for(int i=0; i<K; i++) {
    		st = new StringTokenizer(br.readLine());
    		road[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    	}
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=M; j++) {
    			//쓰레기가 있는 구역이므로 이 지점부터 탐색을 시작한다.
    			if(road[i][j] ==1) {
    				//bfs정의 
    				max = Math.max(max, search(i,j,visited));
    			}
    		}
    	}
    	System.out.println(max);
    }
    static int search(int x, int y, int[][] visited) {
    	int cnt=1;
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] {x,y});
    	visited[x][y] = 1;
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int nx = now[0];
    		int ny = now[1];
    		for(int i=0; i<4; i++) {
    			int newx = nx+dx[i];
    			int newy = ny + dy[i];
    			if(newx>=1 && newx<N+1 && newy >=1 && newy<M+1) {
    				if(road[newx][newy]==1 && visited[newx][newy]==0) {
    					visited[newx][newy] = visited[nx][ny] + 1;
    					q.offer(new int[] {newx, newy});
    					cnt++;
    				}
    			}
    		}
    	}
    	return cnt;
    }
    

}