import java.io.*;
import java.util.*;

class Solution {
    static int m;
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] visited;
    public int solution(int[][] maps) {
        m = maps.length; //행
        n = maps[0].length; //열
        visited = new int[m][n];
       int answer = game(maps);
        if(answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }
    static int game(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            for(int i=0; i<4; i++) {
                int newx = nx+dx[i];
                int newy = ny + dy[i];
                if(newx>=0 && newx<m && newy>=0 && newy<n) {
                    if(maps[newx][newy]==1 && visited[newx][newy]==0) {
                        visited[newx][newy] = visited[nx][ny] + 1;
                        q.offer(new int[] {newx, newy});
                    }
                }
            }
        }
        return visited[m-1][n-1];
    }
}