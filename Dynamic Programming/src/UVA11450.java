import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11450 {
	static int memo[][];
	static int Money;
	static int C;
	static int price [][];
	static StringBuilder sb= new StringBuilder("");
	public static void main(String[]args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			Money =sc.nextInt();
			C =sc.nextInt();
			
			memo=new int[201	][20];
			for(int i = 0 ; i < 201 ; i++)Arrays.fill(memo[i], -1);
			
			price =new int[25][25];
			for(int i = 0,g ; i< C;i++) {
				g=sc.nextInt();
				price[i][0]=g;
				for(int j = 1 ;j<=g;j++)price[i][j]=sc.nextInt();	
			}
			
			int ans = dp(0,Money);
			if(ans==-1)sb.append("no solution");
			else sb.append(ans);
			if(T!=0)sb.append("\n");
			
	}
		pw.println(sb);
		pw.flush();
		pw.close();
		
}
	static int dp(int i,int M) {
		if(M<0)return -10000000;
		if (i == C) return Money-M; // what you have spent.
		if(memo[M][i]!=-1)return memo[M][i];
		
		int ans = -1;
		for(int j = 1; j  <= price[i][0] ; j++)ans=Math.max(ans,dp(i+1,M-price[i][j]));
 		return memo[M][i]=ans;
	}
}