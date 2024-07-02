
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String a = br.readLine(); //yeshowmuchiloveyoumydearmotherreallyicannotbelieveit
    	String b = br.readLine();
    	String answer = br.readLine();
    	int[] table = makeTable(answer);
    	String result = "NO";
    	if(kmp(a,answer,table) && kmp(b, answer, table)) {
    		result = "YES";
    	}
    	System.out.println(result);
    } 
    
    static int[] makeTable(String str) {//부분일치 테이블을 생성 
    	//howmuchiloveyoumydearmother
    	int[] table = new int[str.length()];
    	int idx=0;
    	for(int i=1; i<table.length; i++) {
    		while(idx>0 && str.charAt(i) != str.charAt(idx)) { //일치하지 않는 부분이 생기면 다음과 같이한다 
    			idx = table[idx-1];
    		}
    		if(str.charAt(idx) == str.charAt(i)) { //일치한다면 
    			table[i] = ++idx;
    		}
    	}
    	return table;
    }
    
    static boolean kmp(String parent, String target, int[] table) {
    	int idx = 0;
    	for(int i=0; i<parent.length(); i++) {
    		while(idx>0 && parent.charAt(i) != target.charAt(idx)) {
    			idx = table[idx-1];
    		}
    		if(parent.charAt(i) == target.charAt(idx)) {
    			if(idx == target.length()-1) {//target의 마지막 까지 도달시 target문자열이 parent 문자열 속에 있음을 확인함 
    				return true;
    			} else {
    				idx++;
    			}
    		}
    	}
    	return false;
    }

}
                   
	 