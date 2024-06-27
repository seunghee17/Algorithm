import java.io.*;
import java.util.*;
import java.math.*;


public class Main{
	static int graph[][];
	static int a=0; //-1
	static int b=0; //0
	static int c=0; //1
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	graph = new int[n][n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			graph[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	paper(0,0,n);
    	System.out.println(a);
    	System.out.println(b);
    	System.out.println(c);
    }
    static void paper(int x, int y, int size) {
    	if(isValid(x,y, size)) {
    		//이부분은 탐색 그만해도 됨 
    		if(graph[x][y] == -1) {
    			a++;
    		} else if(graph[x][y] == 0) {
    			b++;
    		} else if(graph[x][y] == 1) {
    			c++;
    		}
    		return;
    	}
    	
    	int nsize = size/3;
    	
    	paper(x,y,nsize);
    	paper(x,y+nsize,nsize);
    	paper(x,y+(nsize*2),nsize);
    	
    	paper(x+nsize,y,nsize);
    	paper(x+nsize,y+nsize,nsize);
    	paper(x+nsize,y+(nsize*2),nsize);
    	
    	paper(x+(nsize*2),y,nsize);
    	paper(x+(nsize*2),y+nsize,nsize);
    	paper(x+(nsize*2),y+(nsize*2),nsize);
    }
    static boolean isValid(int x, int y, int size) {
    	int v = graph[x][y];
    	
    	for(int i=x; i<x+size; i++) {
    		for(int j=y; j<y+size; j++) {
    			if(graph[i][j] != v) return false;
    		}
    	}
    	
    	return true;
    }
   

}