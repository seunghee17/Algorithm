import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static char[] arr,result;
	static boolean[] visited;
	static int l,c;
	static StringBuilder sb  = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	l = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	arr = new char[c];
    	result = new char[l];
    	visited = new boolean[c];
    	String s = br.readLine().replace(" ", "");
    	for(int i=0; i<c; i++) {
    		arr[i] = s.charAt(i);
    	}
    	Arrays.sort(arr);
    	solution(0,0);
    	System.out.print(sb);
    }
    static void solution(int depth, int start) {
    	if(depth == l) {
    		int a =0;
    		int b=0;
    		for(int i=0; i<l; i++) {
    			if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
    				a++;
    			} else b++;
    		}
    		if(a>=1 && b>=2) {
    			for(int i=0; i<l; i++) {
    				sb.append(result[i]);
    			}
    			sb.append('\n');
    		}
    		return;
    	}
    	
    	for(int i=start; i<c; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			result[depth] = arr[i];
    			solution(depth+1, i+1);
    			visited[i] = false;
    		}
    	}
    }

  
}