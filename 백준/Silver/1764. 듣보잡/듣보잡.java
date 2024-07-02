
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	Set<String> set = new HashSet<>();
    	for(int i=0; i<n; i++) {
    		String s = br.readLine();
    		
    		set.add(s);
    	}
    	ArrayList<String> list = new ArrayList<>();
    	for(int i=0; i<m; i++) {
    		String s = br.readLine();
    		if(set.contains(s)) {
    			list.add(s);
    		}
    	}
    	
    	Collections.sort(list);
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(list.get(i));
    	}
    } 
  
   
}
                   
	