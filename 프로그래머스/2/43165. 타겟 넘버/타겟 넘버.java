class Solution {
    static int len;
    static int cnt=0;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        func(0, 0, target, numbers);
        return cnt;
    }
    static void func(int sum, int idx, int target, int[] numbers) {
        if(idx==len) { //끝까지 다 탐색함
            if(sum==target) {
                cnt++;
            }
            return;
        }
        func(sum+numbers[idx], idx+1, target, numbers);
        func(sum-numbers[idx], idx+1, target, numbers);
    }
}