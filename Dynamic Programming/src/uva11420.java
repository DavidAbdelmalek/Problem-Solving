import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class uva11420 {
	static int n;
	static int s;
	static long memo[][][];
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T =0;
		memo = new long [70][70][2];//n // s
		for(int i = 0; i< 70 ; i++)
			for(int j = 0; j<70 ; j++) {
				memo[i][j][0]=-1;
				memo[i][j][1]=-1;
			}
		StringBuilder sb = new StringBuilder("");
		
		while(true) {
			n = sc.nextInt();
			s = sc.nextInt();
			if(n<0)break;
			if(T>0)sb.append("\n");
			sb.append(dp(n,s,1));
			T++;
		}
		System.out.println(sb);
	
		
		///Handling when secure equals to ZERO.!
		
	//	System.out.println(memo[7][0]);
		
	}
	static long dp (int index, int secure , int prev) {
		if(index ==0 )
			if(secure==0) 
				return 1 ;
			else 
				return 0;
		
	//we cann't set secure to ==0 because we have to make sure that all the n is being distrubited among secured lock and unsecured ones.
	// why not zero because  it is zero based.
		if(secure < 0)
			return 0;

		if(memo [index][secure][prev]!=-1)
			return memo[index][secure][prev];

		long ans;
		if(prev == 1) //locked
			ans = dp(index-1,secure-1,1)	+ 	dp(index-1,secure,0);
		else
			ans = dp(index-1,secure,1)	+ 		dp(index-1,secure,0);
		
		return memo[index][secure][prev]=ans;
		
	}
}

