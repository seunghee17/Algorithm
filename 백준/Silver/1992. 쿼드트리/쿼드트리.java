import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	graph = new int[n][n];
    	for(int i=0; i<n; i++) {
    		String line = br.readLine();
    		for(int j=0; j<n; j++) {
    			graph[i][j] = line.charAt(j) - '0';
    			
    		}
    	}
    	QuadTee(0,0,n);
    	System.out.println(sb);
    	
    }
    static void QuadTee(int x, int y, int size) {
    	//만약 현재 영역이 압축 가능하다면 
    	if(isPossible(x,y,size)) {
    		sb.append(graph[x][y]);
    		return;
    	}
    	//이것은 현재 받은 영역이 ispossible 거짓이라는 말과 같다 
    	sb.append("(");
    	QuadTee(x,y,size/2);
    	QuadTee(x,y+(size/2), size/2);
    	QuadTee(x+(size/2),y, size/2);
    	QuadTee(x+(size/2),y+(size/2), size/2);
    	sb.append(")");
    }
    
    public static boolean isPossible(int x, int y, int size) {
    	int value = graph[x][y];
    	for(int i=x; i<x+size; i++) {
    		for(int j=y; j<y+size; j++) {
    			if(value != graph[i][j]) return false;
    		}
    	}
    	return true;
    }

}