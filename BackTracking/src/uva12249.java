import java.io.*;
import java.util.*;

public class uva12249 {
	static int n;
	static String[] arr;
	static boolean taken[];
	static int len;
	static int temp;

	static int place(int withMe, int target) {

		String s = arr[withMe];
		String needed = arr[target];

		int p1 = arr[withMe].length() - 1;
		int p2 = 0;

		while (p1 >= 0 && p2 < needed.length()) {
			if (s.charAt(p1) != needed.charAt(p2))
				break;
			p1--;
			p2++;
		}
		return needed.length() - p2;
	}

	static void permuate(int index, int LenTillNow, int ok) {
		System.out.println(Long.toBinaryString(ok)+" iNSIDE");
	//	while (ok != temp) {
			for (int i = 0, placeOut; i < n; i++) {
				if (!taken[i] && i != index) {
					placeOut = place(index, i);
					taken[i] = true;
					permuate(i, LenTillNow + placeOut, ok | (1 << i));
					taken[i] = false;

				}
			}
	//	}
		if(ok==temp)len = Math.min(LenTillNow, len);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int TC = sc.nextInt();
		int T = 0;
		while (TC-- > 0) {
			T++;
			len = (int) 1e8;

			n = sc.nextInt();
			temp = (int) Math.pow(2, n +1)-1;
			System.out.println(Long.toBinaryString(temp));
			arr = new String[n];
			taken = new boolean[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextLine();
			int max = 0;
			for (int i = 0; i < n; i++) {
				taken = new boolean[n];
				len = (int) 1e9;
				taken[i] = true;
				permuate(i, arr[i].length(), (1 << n) | (1 << i));
				System.out.println(len);
				max = Math.min(max, len + arr[i].length());
			}
			pw.printf("Case %d: %d\n", T, max);
		}
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

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}
}
