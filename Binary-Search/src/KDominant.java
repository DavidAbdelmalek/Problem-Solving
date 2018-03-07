import java.util.*;
import java.io.*;

public class KDominant {
	static String s ;
	static HashSet<Integer>[]mapping;
	public static void main(String[]args) throws IOException{


		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		TreeSet<Character> tree= new TreeSet<Character>();

		for(int i =0 ; i < s.length();i++)tree.add(s.charAt(i));

		mapping=new HashSet[27];

		for(int i =  0 ;i < 27;i++)mapping[i]=new HashSet<Integer>();
		for(int i = 0 ; i < s.length();i++)mapping[s.charAt(i)-'a'].add(i);

		for(int i =0 ; i < 27 ; i++)System.out.println(mapping[i].toString());


		int min = (int) (1e5+5);
		int len = tree.size();
		if(s.length()==2&&tree.size()==2)System.out.println(2);
		else if(s.length()==1)System.out.println(1);else{

			for(int i = 0 ;i  < len;i++)//max 26
				min=Math.min(min, BS(tree.pollFirst()));
			System.out.println(min);
		}
	}
	static int BS(char c){
		int start = 0;
		int end = s.length()-1;
		int mid = 0;
		while(start<end){
			mid = start+(end-start)/2;
			if(valid(c,mid))end=mid;
			else start=mid+1;
		}
		return end;
	}
	static boolean valid(char c,int len){
		int start= 0;
		int end = s.length();
		HashSet<Integer>map = mapping[c-'a'];
		while(true){
			if(start+len<=len){
				
			}
			else break;
		}

		return true;
	}
}