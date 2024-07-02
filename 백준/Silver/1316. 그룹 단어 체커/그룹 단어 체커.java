import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int cnt=0;
    	for(int i=0; i<n; i++) {
    		String s = br.readLine();
    		if(solution(s)) cnt++;
    		
    	}
    	System.out.println(cnt);
    } 
    
    static boolean solution(String s) {
    	int[] arr = new int[26];
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
    			if(arr[s.charAt(i) - 'a']==0) {
        			arr[s.charAt(i) - 'a']++;
        		} else {//처음 더하는 것이 아니다 이미 카운트된 것이 있다 
        			if(i-1>=0) {
        				if(s.charAt(i-1) != s.charAt(i)) return false;
        			}
        			
        		}
    		}
    	}
    	return true;
    }
  
   
}