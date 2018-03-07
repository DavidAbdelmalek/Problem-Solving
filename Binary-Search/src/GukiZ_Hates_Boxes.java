import java.io.*;
import java.util.*;


public class GukiZ_Hates_Boxes {
	static int [] boxes;
	static int n;
	static int students;
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int students=sc.nextInt();
		boxes =new int [n];

		long sum=0;
		for(int i = 0; i< n ; i++)sum+=1l*(boxes[i]=sc.nextInt());

		if(sum<=students) {
			System.out.println(n+1);
			return ;
		}
		int seconds=0;

		for(int i = 0 ; i < n; i ++) {
			seconds++;
			seconds+=(boxes[i]/students);
			if(boxes[i]%students!=0)seconds++;
		}
		System.out.println(seconds);
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
