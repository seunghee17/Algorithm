import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	static int N;
	static int[] arr1;
 	public static void main(String[] args) throws IOException{

 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		N = Integer.parseInt(br.readLine());
 		arr1 = new int[N];
 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 		StringBuilder sb = new StringBuilder();
 		
 		for(int i=0; i<N; i++) {
 			arr1[i] = Integer.parseInt( st.nextToken());
 		}
 		int M = Integer.parseInt(br.readLine());
 		int[] arr2 = new int[M];
 		StringTokenizer sr = new StringTokenizer(br.readLine(), " ");
 		for(int i=0; i<M; i++) {
 			arr2[i] = Integer.parseInt( sr.nextToken());
 		}

 		Arrays.sort(arr1);
 		for(int i=0; i<M; i++) {
 			sb.append(upperBound(arr2[i]) - lowerBound(arr2[i])).append(' ');
 		}
 		System.out.print(sb);
 		
	}	

 	static int lowerBound(int m) {
 		
 		int min = 0;
 		int max = N;

 		while(min < max) {
 			int mid = (min+max) / 2;
 			if(m <= arr1[mid]) {
 				max = mid;
 			} else {
 				min = mid+1;
 			}
 		}
 		return min;
	
}	
 	static int upperBound(int m) {
 		int min = 0;
 		int max = N;

 		while(min < max) {
 			int mid = (min+max) / 2;
 			if(m < arr1[mid]) {
 				max = mid;
 			} else {
 				min = mid+1;
 			}
 		}
 		return min;
 	}
}
