import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaAndPark {

	static ArrayList<Integer>[] tree;
	static int N, M;
	static int hasCat[];
	static boolean vis[];
	
	static int dfs(int node , int cons)
	{
		if(cons > M)
			return 0;
		if(tree[node].size() == 1 && node != 0)
			if(cons + hasCat[node] <= M )
				return 1;
			else
				return 0;
		
		
		
		vis[node] = true;
		int count = 0;
		for (int i = 0; i < tree[node].size(); i++) {
			int v = tree[node].get(i);
			if(!vis[v])
			if(hasCat[node] == 1)
			count += dfs(v,cons + hasCat[node]);
			else
				count += dfs(v , 0);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		hasCat = new int[N];
		vis = new boolean[N];
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++)
			hasCat[i] = sc.nextInt();
		for (int i = 0; i < N - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			tree[u].add(v);
			tree[v].add(u);
		}
		System.out.println(dfs(0,0));

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