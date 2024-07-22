
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	int n = Integer.parseInt(br.readLine());
    	Set<String> set = new HashSet<>();
    	int[] dp = new int[s.length()];
    	for(int i=0; i<n; i++) {
    		String word = br.readLine();
    		if(s.contains(word)) {
    			set.add(word);
    		}
    	}
    	for(int i=s.length()-1; i>=0; i--) {
    		if(set.contains(s.substring(i))) dp[i] = 1;
    		for(int j=i+1; j<s.length(); j++) {
    			if(dp[j] == 1 && set.contains(s.substring(i,j))) {
    				dp[i] = 1;
    			}
    		}
    	}
    	System.out.println(dp[0]);
    	
    }
   
    
}