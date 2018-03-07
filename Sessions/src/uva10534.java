import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10534 {
	static int n;
	static int[] LIS;
	static int[] LDS;
	static int inf = 2000000000;
	static ArrayList<Integer> list;
	static ArrayList<Integer> list2;

	static void LIS(ArrayList<Integer>list) {
		LIS = new int[n];
		int[] I = new int[n+1];

		I[0] = Integer.MIN_VALUE;
		for (int i = 1; i < n+1; i++) {
			LIS[i-1] = 1;
			I[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < n; i++) {
			int low, mid, high;
			low = 0;
			high = i;
			while (low <= high) {
				mid = (low + high) / 2;
				if (I[mid] < list.get(i))
					low = mid + 1;
				else
					high = mid - 1;
			}
			I[low] = list.get(i);
			LIS[i] = low;
		}
	}
	static void LDS(ArrayList<Integer>list) {
		LDS = new int[n];
		int[] I = new int[n+1];

		I[0] = Integer.MIN_VALUE;
		for (int i = 1; i < n+1; i++) {
			LDS[i-1] = 1;
			I[i] = Integer.MAX_VALUE;
		}

		for (int i = n-1; i >=0; i--) {
			int low, mid, high;
			low = 0;
			high = i;
			while (low <= high) {
				mid = (low + high) / 2;
				if (I[mid] < list.get(i))
					low = mid + 1;
				else
					high = mid - 1;
			}
			I[low] = list.get(i);
			LDS[i] = low;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		String s;
		StringBuilder sb = new StringBuilder("");
		while (!(s = sc.nextLine()).equals("")) {
			n = Integer.parseInt(s);
			list = new ArrayList<Integer>();
			list2 = new ArrayList<Integer>();
			for (int i = 0, num; i < n; i++) {
				num = sc.nextInt();
				list.add(num);
				list2.add(num);
			}
		
			LIS(list);
			LDS(list);
			
			int out =0;
			for(int i=0;i<n;i++)
				out=Math.max(Math.min(LIS[i],LDS[i])*2-1,out);
			
			sb.append(out+"\n");
			
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
