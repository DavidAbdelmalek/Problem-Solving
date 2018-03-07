import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10496 {
	static int memo[][];
	static int dist[][];
	static int x[];
	static int y[];
	static int n;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int TC=sc.nextInt();
		while(TC-->0) {
			memo=new int[11][1<<11];
			dist=new int [11][11];
			x=new int[11];
			y=new int[11];
			sc.nextLine();
			x[0]=sc.nextInt();
			y[0]=sc.nextInt();
			n=sc.nextInt();
			
			for(int i=1 ; i<=n;i++) {
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			
			for (int i = 1; i <= n; i++)  // build distance table
			      for (int j = 0; j < n; j++) 
			        dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]); // Manhattan distance
			      
			for(int i = 0 ; i < 11 ;i++) 
				Arrays.fill(memo[i], -1);
	
		    pw.printf("The shortest path has length %d\n", tsp(0, 1)); // DP-TSP

		}
		
		pw.flush();
		pw.close();
	}
	
	//you have to consider the one that you stand in 
	//you want to take 4 pearls so you will have 4 bits+ the one that you stand over and will be your destination.
			
		static  int  tsp(int pos,int bitmask) {
			 if (bitmask == (1 << (n + 1)) - 1)
				 return dist[pos][0]; // return trip to close the loop
			 
			  if (memo[pos][bitmask] != -1)
			    return memo[pos][bitmask];
			  
			  int ans = 2000000000;

			  for (int nxt = 1; nxt <= n; nxt++) {
				  if(nxt!=pos&&(bitmask & (1 << nxt))==0)
					  ans = Math.min(ans, dist[pos][nxt] + tsp(nxt, bitmask | (1 << nxt)));
				  
			  }
			  return memo[pos][bitmask]=ans;	
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
