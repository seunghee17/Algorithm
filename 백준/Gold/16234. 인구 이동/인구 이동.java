
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[][] place;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n,l,r;
	static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	l = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	place = new int[n][n];
    	for(int i=0; i< n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			place[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	System.out.println(move());
    	
    }
    
    public static int move() {
    	int result = 0;
    	while(true) {
    		boolean isMove = false;
    		visited = new boolean[n][n];
    		for(int i=0; i<n; i++) {
    			for(int j=0; j<n; j++) {
    				if(!visited[i][j]) {
    					int sum = bfs(i,j);
    					if(list.size() >1) {
    						change(sum);
    						isMove = true;
    					}
    				}
    			}
    		}
    		if(!isMove) return result;
    		result++;
    	}
    }
    
    static void change(int sum) {
    	int avg = sum/list.size();
    	for(Node n: list) {
    		place[n.x][n.y] = avg;
    	}
    }
    
    static int bfs(int x, int y) {
    	Queue<Node> q = new LinkedList<>();
    	list = new ArrayList<>(); //조건에 만족할 노드를 넣는다 
    	q.offer(new Node(x,y));
    	list.add(new Node(x,y));
    	visited[x][y] = true;
    	int sum = place[x][y];
    	while(!q.isEmpty()) {
    		Node current = q.poll();
    		for(int i=0; i<4; i++) {
    			int nx = current.x + dx[i];
    			int ny = current.y + dy[i];
    			if(nx >=0 && nx<n && ny >=0 && ny<n && !visited[nx][ny]) {
    				int diff = Math.abs(place[current.x][current.y] - place[nx][ny]);
    				if(l<=diff && diff<=r) {
    					q.offer(new Node(nx,ny));
    					list.add(new Node(nx,ny));
    					sum += place[nx][ny];
    					visited[nx][ny] = true;
    				}
    			}
    		}
    	}
    	return sum;
    }
    
    static class Node {
    	int x;
    	int y;
    	public Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
}