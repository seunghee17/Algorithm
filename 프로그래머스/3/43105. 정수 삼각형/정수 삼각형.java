import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int answer = 0;
        for(int i=1; i<height; i++) { //행
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j==i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else { //가운데 부분일 경우 
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
                }
            }
        }
        for(int i=0; i<triangle[height-1].length; i++) {
            answer = Math.max(answer, triangle[height-1][i]);
        }
        return answer;
    }
}