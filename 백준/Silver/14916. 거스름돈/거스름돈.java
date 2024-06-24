
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
  
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine()); //13
       int min = Integer.MAX_VALUE;
       if(n%5==0) {
    	   min = n/5;
    	   System.out.println(min);
       }else {
    	   int chance = n/5;
    	   for(int i=0; i<=chance; i++) {
    		   int cnt=0;
    		   int rest = n;
    		   rest -= 5*i;
    		   cnt+=i;
    		   cnt+=rest/2;
    		   rest -= ((rest/2)*2);
    		   if(rest==0) {
    			   //남은 것이 없다  
    			   min = Math.min(min, cnt);
    		   }continue;
    	   }
    	   if(min == Integer.MAX_VALUE) {
    		   System.out.println(-1);
    	   } else {
    		   System.out.println(min);
    	   }
       }
    }
    
   
}