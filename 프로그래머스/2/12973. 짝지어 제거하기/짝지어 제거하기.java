import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int result =0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c) {
                    stack.pop();
                    result = 1;
                } else {
                    stack.push(c);
                }
            }
        }
        if(!stack.isEmpty()) result = 0;
            
        return result;
    }
    
}