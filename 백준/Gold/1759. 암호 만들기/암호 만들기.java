import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int l;
	static int c;
	static List<Character> hubo = new ArrayList<Character>();
	static List<Character> chogun = new ArrayList<Character>();
	static Character[] dap;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	l = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	dap= new Character[c];
    	String s = br.readLine();
    	s = s.replace(" ", ""); 
    	for(int i=0; i<c; i++) {
    		hubo.add(s.charAt(i));
    	}
    	
    	Collections.sort(hubo);
    	chogun = Arrays.asList('a', 'e', 'i', 'o', 'u');
    	calcul(0,0);
    	System.out.println(sb);
    }
    
    static void calcul(int idx, int depth) {
    	if(depth==l && isvalid(dap)) {
    		for(int i=0; i<l; i++) {
    			sb.append(dap[i].toString());
    		}
    		sb.append('\n');
    		return;
    	}
    	if(idx>c-1) return;
    	for(int i = idx; i<c; i++) {
    		dap[depth] = hubo.get(i);
    		calcul(i+1, depth+1);
    	
    	}
    }
    
    static boolean isvalid(Character[] dap) {
    	int a=0;
    	int b=0;
    	
    	for(int i=0; i<l; i++) {
    		//모음이다 
    		if(chogun.contains(dap[i])) {
    			a++;
    		} else {
    			b++;
    		}
    	}
    	if(a>=1 && b>=2) {
    		return true;
    	} else {
    		return false;
    	}
    }
    

}