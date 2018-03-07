import java.io.*;
import java.util.*;

public class Number_Of_Ways {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		long arr [] =new long[n];
		long sum = 0;
		for(int i = 0;i<n;i++) 
			sum+=arr[i]=sc.nextInt();
		if(sum%3!=0) {
			System.out.println(0);
			return;
		}
		long target=sum/3;
		int out=0;
		long temp;
		int i,j;
		for( i= 0 ;i<n;i++) {
			temp=arr[i];
			for( j = i+1;j<=n;j++) {
				//System.out.println(i +" " +arr[j]+" "+arr[i]+" "+temp);
				if(temp==target)out++;
				if(j==n)break;
				if(arr[j]+temp>target)break;
				temp+=arr[j];
				
			}
			//if(temp==target)out++;
		//	System.out.println("OUT AT "+j +" "+out);
			i=j-1;
		}
		//System.out.println(Arrays.toString(arr));
		System.out.println(out);
		System.out.println(Math.max(0,out-3+1));
			
		
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
