import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] graph1;
	static int[][] graph2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph1 = new int[5][5];
		graph2 = new int[5][5];
		int cnt =0;
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				graph1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				graph2[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				remove(graph2[i][j]);
				cnt++;
				if(cnt>5) {
					int result = check();
					if(result >=3) {
						System.out.println(cnt);
						return;
					}
				}
			}
			
		}
		System.out.println(cnt);
	}
	static void remove(int a) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(graph1[i][j] == a) {
					graph1[i][j] = 0;
				}
			}
		}
	}
	
	static int check() {
		//행별로 탐색할것이다 
		int cnt=0;
		//대각선 검사 
		int sum1=0;
		int sum2=0;
		for(int i=0; i<5; i++) {
			sum1 += graph1[i][i];
			sum2 += graph1[i][4-i];
		}
		if(sum1 == 0) {
			cnt++;
		} 
		if(sum2 ==0) {
			cnt++;
		}
		
		
		for(int i=0; i<5; i++) {
			int sum3=0;
			int sum4=0;
			for(int j=0; j<5; j++) {
				sum3 += graph1[i][j];
				sum4 += graph1[j][i];
			}
			if(sum3==0) cnt++;
			if(sum4==0) cnt++;
		}
		return cnt;
	}
	
	
}