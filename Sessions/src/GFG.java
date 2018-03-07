/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class GFG {
    static long[][] memo;
    static int n;
    static int arr[];
	public static void main (String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder("");
	    int T= sc.nextInt();
	    while(T-->0){
	      
	        n = sc.nextInt();
	        arr = new int [n];
	        for(int i =  0 ; i < n ; i++)
	            arr[i]=sc.nextInt();
	        memo = new long[n][n];

	        for(int i = 0 ; i < n ; i++)
	        	Arrays.fill(memo[i], -1);
	        
	        
	        if(n==0)
	        	sb.append(0);
	        	else
	        		sb.append(dp(0,0)+"\n");
	            
	    }
	    System.out.println(sb);
	}
	static long dp(int index,int prev){
	    if(index==n)
	        return 1;
	   
	   if(memo[index][prev]!=-1)
	        return memo[index][prev];
	        
	        
	   long dp1=0,dp2=0;
	        
	   dp1 = dp(index+1,prev);
	   
	   if(arr[index]>arr[prev])
	        dp2 = 1+dp(index+1,index);
	   else
		   if(arr[index]<arr[prev])
			   dp2=1+dp(index+1,prev);
	       
	   return memo[index][prev]=Math.max(dp1,dp2);
	}
}
