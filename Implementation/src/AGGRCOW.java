import java.io.*;
import java.util.*;

public class AGGRCOW {
	static int N;
	static int C;
	static int barns[];
	static int max;
	public static void main(String[]args){
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
			N=sc.nextInt();
			C=sc.nextInt();
			
			barns=new int[N];
			for(int i = 0 ;i <  N ;i++)barns[i]=sc.nextInt();
			Arrays.sort(barns);
			
			max=barns[N-1]-barns[0];
			
			System.out.println(BS());
		}
	}
	static int BS(){
		int start=0;
		int end=max;
		int mid=0;
		
		while(start<end){
			mid = start+(end-start+1)/2;
			if(valid(mid))start=mid;
			else end=mid-1;
		}
		if(valid(start))return start;
		else return end;
	}
	
	static boolean valid(int target){
		int cows=C-1;
		int prvCow=barns[0];
		for(int i =1 ,diff; i <N && cows>0;i++){
			diff=barns[i]-prvCow;
			if(diff>=target){
				cows--;
				prvCow=barns[i];
			}
		}
		return cows==0;
	}
}
