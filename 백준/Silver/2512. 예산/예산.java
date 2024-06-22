import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 지방의 수 
		int[] arr= new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine()); //총 예산 
		Arrays.sort(arr);
		int min=0; 
		int max = arr[n-1];
		while(min<=max) {
			int mid = (min+max) /2;
			if(calcul(arr,mid) <= m) {
				//조건을 만족하는 경우
				min = mid+1;
			}
			else {
				//이 경우는 조건을 만족하지 못하는 경우이다 
				max = mid-1;
			}
				
		}
		System.out.println(max);
		
	}
	static long calcul(int[] arr, int mid) {
		long sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < mid) {
				sum += arr[i];
			} else {
				sum += mid;
			}
		}
		return sum;
	}
	
}