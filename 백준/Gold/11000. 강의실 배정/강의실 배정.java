import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static class Class {
		int start;
		int end;
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static class Solution implements Comparator<Class> {
		@Override
		public int compare(Class c1, Class c2) {
			if(c1.start == c2.start) {
				return c1.end-c2.end;
			} else {
				return c1.start - c2.start;
			}
		}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	Class[] c = new Class[n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		c[i] = new Class(start, end);
    	}
    	Arrays.sort(c, new Solution());
    	
    	pq.offer(c[0].end);
    	
    	
    	for(int i=1; i<n; i++) {
    		if(pq.peek() <= c[i].start) {
    			pq.poll();
    		}
    		pq.offer(c[i].end);
    	}
    	System.out.println(pq.size());
    }
   
}
  