import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static boolean[] isEurekaNumber = new boolean[1001];
	
	public static void preprocess() {
		//1.K보다 작은 삼각수를 모두 구한다
		int[] triangleNumbers = new int[50];
		int triangleNumberCount = 0;
		
		int a =0;
		int i = 1;
		while(a<1000) {
			a = i * (i+1)/2;
			if(a >= 1000) break;
			triangleNumbers[triangleNumberCount++] = a;
			i++;
		}
		//구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다 
		boolean[] isSumOfTriangle = new boolean[1001];
		for(int j=0; j < triangleNumberCount; j++) {
			for(int k=0; k < triangleNumberCount; k++) {
				int sum = triangleNumbers[j] + triangleNumbers[k];
				if(sum < 1000) isSumOfTriangle[sum] = true; 
			}
		}
		for(int m=1; m<1000; m++) {
			if(!isSumOfTriangle[m]) continue;
			for(int l = 0; l<triangleNumberCount; l++) {
				int sum = m + triangleNumbers[l];
				if(sum <=1000) isEurekaNumber[sum] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		preprocess();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int K = Integer.parseInt(br.readLine());
			System.out.println(isEurekaNumber[K] ? "1" : "0");
		}
	}
 
}