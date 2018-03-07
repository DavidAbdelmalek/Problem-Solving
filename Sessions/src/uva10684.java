import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class uva10684 {
	static int n;
	static int []arr;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder("");
		while(true) {
			n = sc.nextInt();
			if(n==0)break;
			
			arr =new int[n];
			for(int i =0 ; i < n ; i++)arr[i]=sc.nextInt();
			
			int sum=0;
			int ans=0;
			
			for(int i = 0 ; i < n ; i++) {
				sum+=arr[i];
				ans = Math.max(ans, sum);
				if(sum<0)
					sum=0;
			}
			if(ans <=0)sb.append("Losing streak.\n");
			else
			sb.append("The maximum winning streak is "+ans+".\n");
		}
		pw.print(sb);
		pw.flush();
		pw.close();
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
