import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int m;
	static int n;
	static int[] correct1 = {0,1,0,1,0,1,0,1}; //wbwbwbwb
	static int[] correct2 = {1,0,1,0,1,0,1,0}; //bwbwbwbw 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int [][] board = new int[m][n];
		//맞춤 board 완성 
		for(int i=0; i<m; i++) {
			String line = br.readLine();
			for(int j =0; j<n; j++) {
				if(line.charAt(j) == 'W') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<m-7; i++) {
			for(int j=0; j<n-7; j++) {
				//8*8 정사각형 부분을 찾았다 이제 이 상황에서 탐색을 시작한다 
				min = Math.min(min, paint(i,j,board));
			}
		}
		System.out.println(min);
 	}
	
	//호출하는 지점의 좌표를 매개수로 받는다 
	//나올 수 있는 경우의 수는 어차피 두가지 뿐이다 
	static int paint(int a, int b, int[][] board) {
		int[][] board1 = new int[8][8];
		int[][] board2 = new int[8][8];
		int cnt1 = 0;
		int cnt2 = 0;
		//여기에서만 사용할 수 있는 board를 따로 만들어준다. 
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				board1[i][j] = board[a+i][b+j];
				board2[i][j] = board[a+i][b+j];
			}
		}
		//correct1- correct2순으로 나올때 
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(board1[i][j] != correct1[j]) {
						cnt1++;
					}
				}else {
					if(board1[i][j] != correct2[j]) {
						cnt1++;
					}
				}
			}
		}
		//correct2- correct1순으로 나올때 
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(board2[i][j] != correct2[j]) {
						cnt2++;
					}
				}else {
					if(board2[i][j] != correct1[j]) {
						cnt2++;
					}
				}
			}
		}
		return Math.min(cnt1, cnt2);
		
	}
		
}