
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n,m,t;
	static boolean isSameExist = false;
	static int[][] circle;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	
	static void check(int y, int x, int value) { //매개변수 value 값 기준으로 주변값들만 같은지 비교휴 바꿔준다 
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			//원판 밖으로 나갈때 처리 
			if(nx<0) nx = m-1;
			else if(nx>=m) nx=0;
			else if(ny<0 || ny >= n) continue;
			if(circle[ny][nx] == value) {
				isSameExist = true;
				circle[ny][nx] =0;
				check(ny, nx, value);
			}
		}
	}
	
	static void rotate(int c, int d, int k) {
		int temp[] = new int[m];
    	if(d==0) {
    		for(int i=0; i<m; i++) {
        		int next = (i+k) % m;
        		
        		temp[next] = circle[c][i];
        	}
        	
    	} else {
    		for (int i = 0; i < m; i++) {
                int next = (i-k+m) % m;
                temp[next] = circle[c][i];
            }
    	}
    	for(int i=0; i<m; i++) {
    		circle[c][i] = temp[i];
    	}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        circle = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                circle[i][j] = Integer.parseInt(st.nextToken());
               
            }
        }
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int i=0; i<n; i++) {
            	if((i+1) % x ==0) rotate(i,d,k);
            }
            boolean isExist = false;
            for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
            		isSameExist = false;
            		if(circle[i][j] != 0) check(i,j,circle[i][j]);
            		if(isSameExist) {
            			isExist = true;
            			circle[i][j] = 0; //자기자신도 이때 바뀐다 
            		}
            	}
            }
            if(!isExist) { //평균값으로 조작해야함 
            	double sum =0; 
            	int num=0;
            	for(int i=0; i<n; i++) {
            		for(int j=0; j<m; j++) {
            			if(circle[i][j] != 0) {
            				sum += circle[i][j];
            				num++;
            			}
            		}
            	}
            	double avg = sum/num;
            	for(int i=0; i<n; i++) {
            		for(int j=0; j<m; j++) {
            			if(circle[i][j] != 0) {
            				if(avg > circle[i][j]) circle[i][j]++;
            				else if(avg < circle[i][j]) circle[i][j]--;
            			}
            		}
            	}
            }
        }
        int result = 0;
        for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			result += circle[i][j];
    		}
    	}
        System.out.println(result);
    }
    	
    	
  }
    

