import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva787 {
	static ArrayList<BigInteger> list;
	static BigInteger memo[];
	static int n;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s;
		StringTokenizer st;
		while(!(s=sc.nextLine()).equals("")) {
			st = new StringTokenizer(s);
			list = new ArrayList<BigInteger>();
			BigInteger sum =new BigInteger("1");
			BigInteger num;
			for(int i = 0 ; i<s.length();i++) {
				num = new BigInteger(st.nextToken());
				if(num.equals(new BigInteger("-999999")))break;
				list.add(num);
			}
			n = list.size();
			memo=new BigInteger[n];
			Arrays.fill(memo, new BigInteger("-1"));
			
			System.out.println(dp(n-1));
		}
		
	}
	static BigInteger dp(int index) {
	
		if(index<0)
			return BigInteger.ONE;
	
		if(!(memo[index].equals(new BigInteger("-1"))))
			return memo[index];
		
		BigInteger bg1 = list.get(index).multiply(dp(index-1));
		
		System.out.println("BG1 "+bg1.toString());

		
		return memo[index]=bg1.max(BigInteger.ONE);
		
		
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
	