import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static boolean[] visited;
	static int n, cnt=0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	visited = new boolean[n];
    	Egg[] list = new Egg[n];
    	for(int i=0; i<n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int d = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		list[i] = new Egg(d,w);
    	}
    	crack(0,list);
    	System.out.println(cnt);
    	
    }
    
    static void crack(int depth, Egg[] list ) {
    	if(depth==n) {
    		int sum=0;
    		for(int i=0; i<list.length; i++) {
    			if(list[i].durability <= 0)
    				sum++;
    		}
    		cnt = Math.max(sum, cnt);
    		return;
    	}
    	if(list[depth].durability >0) { //현재 손에든 계란 깨지지 않았다 
    		boolean exist = false;
    		for(int i=0; i<n; i++) {
    			if(depth == i) continue; //손에 든 계란과 같은 인덱스 선택할 경우 배제하기 위해 
    			if(list[i].durability < 0) continue; //선택한 계란이 깨져있다면 배제 
    			exist = true;
    			list[depth].durability -= list[i].weight;
    			list[i].durability -= list[depth].weight;
    			crack(depth+1, list);
    			
    			//원복한다 백트랙킹
    			list[depth].durability += list[i].weight;
    			list[i].durability += list[depth].weight;
    		}
    		if(!exist) { //칠 계란이 없다 
    			crack(depth+1, list);
    		}
    	} else {
    		crack(depth+1, list);
    	}
    }
    
  
}

class Egg {
	int durability;
	int weight;
	
	public Egg(int d, int w) {
		this.durability = d;
		this.weight = w;
	}
}
