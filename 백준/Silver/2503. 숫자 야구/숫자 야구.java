import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[998];
		for(int i=123; i<=987; i++) {
			String num = String.valueOf(i);
			//이경우 다른 수를 계속해서 탐색해야 한다 
			if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') continue;
			if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) continue;
			check[i] = true;
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j=123; j<=987; j++) {
				if(check[j]) {
					int sn = 0; 
					int bn = 0;
					for(int o=0; o<3; o++) {
						char a_split = Integer.toString(num).charAt(o);
						for(int t=0; t<3; t++) {
							char b_split = Integer.toString(j).charAt(t);
							if(a_split == b_split && o == t) sn++;
							else if(a_split == b_split && o != t) bn++;
						}
					}
					if(sn==s && bn==b) check[j] = true;
					else check[j] = false;
				}
			}
		}
		int a=0; 
		for(int i=123; i<=987; i++) {
			if(check[i]) a++;
		}
		System.out.println(a);
		
 	}
	
	
	
	
}