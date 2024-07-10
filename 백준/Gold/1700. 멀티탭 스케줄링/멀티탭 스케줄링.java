
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int plug = Integer.parseInt(st.nextToken());
    	int elec = Integer.parseInt(st.nextToken());
    	int[] arr = new int[elec];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<elec; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	boolean[] use = new boolean[101]; //플러그임 
    
    	int cnt=0;
    	int idx=0;
    	int put=0; //현재 꼽힌 플러그의 개수를 나타내는 것 
    	while(idx<elec) {
    		int temp = arr[idx];
    		if(!use[temp]) { //현재 이 전자기기는 콘서트가 꼽히지 않았다 
    			if(put < plug) { //꽂을 공간이 있다 
    				use[temp] = true;
    				put++; //콘서트 꼽았으므로 
    			} else {//꼽을 공간이 없다 
    				ArrayList<Integer> list = new ArrayList<>();
    				for(int i=idx; i<elec; i++) {
    					if(use[arr[i]] && !list.contains(arr[i])) {
    						list.add(arr[i]);
    					}
    				}
    				if(list.size() != plug) { //나중에 사용 중복되지 않은것을 제거하고 그자리에 꼽겠다 
    					for(int j=0; j<use.length; j++) {
    						if(use[j] && !list.contains(j)) { //나중에도 안쓰일 플러그 
    							 use[j] = false;
    							 break;
    						}
    					}
    				} else { //현재 꽂혀있는 모든 콘센트가 나중에 사용될 경우 
    					int remove = list.get(list.size()-1);
    					use[remove] = false;
    					
    				}
    				use[temp] = true;
    				cnt++;
    			}
    		}
    		idx++;
    		
    	}
    	
    	System.out.println(cnt);
    	
    }
   
}