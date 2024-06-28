import java.io.*;
import java.util.*;
import java.math.*;


public class Main {

	static int[] arr;
	static int n;
	static int cnt=0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];// index는 열 원소값은 행 
    	solution(0);
    	System.out.println(cnt);
    }
    static void solution(int depth) {
    	if(depth == n) {
    		cnt++;
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		arr[depth] = i;
    		if(possibility(depth)) {
    			solution(depth+1);
    		}
    		
    	}
    }
    
    static boolean possibility(int col) { //열 검사 
    	for(int i=0; i<col; i++) {
    		//같은 행에 존재할 경우 
    		if(arr[col] == arr[i]) {
    			return false;
    		}
    		//대각선상
    		else if( Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
    			return false;
    		}
    	}
    	return true;
    }

  
}
