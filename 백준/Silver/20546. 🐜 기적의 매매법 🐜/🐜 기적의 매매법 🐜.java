
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int cash= Integer.parseInt(br.readLine());
    	int[] chart = new int[14];
    	StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	for(int i=0; i<14; i++) {
    		chart[i] = Integer.parseInt(st.nextToken());
    	
    	}
    	int resulta = BNP(cash, chart);
    	int resultb = TIMING(cash, chart);

    	if(resulta > resultb) {
    		System.out.println("BNP");
    	} else if(resulta == resultb) {
    		System.out.println("SAMESAME");
    	} else {
    		System.out.println("TIMING");
    	}
    }
    static int BNP(int cash, int[] chart) {
    	int cnt=0;
    	for(int i=0; i<14; i++) {
    		
    		if(cash >= chart[i]) {
    			int sum=0;
    			sum = cash/chart[i];
    			cash -= chart[i] * sum;
    			cnt+=sum;
    			
    		} continue;
    	}
    	return (cnt * chart[13]) + cash;
    }
    
    static int TIMING(int cash, int[] chart) {
    	int cnt=0; //가지고있는 주식의 수 
    	int up=0;  //상향
    	int down =0; //하향 
    	for(int i=1; i<14; i++) {
    		if(chart[i] > chart[i-1]) {
    			//상향 
    			up++;
    			down=0;
    		} else if(chart[i] < chart[i-1]) {
    			down++;
    			up=0;
    		}
    		
    		if(up>=3) {
    			cash += cnt * chart[i];
    			cnt=0;	
    			
    		}
    		if(down>=3 && cash >= chart[i]) {
    			//사야한다 
    			int buy=0;
    			buy=cash/chart[i]; //3,3
    			cash -= chart[i]*buy; //3,0
    			cnt+=buy; //3,6
    		}
    	}
    	return (chart[13] * cnt)+cash;
    }
    
  
}

	 
