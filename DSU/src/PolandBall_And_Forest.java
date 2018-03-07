import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PolandBall_And_Forest {
	public static void main(String[]args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int n  =sc.nextInt();
		DsuMainClass DSU = new DsuMainClass(n+1);
		
		for(int i = 1 ; i<=n ; i++)
			DSU.unionSet(i, sc.nextInt());
		
		System.out.println(DSU.numSets-1);
				
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
			if (rank[x] > rank[y]) {
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
	static class Pair{
		String name1;
		String name2;
		public Pair(String name1 , String name2) {
			// TODO Auto-generated constructor stub
			this.name1=name1;
			this.name2=name2;
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
