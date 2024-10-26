import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int max_garo = 0;
        int max_sero = 0;
        for(int i=0; i<len; i++) {
            int garo = Math.max(sizes[i][0], sizes[i][1]);
            int sero = Math.min(sizes[i][0], sizes[i][1]);
            max_garo = Math.max(garo, max_garo);
            max_sero = Math.max(sero, max_sero);
        }
        return max_garo * max_sero;
    }

}