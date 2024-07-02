
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	HashSet<String> set = new HashSet<>();
    	for(int i=0; i<n; i++ ) {
    		String s = br.readLine();
    		set.add(s);
    	}
    	int cnt=0;
    	for(int j=0; j<m; j++) {
    		String s = br.readLine();
    		if(set.contains(s)) cnt++;
    	}
    	System.out.println(cnt);
    } 
    
   
   
}
     