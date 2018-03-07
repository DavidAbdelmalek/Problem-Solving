import java.io.*;
import java.util.*;

public class Roads_not_only_in_Berland {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		DsuMainClass DSU = new DsuMainClass(n + 1);

		Queue<Integer> removable = new LinkedList<Integer>();

		for (int i = 0, r1, r2; i < n - 1; i++) {
			r1 = sc.nextInt();
			r2 = sc.nextInt();
			if (DSU.isSameSet(r1, r2))  {removable.add(r1); removable.add(r2); } 
			else DSU.unionSet(r1, r2);
		}
		int sets = DSU.numSets - 1;

		Queue<Integer> root = new LinkedList<Integer>();

		StringBuilder sb = new StringBuilder("");

		for (int i = 1; i <= n; i++)
			DSU.findSet(i); 
		
		int temp[] = DSU.parent;

		for (int i = 1; i <= n; i++)
			if (temp[i] == i)
				root.add(i);

		int curr, days = 0, prev = root.poll();
		while (sets-- > 1) {
			days++;
			curr = root.poll();
			
			sb.append(removable.poll() + " " + removable.poll() + " " + prev + " " + curr + "\n");
			DSU.unionSet(curr, prev);
		
			prev = DSU.findSet(prev);
		}
		pw.print(days + " " + "\n" + sb);
		pw.flush();
		pw.close();
	}

	static class DsuMainClass {
		int[] parent, rank, setSize;
		static int fake;
		// number of disjoint sets
		int numSets;
		int connected;

		public DsuMainClass(int N) {
			parent = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				setSize[i] = 1;
			}
		}

		// The trick is to make the path for all those nodes shorter, by setting
		// the parentarent of each visited vertex directly to parent.
		public int findSet(int i) {
			return parent[i] == i ? i : (parent[i] = findSet(parent[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] >= rank[y]) {
				parent[y] = x;
				setSize[x] += setSize[y];
			} else {
				parent[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
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
