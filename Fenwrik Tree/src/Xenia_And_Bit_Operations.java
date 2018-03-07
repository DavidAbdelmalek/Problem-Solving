import java.io.*;
import java.util.*;

public class Xenia_And_Bit_Operations {
	public static void main(String[]args) throws IOException {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt(); int query = sc.nextInt(); int size =(int) Math.pow(2, n);
		FenwickTree tree = new FenwickTree(size);
		for(int i = 0,in ; i < size;i++) {
			in = sc.nextInt();
			tree.point_update(i+1, in);
		}
		System.out.println(tree.rsq(n+2));
		System.out.println(Arrays.toString(tree.ft));

		for(int i = 0 ; i < query;i++) {
			tree.point_update(sc.nextInt(), sc.nextInt());
			System.out.println(tree.rsq(n+2));

		}


	}


	static class FenwickTree { // one-based DS

		int n;
		int[] ft;

		FenwickTree(int size) { n = size; ft = new int[n+1]; }

		int rsq(int b) //O(log n)
		{
			int sum = 0;
			while(b > 0) { sum += ft[b]; b -= b & -b;}		//min?
			return sum;
		}

		int rsq(int a, int b) { return rsq(b) - rsq(a-1); }	

		void point_update(int k, int val)	//O(log n), update = increment
		{
			while(k <= n) { ft[k] += val; k += k & -k; }		//min?
		}

		int point_query(int idx)	// c * O(log n), c < 1
		{
			int sum = ft[idx];
			if(idx > 0)
			{
				int z = idx ^ (idx & -idx);
				--idx;
				while(idx != z)
				{
					sum -= ft[idx];
					idx ^= idx & -idx;
				}
			}
			return sum;
		}

		void scale(int c) {	for(int i = 1; i <= n; ++i)	ft[i] *= c;	}

		int findIndex(int cumFreq)
		{
			int msk = n;
			while((msk & (msk - 1)) != 0)
				msk ^= msk & -msk;			//msk will contain the MSB of n

			int idx = 0;
			while(msk != 0)
			{
				int tIdx = idx + msk;
				if(tIdx <= n && cumFreq >= ft[tIdx])
				{
					idx = tIdx;
					cumFreq -= ft[tIdx];
				}
				msk >>= 1;
			}
			if(cumFreq != 0)
				return -1;
			return idx;
		}
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
