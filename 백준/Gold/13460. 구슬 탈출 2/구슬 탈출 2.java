import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	 static class Marble {
		   int rx;
		   int ry;
		   int bx;
		   int by;
		   int cnt;
		   
		   Marble(int rx, int ry, int bx, int by, int cnt) {
			   this.rx = rx;
			   this.ry = ry;
			   this.bx = bx;
			   this.by = by;
			   this.cnt = cnt;
		   }
	   }
	static int n,m;
	static char[][] board;
	//빨강 파랑 두위치 기반 검증을 하기위해 4차원 배열로 
	static boolean[][][][] visited;
	static int holex, holey;
	//각 구슬별 정보를 넣어두기 위해서 클래스 생성 
	static Marble blue, red;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	board = new char[n][m];
    	visited = new boolean[n][m][n][m];
    	for(int i=0; i<n; i++) {
    		String s = br.readLine();
    		for(int j=0; j<m; j++) {
    			board[i][j] = s.charAt(j);
    			if(board[i][j] == 'O') {
    				holex = i;
    				holey = j;
    			} else if(board[i][j] == 'B') {
    				blue = new Marble(0,0,i,j,0);
    			} else if(board[i][j] == 'R') {
    				red = new Marble(i,j,0,0,0);
    			}
    		}
    	}
    	System.out.println(bfs());
    	
    }
   static int bfs() {
	   Queue<Marble> q = new LinkedList<>();
	   q.add(new Marble(red.rx, red.ry, blue.bx, blue.by,1));
	   visited[red.rx][red.ry][blue.bx][blue.by] = true;
	   
	   while(!q.isEmpty()) {
		   Marble m = q.poll();
		   int currx = m.rx;
		   int curry = m.ry;
		   int curbx = m.bx;
		   int curby = m.by;
		   int curcnt = m.cnt;
		   
		   if(curcnt > 10) {//이동횟수 10초과시 실패이므로 
			   return -1;
		   }
		   for(int i=0; i<4; i++) {
			   int newrx = currx;
			   int newry = curry;
			   int newbx = curbx;
			   int newby = curby;
			   
			   boolean isRedHole = false;
			   boolean isBlueHole = false;
			   //빨간 구슬부터 이동 장애물 만날때까지 
			   while(board[newrx + dx[i]][newry + dy[i]] != '#') {
				   newrx += dx[i];
				   newry += dy[i];
				   if(newrx == holex && newry == holey) {
					   isRedHole = true;
					   break;
				   }
			   }
			   while(board[newbx + dx[i]][newby + dy[i]] != '#') {
				   newbx += dx[i];
				   newby += dy[i];
				   if(newbx == holex && newby == holey) {
					   isBlueHole = true;
					   break;
				   }
			   }
			   if(isBlueHole) { //무조건 실패이지만 큐에 남는 다른 좌표도봐야하기에 ????
				   continue;
			   }
			   if(isRedHole && !isBlueHole) {
				   return curcnt;
			   }
			   if(newrx == newbx && newry == newby) {
				   //둘다 구멍에 빠지지는 않았으나 이동할 위치가 같은 경우 즉 붙어있었던 경우를 고려하기 위해서 
				   if(i==0) {
					   if(currx > curbx) newrx -= dx[i];
					   else newbx -= dx[i];
				   } else if(i==1) {
					   if(curry < curby) newry-=dy[i];
					   else newby-=dy[i];
				   } else if(i==2) {
					   if(currx < curbx) newrx -= dx[i];
					   else newbx -=dx[i];
				   } else {
					   if(curry>curby) newry-=dy[i];
					   else newby-=dy[i];
				   }
			   }
			   if(!visited[newrx][newry][newbx][newby]) { //처음 방문하는 곳일 경우 
				   visited[newrx][newry][newbx][newby] = true;
				   q.add(new Marble(newrx, newry,newbx,newby,curcnt+1));
			   }
 		   }
	   }
	   //빠져나갈 방법이 없는 경우 
	   return -1;
	   
   }
   
   
   
   
  
    
}