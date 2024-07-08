import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[][] board;
	static List<int[]> snack = new ArrayList<>();
	static HashMap<Integer, String> hash = new HashMap<>();
	static int n,k;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine()); //보드의 크기 
    	k = Integer.parseInt(br.readLine()); //사과의 개수 
    	board = new int[n+1][n+1];
    	for(int i=0; i<k; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    	}
    	int l = Integer.parseInt(br.readLine()); //방향 변환횟수 
    	for(int i=0; i<l; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		int x = Integer.parseInt(st.nextToken());
    		String dir = st.nextToken();
    		hash.put(x, dir);
    	}
    	solve();
    }
    static void solve() {
    	int cx=1; 
    	int cy = 1;
    	int time=0;
    	int dir=0;
    	snack.add(new int[] {cx,cy});
    	while(true) {
    		time++;
    		int nx = cx + dx[dir];
    		int ny = cy + dy[dir];
    		
    		//갈수 있는 길인지 판별해야함 
    		if(isFinish(nx,ny)) break;
    		
    		//사과 있을때와 없을때 
    		if(board[nx][ny] ==1) {
    			board[nx][ny] =0;
    			snack.add(new int[] {nx,ny}); //머리가 그 다음칸에 위치하므로 
    		} else {
    			snack.add(new int[] {nx,ny});
    			snack.remove(0); //꼬리가 위치한 칸은 가장 처음에 넣어둔 원소이므로 
    		}
    		
    		if(hash.containsKey(time)) {
    			if(hash.get(time).equals("D")) {
    				dir+=1;
    				if(dir==4) dir=0;
    			} else {
    				dir-=1;
    				if(dir==-1) dir=3;
    			}
    		}
    		cx = nx;
    		cy = ny;
    	}
    	System.out.println(time);
    }

   static boolean isFinish(int nx, int ny) {
	   if(nx<1 || ny<1 || nx>n || ny>n) {
		   return true;
	   }
	   for(int i=0; i<snack.size(); i++) {
		   int[] die = snack.get(i);
		   if(nx == die[0] && ny == die[1]) return true;
	   }
	   return false;
   }
    
  
}