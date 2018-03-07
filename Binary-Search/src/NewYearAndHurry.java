import java.util.Scanner;


public class NewYearAndHurry {
	static int dp[];
	static int k;
	static int n;
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		n =sc.nextInt();
		k = 240-sc.nextInt();
		dp = new int[n+1];
		int sum=0;
		for(int i =1  ; i <= n;i++)dp[i]=sum+=5*i;
		if(k<5)System.out.println(0);
		else System.out.println(BS());
		
	}
	static int BS(){
		int start = 1; 
		int end = n;
		int mid =0;
		while(start<end){
			mid = start+(end-start+1)/2;
			if(k-dp[mid]>0)start=mid;
			else if(k-dp[mid]<0)end=mid-1;
			else return mid;
		}
		return start;
	}
}
