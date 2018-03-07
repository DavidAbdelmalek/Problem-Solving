import java.io.*;
import java.util.*;

public class uva10608 {
	static int N, k;

	public static void main(String[]args) throws IOException {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		int TC = sc.nextInt();
		while(TC-->0) {
			N = sc.nextInt();
			k = sc.nextInt();
			DsuMainClass DSU = new DsuMainClass(N+1);

			while(k-->0) 
				DSU.unionSet(sc.nextInt(), sc.nextInt());

			for(int i = 1 ; i<=N;i++)
				DSU.findSet(i);

			HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();

			int temp[]=DSU.parent;
			int max=1;
			
			for(int i = 1,val ; i<=N;i++) {
				val=1;
				if(map.containsKey(temp[i])) {
					val+= map.get(temp[i]);
				}
				max=Math.max(max, val);
				map.put(temp[i], val);
			}
			sb.append(max+"\n");

		}
		System.out.print(sb);
	}

	static class DsuMainClass {
		int[] parent, rank, setSize;
		// number of disjoint sets
		int numSets;

		public DsuMainClass(int N) {
			parent = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				setSize[i] = 1;
			}
		}

		// The trick is to make the parentaths for all those nodes shorter, by setting
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
				rank[y] = 0;
			} else {
				parent[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;

				rank[x] = 0;
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

	}
}
