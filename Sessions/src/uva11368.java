import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class uva11368 {
	static int n;
	static int LIS[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder("");
	static PrintWriter pw = new PrintWriter(System.out);

	static class Doll {
		int w, h;

		public Doll(int widht, int height) {
			// TODO Auto-generated constructor stub
			this.w = widht;
			this.h = height;
		}
	}

	static int LIS(ArrayList<Doll> list, int N) {

		int[] L = new int[N];
		int[] I = new int[N + 2];
		int len = 1;
		list.add(new Doll(Integer.MIN_VALUE, Integer.MIN_VALUE));
		list.add(new Doll(Integer.MIN_VALUE, Integer.MIN_VALUE));

		// kida l size n+1
		I[0] = n;
		// System.out.println(list.get(n).h);
		// System.out.println(list.get(3).h);
		for (int i = 1; i < N + 1; i++) {
			L[i - 1] = 1;
			I[i] = n + 1;
		}

		for (int i = 1; i < N + 1; i++) {

			int low, mid, high;

			low = 0;

			high = i;

			while (low <= high) {
				mid = (low + high) / 2;
				if (list.get(I[mid]).h < list.get(i - 1).h)
					low = mid + 1;
				else
					high = mid - 1;
			}
			I[low] = i - 1;
			L[i - 1] = low - 1;
			len = Math.max(low - 1, len);
		}

		int out = ;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, num, val; i < L.length; i++) {
			/// map.getOrDefault(key, defaultValue)
			val = 1;
			num = L[i];
			if (map.containsKey(num)) {
				val += map.get(num);
				map.remove(num);
			}
			map.put(num, val);
		}

		for (int i = 1; i <= len; i++) {
			if (map.containsKey(i))
				out = Math.max(map.get(i), out);
		}

		return out;

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder("");

		while (T-- > 0) {
			n = sc.nextInt();
			ArrayList<Doll> list = new ArrayList<Doll>();
			// arr = new Doll[n+1];
			for (int i = 0; i < n; i++)
				list.add(new Doll(sc.nextInt(), sc.nextInt()));

			// Comparator Sorting
			Collections.sort(list, new Comparator<Doll>() {
				@Override
				public int compare(Doll o1, Doll o2) {
					return o1.w > o2.w ? 1 : (o1.w < o2.w ? -1 : 0); // Sorted in Ascending
				}
			});
			for(int i = 0 ; i < n ; i++)
				System.out.println(list.get(i).w + " "+list.get(i).h);
			sb.append(LIS(list, n) + "\n");

		}
		pw.println(sb);
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
