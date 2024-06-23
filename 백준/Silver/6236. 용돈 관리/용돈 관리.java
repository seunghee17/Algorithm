import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int[] arr;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); //n일동안사용할 금액이 주어진다 
		int m = Integer.parseInt(st.nextToken()); //m번만 통장에서 돈을 뺀다 
		int left = 0;
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(left < arr[i]) left = arr[i];
		}
		int right = 100000 * 10000;
		int count =0;
		while(left<=right) {
			//조건을 만족하더라도 가능한한 최솟값을 찾아야하기때문에 조건을 다음과 같이 정한 것이다
			int mid = (right+left) /2;
			if(m>=getWithdraw(mid)) {
				//최솟값을 구하는 것이기에 이때 저장시킴 
				//현재 인출금액이 크기때문에 줄여야한다 그러면 일수가 늘어난다 
				result = mid;
				right = mid-1;
				
			} else {
				
				//인출금액을 늘려야한다 
				left = mid+1; 
			}
		}
		System.out.println(result);
		
	}
	static int getWithdraw(int withdraw) {
		//첫날은 무조건 출금해야하기에 
		int count =1;
		int money = withdraw;
		for(int i: arr) {
			money -= i;
			if(money<0) {
				//남은 돈이 그날 하루를 생활하기에 부족함 
				count++;
				money = withdraw - i;
			}
		}
		return count;
	}
	
}
