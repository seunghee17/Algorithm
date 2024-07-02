
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine(); //소문자, 대문자, 숫자 
    	String k = br.readLine(); //소문자 대문자 
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) >= '0' && s.charAt(i) <='9') {
    			continue;
    		} 
    		sb.append(s.charAt(i));
    	}
    	
    	
    	int result = 1;
    	if(!sb.toString().contains(k)) {
    		result =0;
    	}
    	System.out.println(result);
    } 
  
   
}
         