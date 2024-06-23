
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine()); //수첩1의 정수의 갯수
			int[] arr1 = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine()); //수첩2의 정수의 갯수
			int[] arr2 = new int[m];
			
 			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			StringBuilder sb = new StringBuilder();
			Arrays.sort(arr1);
			for(int i=0; i<m; i++) {
			
				int min = 0;
				int max = n-1;
				while(min<max) {
					int mid = (min+max) /2;
					if(arr1[mid] < arr2[i]) {
						min = mid+1;
					} else {
						max = mid;
					}
				}
				
				if(arr1[min] != arr2[i]) {
					sb.append('0').append('\n');
					
				} else {
					sb.append('1').append('\n');
					
				}
				
			}
			System.out.print(sb);
			
		}
		
	}
	
}
