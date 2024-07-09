
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x; 
			this.y = y;
		}
	}
	static char[][] field;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int n =12, m=6;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	field = new char[12][6];
    	for(int i=0; i<12; i++) {
    		String s = br.readLine().trim();
    		for(int j=0; j<6; j++) {
    			field[i][j] = s.charAt(j);
    		}
    	}
    	int count=0;
    	//board탐색하며 4개이상 뭉쳐있는 것을 발견한다 
    	while(true) {
    		boolean isfinish = true;
    		visited = new boolean[n][m];
    		for(int i=0; i<n; i++) {
    			for(int j=0; j<m; j++) {
    				if(field[i][j] != '.') {
    					list = new ArrayList<>();
    					bfs(field[i][j], i, j);
    					if(list.size() >=4) { //터트릴 뿌요 발견 
    						isfinish = false; //연쇄가일어났으므로 동시에 일어날 수 있는 것을 탐색 
    						for(int k=0; k<list.size(); k++) {
    							field[list.get(k).x][list.get(k).y] = '.';
     						}
    					}
    				}
    			}
    		}
    		//더이상 일어날게 없다 
    		if(isfinish) break;
    		fallpuyo();
    		count++;
    	}
    	System.out.println(count);
    	
    }
    static void fallpuyo() {
    	for(int i=0; i<m; i++) {
    		for(int j = n-1; j>0; j--) {
    			if(field[j][i] == '.') {
    				for(int k=j-1; k>=0; k--) {
    					if(field[k][i] != '.') {
    						field[j][i] = field[k][i];
    						field[k][i] = '.';
    						break;
    					}
    				}
    			}
    		}
    	}
    }
    
   static void bfs(char c, int x, int y) {
	   Queue<Node> q = new LinkedList<>();
	   list.add(new Node(x,y));
	   q.offer(new Node(x,y));
	   visited[x][y] = true;
	   while(!q.isEmpty()) {
		   Node current = q.poll();
		   for(int i=0; i<4; i++) {
			   int nx = current.x + dx[i];
			   int ny = current.y + dy[i];
			   if(nx>=0 && nx<n && ny>=0 && ny < m && !visited[nx][ny] && field[nx][ny] == c) {
				   visited[nx][ny] = true;
				   list.add(new Node(nx, ny));
				   q.offer(new Node(nx, ny));
			   }
		   }
	   }
   }
    
}