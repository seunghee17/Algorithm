
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	char[] first = br.readLine().toCharArray();
    	char[] second = br.readLine().toCharArray();
    	int[][] graph = new int[first.length + 1][second.length + 1];
    	for(int i=1; i<= first.length; i++) {
    		for(int j=1; j<=second.length; j++) {
    			if(first[i-1] == second[j-1]) {
    				graph[i][j] = graph[i-1][j-1] + 1;
    			}else {
    				graph[i][j] = Math.max(graph[i][j-1], graph[i-1][j]);
    			}
    		}
    	}
    	System.out.println(graph[first.length][second.length]);
    	
    }
}
    