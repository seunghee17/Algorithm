
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int n=0;
	static int min = Integer.MAX_VALUE;
	static boolean[][] visited;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visited = new boolean[n][n];
		//boolean[][] visited = new boolean[n][n];
		//화단의 각 영역 가격 받음 
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min);
		
 	}
	static void dfs(int flower, int sum) {
		if(flower == 3) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//visited배열과 범위 내부에 있는지 확인해야한다 
				if(isvalid(i,j)) {
					setting(i,j,true);
					dfs(flower + 1 , sum + calcul(i,j));
					setting(i,j,false);
				}
			}
		}
		
	}
	
	static boolean isvalid(int a, int b) {
		if(visited[a][b]) {
			return false;
		} else {
			//꽃잎을 검사하기 위하여 
			for(int i=0; i<4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				if(nx>=0 && nx < n && ny>=0 && ny<n) {
					if(visited[nx][ny] == true) {
						//이미 씨앗이든 꽃이 있음 
						return false;					
					}
				}else return false;
			}
		}
		return true;
	}
	
	static void setting(int a, int b, boolean bool) {
		if(bool) {
			visited[a][b] = true;
			for(int i=0; i<4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				visited[nx][ny] = true;
			}
		} else {
			visited[a][b] = false;
			for(int i=0; i<4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				visited[nx][ny] = false;
			}
		}
	}
	static int calcul(int a, int b) {
		int sum = graph[a][b];
		for(int i=0; i<4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			sum += graph[nx][ny];
		}
		return sum;
	}
		
}