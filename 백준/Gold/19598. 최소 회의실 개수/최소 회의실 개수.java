import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static class Meeting {
		int start;
		int end;
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static class Solution implements Comparator<Meeting> {
		@Override
		public int compare(Meeting m1, Meeting m2) {
			if(m1.start == m2.start) {
				return m1.end - m2.end;
			} else {
				return m1.start - m2.start;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Meeting[] arr = new Meeting[n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		arr[i] = new Meeting(s,e);
    	}
    	Arrays.sort(arr, new Solution());
    	//ArrayList<Meeting> list = new ArrayList<>();
    	PriorityQueue<Integer> pq = new PriorityQueue();
    	pq.offer(arr[0].end);
    	for(int i=1; i<n; i++) {
    		if(arr[i].start >= pq.peek()) {
    			pq.poll();
    		}
    		pq.offer(arr[i].end);
    	}
    	System.out.println(pq.size());
    }
    
   
}