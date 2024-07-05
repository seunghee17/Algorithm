import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken()); //접시의 수 
    	int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수 
    	int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시
    	int c = Integer.parseInt(st.nextToken()); //준 쿠폰에 적힌 
    	
    	int[] chobab = new int[n+k-1];
    	for(int i=0; i<n; i++) {
    		chobab[i] = Integer.parseInt(br.readLine());
    	}
    	for(int i=n; i<n+k-1; i++) {
    		chobab[i] = chobab[i-n];
    	}
    	int[] eaten = new int[d+1]; //먹은 초밥의 종류를 체크하기 위해서 
    	int max=1; //쿠폰 제공을 먹었다고 친다 
    	eaten[c] +=1;
    	
    	int start =0;
    	//회전하지 않았을때 
    	for(int i=start; i<k; i++) {
    		if(eaten[chobab[i]] ==0) {
    			max++;
    		}
    		//이미 먹은 종류라면 
    		eaten[chobab[i]] += 1;
    	}
    	start =0;
    	int end=k; //이제 슬라이딩 윈도우로 계산할거임 
    	int result = max;
    	for(int i=end; i<chobab.length; i++) {
    		eaten[chobab[start]] -= 1;
    		
    		//옮긴 윈도우에도 동일한 종류가 있을 수도 있다 
    		if(eaten[chobab[start]] == 0) result-=1;
    		if(eaten[chobab[i]] == 0) result+=1;
    		//새로운 종류의 초밥을 먹었다 
    		eaten[chobab[i]] +=1;
    		max = Math.max(max, result);
    		start++;
    	}
    	System.out.println(max);
    	
    } 
    
  
   
}