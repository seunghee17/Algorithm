
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[] dx = {-1,0,1,0}; //순서는 북동남서 
	static int[] dy = {0,1,0,-1};
	static int[][] place;
	static int result=0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	//로봇청소기 있는 좌표와 방향입력 
    	st = new StringTokenizer(br.readLine(), " ");
    	int r = Integer.parseInt(st.nextToken());//좌표 
    	int c = Integer.parseInt(st.nextToken());//좌표 
    	int d = Integer.parseInt(st.nextToken());//방향 
    	
    	//장소의 상태 
    	place = new int[n][m];
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<m; j++) {
    			place[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	cleaning(r,c,0,d);
    	System.out.println(result);
    }
    static void cleaning(int cx, int cy, int cnt, int d) {
    	if(place[cx][cy] == 0) {
    		place[cx][cy] = 2; //청소가 된 상태는 2로 표시 
    		cnt++; 
    	}
    	if(place[cx][cy] == 1) { //이동할 칸이 벽이다 작동 멈춤 
    		result = cnt;
    	}
    	if(place[cx][cy] == 2) { //현재칸은 청소가 된 상태 
    		if(isneed(cx,cy)) { //주변 4칸 모두 청소가 완료됨 
    			//바라보는 방향에서 후진시키기 위해 
    			if(d+2 >=4) {
    				int dir = d-2;
    				cleaning(cx+dx[dir], cy + dy[dir], cnt, d);
    			} else {
    				int dir = d+2;
    				cleaning(cx+dx[dir], cy + dy[dir], cnt, d);
    			}
    		} else {//주변 4칸중 청소 안된곳이 있다 
    			//반시계 방향으로 회전
    			int nx=0;
    			int ny=0;
    			while(true) { //청소하지 않은 방향을 찾을때까지 반복한다 
    				if(d==0) {
        				d=3;
        			} else {
        				d-=1;
        			}
    				if(place[cx+dx[d]][cy + dy[d]] == 0) { //청소하지 않은 방향발견 
    					nx = cx+dx[d];
    					ny = cy + dy[d];
    					break;
    				}
    			}
    			cleaning(nx,ny,cnt,d);
    		}
    	}
    }
    
   static boolean isneed(int cx, int cy) {
	   for(int i=0; i<4; i++) {
		   int nx = cx+dx[i];
		   int ny = cy + dy[i];
		   if(place[nx][ny] ==0) return false;
	   }
	   return true;
   }
  
}
