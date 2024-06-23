import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		//N을 2그룹으로 나누어야한다 
		combi(0,0);
		System.out.println(min);
		
	}	
	static void combi(int idx, int count) {
		if(count == N/2) {
			// 두그룹으로 나누기완료 
			diff();
			return;
		}
		for(int i = idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(i+1, count+1);
				visited[i] = false;
			}
		}
	}
	static void diff() {
		int start = 0;
		int link = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] == true && visited[j] == true) {
					//스타트팀점수 
					start += graph[i][j];
					start += graph[j][i];
				}
				else if(visited[i] == false && visited[j] == false) {
					link += graph[i][j];
					link += graph[j][i];
				}
			}
		}
		int val = Math.abs(start-link);
		if(val ==0) {
			System.out.println(val);
			System.exit(0);
		}
		min = Math.min(val, min);
	}
}
