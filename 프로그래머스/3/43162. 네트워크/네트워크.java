class Solution {
    static boolean[] visited;
    static int answer =0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        for(int i=0; i<computers.length; i++) {
            if(visited[i]==false) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    static void dfs(int node, int[][] computers) {
        visited[node] = true;
        for(int i=0; i<computers.length; i++) {
            if(visited[i] == false && computers[node][i]==1) {
                dfs(i, computers);
            }
        }
    }
}