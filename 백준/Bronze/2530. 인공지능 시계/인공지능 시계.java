import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		int[] time = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int total = Integer.parseInt(br.readLine());
		
		for(int i=0; i<3; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		
		}
		int h = total/60/60;
		int m = total/60%60;
		int s = total%60%60;
		
		time[0] += h;
		time[1] += m;
		time[2] += s;
	
	
		if(time[2] >= 60) {
			time[1] += time[2]/60;
			time[2] %= 60;
		}
		if(time[1] >= 60) {
			time[0] += time[1] /60;
			time[1] = time[1] % 60;
		}
		if(time[0] >= 24) {
			time[0] %= 24;
		}
		for(int i=0; i<3; i++) {
			System.out.print(time[i] + " ");
		}
		
	}
	
}
