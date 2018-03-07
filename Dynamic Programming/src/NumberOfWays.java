import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberOfWays {
	static int n ;
	static long[] memo;
	static long arr [];
	static long target;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n  =sc.nextInt();
		
		memo = new long [(int) (1e6+6)];
		Arrays.fill(memo, -1);
				
		arr = new long [n];
		
		
		long sum =0;
		
		for(int i = 0 ;i < n ; i++)sum+=arr[i]=sc.nextLong();
		
		if(sum%3!=0) {
			System.out.println(-1);
			return ;
		}
		target = sum/3;
		System.out.println(dp(0,0,0));
		
		
	}
	
	static  long dp (int index , long sum,int count) {
		System.out.println(index + " "+sum + " "+count);
		
		if(count>3)return 0;
		
		if(sum>target)return 0;
		
		if(index==n&&sum==target&&count==2)return 1;
		
		//means that the sum!= to the target
		if(index==n)return 0;
		
		if(memo[index]!=-1)return memo[index];

		long way1=0 , way2=0;
		
		
		if(sum==target) {
				way2 = dp(index+1,arr[index],count+1);
		}
		way1 = dp(index+1,arr[index]+sum,count);


		return memo[index]=way1+way2;
	}
}

