import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static int n,m;
	static int[][] city;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	city = new int[n+1][n+1];
    	
    	for(int i=1; i<=n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=1; j<=n; j++) {
    			city[i][j] = Integer.parseInt(st.nextToken());
    			if(city[i][j] == 2) {
    				chicken.add(new int[] {i,j});
    			}
    			if(city[i][j] == 1) {
    				house.add(new int[] {i,j});
    			}
    		}
    	}
    	visited = new boolean[chicken.size()];
    	
    	saveChicken(0,0);
    	System.out.println(result);
    	
    }
    static void saveChicken(int cnt, int idx) {
    	if(cnt==m) {
    		int sum=0;
    		for(int i=0; i<house.size(); i++) {
    			int min = Integer.MAX_VALUE;
    			for(int j=0; j<chicken.size(); j++) {
    				if(visited[j]) {
    					int x = Math.abs(house.get(i)[0] - chicken.get(j)[0]);
    	    			int y = Math.abs(house.get(i)[1] - chicken.get(j)[1]);
    	    			min = Math.min(min, x+y);
    				}
    			}
    			sum += min;
    		}
    		result = Math.min(sum,result);
    		return;
    	}
    	
    	for(int i=idx; i<chicken.size(); i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			saveChicken(cnt+1, i+1);
    			visited[i] = false;
    		}
    	}
    	
    }
    static int count() {
    	int sum=0;
    	
    	for(int i=0; i<house.size(); i++) {
    		int min = Integer.MAX_VALUE;
    		for(int j=0; j<chicken.size(); j++) {
    			int x = Math.abs(house.get(i)[0] - chicken.get(j)[0]);
    			int y = Math.abs(house.get(i)[1] - chicken.get(j)[1]);
    			min = Math.min(min, x+y);
    		}
    		sum += min;
    	}
    	return sum;
    }
  
}