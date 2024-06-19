
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] board;
	static int[] dx = {0,1,1,-1};
	static int[] dy = {1,0,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<19; j++) {
				
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		int answer =0;
		int a=0;
		int b=0;
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(board[i][j] != 0) {
					for(int k=0; k<4; k++) {
						if(bfs(i,j,k)) {
							//연속된것임 
							System.out.println(board[i][j]);
							System.out.println((i+1) + " " + (j+1));
							return;
						} 
					}
					
				}
				
			}
		}
		System.out.println(0);
		
	}
	static boolean bfs(int a, int b, int dir) {
		int cnt =1; //이미 초기에 들어오는 값은 블랙이든 화이트이든이기 때문에 
		int nx = a;
		int ny = b;
		//5개의 돌이 연속됨을 체크한다 
		for(int i=0; i<4; i++) {
			nx += dx[dir];
			ny += dy[dir];
			if(nx >=0 && nx<19 && ny>=0 && ny <19 && board[nx][ny] == board[a][b]) {
				cnt++;
			} else return false; //다섯개도 연속하지 못하였음 
		} //이 반복문을 false를 안받고 통과했다면 5개의 연속성은 확인함 
		nx += dx[dir];
		ny += dy[dir];
		//범위에 있을때 체크해줘야한다 
		if(nx >=0 && nx<19 && ny>=0 && ny<19 && board[nx][ny] == board[a][b]) {
			//5개 연속 이후에 같은 돌이 나옴을 의미 
			return false;
		}
		//연속된 돌 가장 처음 부분 이전의 상태도 체크해주기 위함 
		nx = a-dx[dir];
		ny = b-dy[dir];
		if(nx >=0 && nx<19 && ny>=0 && ny<19 && board[nx][ny] == board[a][b]) {
			return false;
		}
		//false를 받지 않고 여기까지 도달하면 5개 연속됨을 확인한것 
		return cnt==5;
	}
	
		
}

	 