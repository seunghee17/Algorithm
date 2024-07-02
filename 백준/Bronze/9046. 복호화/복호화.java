import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	while(n-->0) {
    		String s = br.readLine().trim();
    		char[] arr = s.toCharArray(); //문자받을 배열 
    		int[] bindo = new int[26]; //빈도 저장할 배열 
    		for(int i=0; i<arr.length; i++) {
    			if(arr[i] >= 'a' && arr[i] <= 'z') {
    				int idx = arr[i] - 'a';
        			bindo[idx]++;
    			}
    			
    		}
    		int max =0;
    		ArrayList<Integer> list = new ArrayList<>();
    		
    		for(int i=0; i<26; i++ ) {
    			if(max < bindo[i]) {
    				max = bindo[i];
    			}
    		}
    		for(int i=0; i<26; i++ ) {
    			if(max == bindo[i]) {
    				list.add(i);
    			}
    		}
    		if(list.size() >1 ) {
    			System.out.println('?');
    		} else {
    			char result = (char) ('a' + list.get(0));
    			System.out.println(result);
    		}
    	}
    } 
    
   
}
        