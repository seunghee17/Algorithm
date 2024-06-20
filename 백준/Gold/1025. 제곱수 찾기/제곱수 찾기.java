import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int m,n;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int result = -1;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		
		
		//그래프 만듬 
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int di = -n; di < n; di++) { //행의 등차값 
					for(int df = -m; df < m; df++) {
						if(di==0&& df ==0) continue;
						int nl = i;
						int nj = j;
						int now=0;
						//범위 밖에 벗어나기 전까지 
						while(nl >=0 && nl<n && nj >=0 && nj < m) {
							now *= 10;
							now += graph[nl][nj];
							
							//해당 수가 제곱근인지 판별 
							int sqrt = (int) Math.sqrt((double)now);
							if(sqrt * sqrt == now) result = Math.max(result, now);
							nl += di;
							nj += df;
						}
					}
				}
			}
		}
		System.out.println(result);
		
 	}

		
}