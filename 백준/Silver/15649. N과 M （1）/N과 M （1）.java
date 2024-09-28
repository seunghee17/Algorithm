
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static boolean visit[];
	static int arr[];
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	visit = new boolean[n+1];
    	arr = new int[n+1];
    	go(0);
    	System.out.println(sb);
    }
    
    public static void go(int index) {
    	if(index == m) {
    		for(int i=0; i<m; i++) {
    			sb.append(arr[i]).append(" ");
    		}
    		sb.append('\n');
    		return;
    	}
    	for(int i=1; i<=n; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			arr[index] = i;
    			go(index+1);
    			visit[i] = false;
    		}
    	}
    }

}
    