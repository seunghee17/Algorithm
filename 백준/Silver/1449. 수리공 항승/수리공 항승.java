import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int l = Integer.parseInt(st.nextToken());
    	int[] arr= new int[n];
    	st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	int i=0;
    	int cnt=0;
    	while(i<arr.length) {
    		double end = arr[i]-0.5 + l;
    		cnt++;
    		while(i<arr.length && arr[i] <= end) {
    			i++;;
    		}
    	}
    	System.out.println(cnt);
    }

}
