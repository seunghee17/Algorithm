
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n;
	static Character[][] board;
	static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	board = new Character[n][n];
    	for(int i=0; i<n; i++) {
    		String s = br.readLine();
    		for(int j=0; j<n; j++) {
    			board[i][j] = s.charAt(j);
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(j != n-1) {
    				change(i,j,i,j+1);
    				//탐색 함수 
    				search();
    				change(i,j,i,j+1);
    			}
    			
    			if(i != n-1) {
    				change(i,j,i+1,j);
    				search();
    				change(i,j,i+1,j);	
    			}
    		}
    	}
    	System.out.println(max);
    	
    	
    }
    
    
    static void change(int beforex, int beforey, int afterx, int aftery) { //인접한 두칸의 사탕을 교환하는역할 
    	Character ch = board[beforex][beforey];
    	board[beforex][beforey] = board[afterx][aftery];
    	board[afterx][aftery] = ch;
    }
    
    static void search() {
    	//행별 탐색
    	
    	for(int i=0; i<n; i++) {
    		int cnt = 1;
    		for(int j=0; j<n-1; j++) {
    			if(board[i][j] == board[i][j+1]) {
    				cnt++;
    				max = Math.max(max, cnt);
    			} else {
    				cnt=1;
    			}
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		int cnt=1;
    		for(int j=0; j<n-1; j++) {
    			if(board[j][i] == board[j+1][i]) {
    				cnt++;
    				max = Math.max(max, cnt);
    			} else {
    				cnt=1;
    			}
    		}
    	}
    	
    }
    
    
    

}