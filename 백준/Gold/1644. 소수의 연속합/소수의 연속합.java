import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	boolean[] sosu = new boolean[n+1];
    	sosu[0] = sosu[1] = true;
    	ArrayList<Integer> list = new ArrayList<>();
    	//소수에 해당하는 것은 false이다. 나머지는 true로 반환 
    	for(int i=2; i*i<=n; i++) {
    		if(!sosu[i]) {
    			for(int j=i*i; j<=n; j+=i) sosu[j] = true;
    		}
    	}
    	for(int i=1; i<=n; i++) {
    		if(!sosu[i]) {
    			list.add(i);
    		}
    	}
    	int start=0;
    	int end=0;
    	int sum=0;
    	int cnt=0;
    	while(end<list.size()) {
    		
    		if(sum==n) cnt++;
    		if(sum >= n) {
    			sum -= list.get(start++);
    		} else {
    			sum += list.get(end++);
    		}
    	}
    	if(!sosu[n]) cnt+=1;
    	System.out.println(cnt);
    }
  
}

	 