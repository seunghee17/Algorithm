import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] D = new long[1001];
		D[1] = 1;
		D[2] = 2;
		for(int i=3; i<=n; i++) {
			D[i] = -1;
		}
		
		System.out.println(topdown(n, D));
	}
	static long topdown(int v, long[] D) {
		if(D[v] != -1) {
			return D[v];
		}
		return D[v] = (topdown(v-1, D) + topdown(v-2, D)) % 10007;
	}

}
