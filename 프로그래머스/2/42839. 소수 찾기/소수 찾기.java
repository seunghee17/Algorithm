import java.io.*;
import java.util.*;

class Solution {
    //만든 소수 중복값 제거를 위함
    static HashSet<Integer> numSet;
    static boolean[] visited;
    static char[] arr;
    public int solution(String numbers) {
        int answer = 0;
        numSet = new HashSet<>();
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        recur("", 0);
        answer = numSet.size();
        return answer;
    }
    
    static void recur(String str, int idx) {
        int num;
        if(str != "") {
            num = Integer.parseInt(str);
            if(isPrime(num)) numSet.add(num);
        }
        if(idx == arr.length) return; //끝까지 다함
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(str+arr[i], idx+1);
                visited[i] = false;
            }
        }
    }
    //소수 판별
    static boolean isPrime(int num) {
       if(num ==0 || num ==1) return false;
        for(int i=2; i*i<=num; i++) {
            if(num%i ==0) return false;
        }
        return true;
    }
}