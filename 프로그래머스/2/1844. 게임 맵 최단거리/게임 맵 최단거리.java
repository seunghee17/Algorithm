import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) { //최소 칸의 수 리턴
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        if(bfs(n,m,maps) == 0) {
            return -1;
        } else {
            return bfs(n,m,maps);
        }
    }
    static int bfs(int n, int m, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            for(int i=0; i<4; i++) {
                int newx = nx + dx[i];
                int newy = ny + dy[i];
                if(newx>=0 && newx<n && newy>=0 && newy<m && visited[newx][newy] ==0 && maps[newx][newy] !=0) {
                    visited[newx][newy] = visited[nx][ny] +1;
                    q.offer(new int[] {newx, newy});
                }
            }
        }
        return visited[n-1][m-1];
    }
}