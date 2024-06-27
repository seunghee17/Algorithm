import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
	static int N,R,C, ans=0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	find(0,0,(int)Math.pow(2, N));
    }
    //마지막으로 방문한 인덱스를 받는다 
    static void find(int r, int c, int size) {
    	if(size==1) {
    		System.out.println(ans);
    		return;
    	}
    	int newsize = size/2;
    	if(R < r+newsize && C < newsize+c) {
    		find(r,c,newsize);
    	}
    	else if(R < r+newsize && c+newsize <= C) {
    		//2사분면으로 갈경우 
    		ans += (size*size) /4;
    		find(r, c+newsize, newsize);
    	}
    	else if(r+newsize<=R && C<c+newsize) {
    		//3사분면으로 갈경
    		ans += ((size*size) /4) * 2;
    		find(r+newsize, c, newsize);
    	}
    	
    	else if(r+newsize <= R && c+newsize<=C) {
    		//4사분면일 경우 
    		ans += ((size*size) /4) * 3;
    		find(r+newsize, c+newsize, newsize);
    	}
    	
    }
    
    
    
   

}