
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[] calcul;
	static int N;
	static int[] A;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			//순서를 바꾸면 안되는 후보 숫자들 
			A[i] = Integer.parseInt(st.nextToken());
		}
		calcul = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			calcul[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,A[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int depth, int result) {
		if(depth == N-1) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		depth++;
		for(int i=0; i<4; i++) {
			
			if(calcul[i] >0) {
				calcul[i]--;
				switch(i) {
				case 0: 
					dfs(depth, result+A[depth]);
					break;
				case 1: 
					dfs(depth, result-A[depth]);
					break;
				case 2: 
					dfs(depth, result*A[depth]);
					break;
				case 3:
//					if(result<0) {
//						result = (-1*result) / A[depth];
//						dfs(depth, result);
//					} else {
//						dfs(depth, result/=A[depth]);
//					}
					dfs(depth, result/A[depth]);
				break;
				}
				calcul[i]++;
			}
		}
		
	}
	
}