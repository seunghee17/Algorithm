class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        func(words,begin, 0, target);
        return answer;
    }
    
    static void func(String[] words, String begin, int cnt, String target) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++) {
            if(isOne(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                func(words, words[i], cnt+1, target);
                visited[i] = false;
            }
        }
    }
    
    static boolean isOne(String st, String word) {
        int len = st.length();
        int cnt =0;
        for(int i=0; i<len; i++) {
            if(st.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        if(cnt==1) {
            return true;
        } else return false;
    }
}