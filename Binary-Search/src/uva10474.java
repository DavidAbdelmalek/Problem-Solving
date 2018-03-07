import java.io.*;
import java.util.*;

public class uva10474 {
	static int n,q;
	static int []arr;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T=0;
		StringBuilder sb =  new StringBuilder("");
		while(true) {
		
			n=sc.nextInt();q=sc.nextInt();T++;
			if(n==0&&q==0)break;
	//		sc.nextLine();
			arr = new int[n+1]; 
			for(int i = 1 ; i <= n ; i++)arr[i]=sc.nextInt();
			Arrays.sort(arr);
			sb.append("CASE# "+T+":\n");
			for(int i = 0,num,at; i<q;i++) {
				num=sc.nextInt();
				at=BS(num);
				if(at<=n&&arr[at]==num) sb.append(num+" found at "+at+"\n");
				else sb.append(num+" not found\n");
			}
		}
		System.out.print(sb);
	}
		static int BS(int target) {
			int st = 0 , end = n,mid=0;
			while(st<=end) {
				mid=(st+end)/2;
				if(arr[mid]>=target)end=mid-1;
				else st=mid+1;
			}
			return st;
		}
	
	
	static class Scanner 
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
