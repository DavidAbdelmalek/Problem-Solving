import java.io.*;
import java.util.*;

public class uva11742 {
	static int n , m;
	static ArrayList<Constraint>constraints[];
	static int chairs[];
	static int people[];
	static int res;
	
	static boolean place(int chair ,int person) {
		ArrayList<Constraint> check = constraints[person];
		for(int i = 0,enemy,space,diff ; i < check.size();i++) {
			enemy=check.get(i).enemy;
			space=check.get(i).space;
			if(people[enemy]!=-1) {
				diff=Math.abs(people[enemy]-chair);
				if(space<0) {
					if(diff<Math.abs(space))return false;
				}
				else 
					if(diff>space)return false;
			}
		}
		return true;
	}

	static void ordering(int person) {
		if(person==n) {res++; return;}
		
		for(int chair = 0 ; chair<n;chair++) {
			if(chairs[chair]==-1) { 
				if(place(chair, person)) {
					chairs[chair]=person;
					people[person]=chair;
					ordering(person+1);
					chairs[chair]=-1;
					people[person]=-1;
				}
			}
	
		}
		
	}

	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while(true) {
			n=sc.nextInt(); m = sc.nextInt();
			if(n==0&&m==0)break;
			constraints=new ArrayList[n];
			
			for(int i = 0 ; i< n ; i++)constraints[i]=new ArrayList<Constraint>();
			for(int i = 0,a,b,c; i < m ; i++) {
				a=sc.nextInt();
				b=sc.nextInt();
				c=sc.nextInt();
				constraints[a].add(new Constraint(b, c));
				constraints[b].add(new Constraint(a, c));
			}
			
			
			
			chairs = new int[n]; people = new int[n];
			Arrays.fill(chairs, -1);
			Arrays.fill(people, -1);

			res=0;
		
			ordering(0);
			pw.println(res);
		}
		pw.flush();
		pw.close();
	}
	static class Constraint{
		int enemy,space;
		public Constraint( int enemy , int space) {
			this.enemy=enemy;
			this.space=space;
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
