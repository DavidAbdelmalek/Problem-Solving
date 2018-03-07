import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10626 {
	static int c;
	static int memo[][];
	
	public static void main(String[]args) throws IOException {
		Scanner sc =new Scanner(System.in);
//		int T = sc.nextInt();

		memo = new int[151*8][651];
	
		for(int i = 1 ; i <= 150;i++)
			Arrays.fill(memo[i], -1);
		
	//	System.out.println(dp(16 ,1, 4, 1,31));
	//	System.out.println(dp(16,2,1,1,2+5+10));
		System.out.println(dp(20,200,3,0,215));
	}

static int dp(int rem,int coin1 ,int coin5 ,int coin10,long money){
	//	System.out.println(rem + " MONEY: "+money);
	if(rem==0)
		return 0;
	
	if(rem==money)
		return coin1+coin5+coin10;


	if(rem<0)
		return 100000000;
	
	if(memo[rem][coin1]!=-1) {
		return memo[rem][coin1];
	
	}
	int dp1=1000000,dp2=1000000,dp3=1000000;

//System.out.println("coin1 "+coin1 + " coin5 "+coin5 + " coin10 "+coin10);
	
	if(coin10>=1&&rem-10>=0)
		dp1 = 1+dp(rem-10,coin1,coin5,coin10-1,money-10);
	
	if(coin5>=1&&rem-5>=0)
		dp2 = 1+dp(rem-5,coin1,coin5-1,coin10,money-5);
	
	if(coin1>=1&&rem-1>=0)
		dp3 = 1+dp(rem-1,coin1-1,coin5,coin10,money-1);

	//System.out.println(dp1 + " "+dp2 + " "+dp3);
	return memo[rem][coin1]=Math.min(dp1,Math.min(dp2,dp3));

}	
static	class Scanner 
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

	public String next() throws IOException 
	{
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {return Integer.parseInt(next());}
	
	public long nextLong() throws IOException {return Long.parseLong(next());}

	public String nextLine() throws IOException {return br.readLine();}
	
	public boolean ready() throws IOException {return br.ready();}


}

}

