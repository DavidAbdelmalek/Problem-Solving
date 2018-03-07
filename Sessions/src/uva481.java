import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class uva481 {
	static ArrayList<Integer> list;
	static int LIS[];
	static int n;
	static int inf = Integer.MAX_VALUE;
	static int printing[];
	
	static int LisNlogK() {
	
		int I[] = new int[n + 1];

		int L[] = new int[n];
		// which runs the NlogK LIS algorithm
		
		int i; // auxilary variable for iteration
		list.add(inf);
		I[0] = n; // I[0] = -infinite
		
		for (i = 1; i <= n; i++) // observe that i <= n are given
			I[i] = inf; // I[1 to n] = infinite

		int LisLength = 0; 
		// keeps the maximum position where a data is inserted
		for (i = 0; i < n; i++) { // iterate left to right
			int low, high, mid; // variables to perform binary search
			low = 0; // minimum position where we to put data in I[]
			high = LisLength; // the maximum position
			while (low <= high) { // binary search to find the correct position
				mid = (low + high) / 2;
				if (list.get(I[mid]) < list.get(i))
					low = mid + 1;
				else
					high = mid - 1;
			}
			
			I[low] = i;
			if (low != 0)
				L[i] = Math.max(0, I[low - 1]);

			// Parent[i]=I[low-1];
			if (LisLength < low) // LisLength contains the maximum position
				LisLength = low;
		}
		printing = new int[LisLength + 1];

		int len = LisLength;

		int index = I[LisLength];
		// get the last one
		printing[LisLength] = list.get(index);

		while (LisLength-- > 0) {
			printing[LisLength] = list.get(L[index]);
			index = L[index];
		}

		return len + 1;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		String s;
		int num;
		list = new ArrayList<Integer>();
		// list.add(INF);
		while (!(s = sc.nextLine()).equals("")) {
			num = Integer.parseInt(s);
			list.add(num);
		}
		n = list.size();
		StringBuilder sb = new StringBuilder("");
		sb.append(LisNlogK()+"\n-\n");
		
		for(int i = 0 ; i <  printing.length;i++) 
			sb.append(printing[i]+"\n");
		
		
		
		pw.print(sb.toString());
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
