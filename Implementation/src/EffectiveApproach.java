import java.io.*;
import java.util.*;

public class EffectiveApproach {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int [n+1];
		
		HashMap<Integer,Integer>map1 = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer>map2 = new HashMap<Integer,Integer>();
		
		for(int i = 1 ;i  <= n ; i++)map1.put(arr[i]=sc.nextInt(),i);
		
		
		int pointer1 =1;
		for(int i = n ; i>=1;i--){
			map2.put(arr[i], pointer1++);
		}
		
		int q = sc.nextInt();
		long vasya=0,patya=0;
		long vasyas[]=new long[n+1];
		long patyas[]=new long[n+1];
		
		for(int i = 0 ,query; i < q ; i++){
			query = sc.nextInt();
			if(vasyas[query]==0)vasya+=vasyas[query]=map1.get(query);
			else vasya+=vasyas[query];
			if(patyas[query]==0)patya+= patyas[query]=map2.get(query);
			else patya+=patyas[query];
		
		}
		System.out.println(vasya+" "+patya);
	}
}
