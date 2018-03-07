import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

public class uva10616 {
	static int n,q;
	static int []arr;
	static long memo[][][];
	static int count=0;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		while(true) {
			n=sc.nextInt();
			q=sc.nextInt();
			if(n==0&&q==0)
				break;
			arr= new int[n];
			for(int i = 0; i< n;i++)
				arr[i]=sc.nextInt();
			
			memo = new long[n+1][21][11];
			for(int i =0 ;i <= n ; i++)
				for(int j = 0 ; j<=20 ; j++)
					Arrays.fill(memo[i][j], -1);
			
			for(int i = 0 ,members,div; i < q ;i++) {
				members = sc.nextInt();
				div = sc.nextInt();
				System.out.println(members + " "+div);
				System.out.println(dp(0,members,div,0));
				
			}
			
		}
	
	}
	static long dp(int index,int members,int div,int sum) {
		System.out.println("INDEX "+index +" Members "+div  + " "+sum );
		if(sum%div==0&&sum>0) 
			return 1;
		if(members==0)		
			return 0;
		if(index==n||members<0)
			return 0;
		
		if(memo[index][members][div]!=-1) {
			return memo[index][members][div];
		}
		
		long taken=dp(index+1,members,div,sum+arr[index]);

		long ignore=dp(index+1,members-1,div,arr[index]);

	
		return memo[index][members][div]=taken+ignore;
	}
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
