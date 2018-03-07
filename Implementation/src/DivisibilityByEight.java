import java.util.*;
import java.io.*;

public class DivisibilityByEight {
	static String num;
	static Map<Integer,Boolean> map;
	static String out="";
	static int dp[][];
	
	public static void main(String[]args) throws IOException{

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

		num = bf.readLine();
		map = new HashMap<Integer,Boolean>();
		dp = new int[103][8];
		
		if(num.length()==1){
			if(isDivisble(num)){
				System.out.println("YES");
				System.out.println(num);
			}else 
				System.out.println("NO");
		}else{
			System.out.println(dp(num,num.length()-1)?"YES":"NO");
			System.out.println(out);
		}
	}
	static boolean isDivisble(String s ){
		int temp=0;
		if(s.length()<3)
			temp = Integer.parseInt(s);
		else temp = Integer.parseInt(s.substring(s.length()-3, s.length()));
		return temp%8==0;
	}
	
/*	static boolean dp(String s,int pointer){
		int length=s.length();
		if(length==1)return isDivisble(s);

		if(pointer==-1)return isDivisble(s);

		if(map.containsKey(length)){
			return map.get(length);

			
		}

		String willTaken =s.substring(0, pointer)+s.substring(pointer+1, s.length()); 

		boolean taken=dp(willTaken,pointer-1);

		if(taken){
			if(out.length()==0)
				out+=willTaken;
			map.put(length, true);
			return true;
		}
		boolean notTaken=dp(s,pointer-1);

		if(notTaken){
			if(out.length()==0)
				out+=s;
			map.put(length, true);
			return true;
		}
		
		map.put(length, false);
		return false;
	}
*/}
