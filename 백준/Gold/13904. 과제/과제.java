import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static class Assignment {
		int day;
		int time;
		
		Assignment(int day, int time) {
			this.day = day;
			this.time = time;
		}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	List<Assignment> list = new ArrayList<>();
    	int maxday = 0;
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int d = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		list.add(new Assignment(d,w));
    		maxday = Math.max(maxday, d);
    	}
    	int sum=0;
    	for(int i=maxday; i>0; i--) {
    		sum += getMax(list,i);
    	}
    	System.out.println(sum);
    }
    
    public static int getMax(List<Assignment> list, int now) { //현재의 날짜와 비교해서 가능한 값중 최대값을 가지고 온다
    	int idx=-1;
    	int result=0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).day >= now && result<list.get(i).time) {
    			idx=i;
    			result = list.get(i).time;
    		}
    		
    	}//지울 날짜를 찾았다 
    	if(result ==0) {
    		return 0; //현재 날자에서는 수행할 수 있는 과제가 없다 
    		
    	}
    	list.remove(idx);
    	return result;
    }
   
}