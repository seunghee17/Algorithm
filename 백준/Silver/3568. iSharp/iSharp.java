import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<String> list = new ArrayList<>();
		//입력으로 주어진 변수들 모두 list에 저장한다 
		while(st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		for(int i=0; i<list.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<list.get(i).length(); j++) {
				if(list.get(i).charAt(j) == ',' || list.get(i).charAt(j) == ';') continue;
				sb.append(list.get(i).charAt(j));
			}
			list.set(i, sb.toString());
		}
		String main = list.get(0);
		//메인 변수형을 제외한 변수들을 모두 조작할것임 모두 역순으로 바꾸기 
		
		
		for(int i=1; i<list.size(); i++) {
			
			//각 원소를 변수형과 변수명으로 분리할것
			String[] result = divide(list.get(i)); //result[0] =a ///// result[1] = *[]&
			
			StringBuilder sb = new StringBuilder();
			if(result[1].isEmpty()) {
				sb.append("");
			}else {
				
			}
			for(int j=result[1].length()-1; j>=0; j--) {
				if(result[1].charAt(j) == ']') {
					sb.append("[]");
				} else if(result[1].charAt(j) == '[') continue;
				else {
					sb.append(result[1].charAt(j));
				}
			}
			sb.append(" ").append(result[0]).append(";");
			list.set(i, sb.toString());
		} //모두 역순으로 바꿔주었다 
		for(int i=1; i<list.size(); i++) {
			System.out.println(main + list.get(i));
		}
	}
	static String[] divide(String a) {//a*[]&
		String[] result = new String[2];
		StringBuilder sb1 = new StringBuilder(); //변수명 
		StringBuilder sb2 = new StringBuilder(); //변수형 
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != '[' && a.charAt(i) != ']' && a.charAt(i) != '*' && a.charAt(i) != '&') {
				//변수명임 
				sb1.append(a.charAt(i));
			} else {
				sb2.append(a.charAt(i));
			}
		}
		result[0] = sb1.toString();
		result[1] = sb2.toString();
		return result;
	}
	
	
}