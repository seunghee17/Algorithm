
class Solution {
    static boolean[] visited;
    static int len;
    static int answer=-1;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        dfs(0,k,dungeons);
        return answer;
    }
    static void dfs(int depth, int potion, int[][] dungeons) {
        for(int i=0; i<len; i++) {
            if(!visited[i] && potion >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth+1, potion-dungeons[i][1],dungeons);
                visited[i] = false;
            }
            if(answer < depth) {
                answer = depth;
            }
        }
    }
}