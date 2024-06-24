
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static char[][][] building;
	static int[][][] visited;
	static int[] dz = {1,-1,0,0,0,0};
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {0,0,0,0,-1,1};
	static int l;
	static int r; 
	static int c;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	while(true) {
    		String first = br.readLine();
    		if(first.equals("0 0 0")) break;
    		StringTokenizer st = new StringTokenizer(first, " ");
        	l = Integer.parseInt(st.nextToken());
        	r = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	building = new char[l][r][c];
        	visited = new int[l][r][c];
        	int startz = 0;
        	int startx=0;
        	int starty=0;
        	for(int i=0; i<l; i++) {
        		for(int m=0; m<r; m++) {
        			String s = br.readLine();
        			for(int n=0; n<c; n++) {
        				building[i][m][n] = s.charAt(n);
        				if(building[i][m][n] == 'S') {
        					startz = i;
        					startx = m;
        					starty = n;
        				}
        				
        			}
        		}
        		br.readLine();
        	}
        	//bfs돌려야함 
        	int time = exit(startz, startx, starty);
        	if(time==0) {
        		System.out.println("Trapped!");
        	} else {
        		System.out.println("Escaped in " + time + " minute(s).");
        	}
    	}
    }
    static int exit(int startz, int startx, int starty) {
    	Queue<int[]> q = new LinkedList<>();
    	int time = 0;
    	q.offer(new int[] {startz, startx, starty});
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		for(int i=0; i<6; i++) {
    			int nz = now[0] + dz[i];
    			int nx = now[1] + dx[i];
    			int ny = now[2] + dy[i];
    			if(nz >=0 && nz<l && nx>=0 && nx<r && ny >=0 && ny<c && visited[nz][nx][ny] ==0 && building[nz][nx][ny]!='#') {
    				q.offer(new int[] {nz,nx,ny});
    				visited[nz][nx][ny] = visited[now[0]][now[1]][now[2]] +1;
    				
    			}
    		}
    	}
    	
    	for(int i=0; i<l; i++) {
    		for(int m=0; m<r; m++) {
    			for(int n=0; n<c; n++) {
    				if(building[i][m][n] == 'E') {
    					time = visited[i][m][n];
    				}
    			}
    		}
    	}
    	return time;
    }

}

	 
