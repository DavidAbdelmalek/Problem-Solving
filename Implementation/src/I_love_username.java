import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class I_love_username {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		int worst,best;
		n--;
		int num;
		int out=0;
		worst=best=sc.nextInt();

		while(n-->0) {
			num=sc.nextInt();
			if(num<worst) {
				out++;
				worst=num;
			}
			else if(num>best)
			{
				out++;
				best=num;
			}

		}
		System.out.println(out);
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
