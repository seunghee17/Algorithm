
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		long a = Integer.parseInt(st.nextToken());
    		long b = Integer.parseInt(st.nextToken());
    		long c = Integer.parseInt(st.nextToken());
    		System.out.println(expec(a,b,c));
    	
    	
    }
   static long expec(long a, long b, long c) {
	   if(b==0) 	return 1;
	   if(b%2 == 1) {
		   return (a * expec(a, b-1,c)) % c;
	   }
	   long k = expec(a, b/2, c) %c;
	   return (k*k) %c;
   }

}

	 
