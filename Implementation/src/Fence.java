import java.util.*;
import java.io.*;

public class Fence {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		int k  =sc.nextInt();
		k--;
		int [] arr=new int[n];
		int [] dp=new int[n];
		int m=0;
		for(int i = 0 ; i < n ; i++)dp[i]=m+=arr[i]=sc.nextInt();
		
		long min=(long) (20*1e6);
		long calc=0;
		int index=0;
		for(int  i = 0 ; i < n-k;i++){
			calc=dp[i+k]-dp[i]+arr[i];
			if(min>calc){
				min=calc;
				index=i;
			}
		}
		System.out.println(index+1);
	}
}
