import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		int[] triangle = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<3; i++) {
			triangle[i] = Integer.parseInt(br.readLine());
			
		}
		if(triangle[0] + triangle[1] + triangle[2] == 180) {
			if(triangle[0]==60 && triangle[1] ==60 && triangle[2] == 60) {
				System.out.println("Equilateral");
			}
			else if(triangle[0] == triangle[1] || triangle[0] == triangle[2] || triangle[1] == triangle[2]) {
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}
			
		}else {
			System.out.println("Error");
		}
		
	}
	
}