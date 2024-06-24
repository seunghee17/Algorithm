import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
  
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int i=0;
       while(true) {
    	   String s = br.readLine();
    	   if(s.equals("0 0 0")) break;
    	   StringTokenizer st = new StringTokenizer(s, " ");
    	   int l = Integer.parseInt(st.nextToken());
    	   int p = Integer.parseInt(st.nextToken());
    	   int v = Integer.parseInt(st.nextToken());
    	   int result = (v/p) * l; //10이 세팅됨 
    	   //남은 일수를 계산 
    	   result = result + Math.min(l, v%p);
    	   i++;
    	   System.out.println("Case " + i + ":" + " " + result);
    	  
       }
       
    }
    
   
}