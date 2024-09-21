import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	while(t-->0) {
    		String sr = br.readLine();
			if(caseB(Integer.parseInt(sr))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
    	}
    	
    }
    
    static boolean caseB(int s) {
    	for(int i=2; i<65; i++) {
    		List<Integer> list = new ArrayList<Integer>();
    		int num = s;
    		while(true) {
    			if(num==0)
    				break;
    			list.add(0,num%i);
    			num/=i;
    		}
    		int start = 0;
    		int end = list.size()-1;
    		while(start<end) {
    			if(!list.get(start).equals(list.get(end))) {
    				break;
    			}
    			start++;
    			end--;
    		}
    		if(start>=end) {
    			return true;
    		}
    		
    	}
    	return false;
    }

}