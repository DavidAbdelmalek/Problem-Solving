import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		double r = sc.nextInt(),x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt();

		int d = (int) Math.sqrt( ((x2-x1)*(x2-x1))+ ((y2-y1)*(y2-y1)));

		if(d>=r) {
			System.out.println(x1 + " "+x2 + " "+r);
			return;
		}
		
		

	}

	static class DijkstraAlgo {
		/*
		 * Dijkstra Algorithm
		 * 
		 *
		 */
		public static void computePaths(Node source) {
			source.shortestDistance = 0;

			// implement a priority queue
			PriorityQueue<Node> queue = new PriorityQueue<Node>();
			queue.add(source);

			while (!queue.isEmpty()) {
				Node u = queue.poll();

				for (Edge e : u.adjacencies) {

					Node v = e.target;
					double weight = e.weight;

					// relax(u,v,weight)
					double distanceFromU = u.shortestDistance + weight;
					if (distanceFromU < v.shortestDistance) {

						/*
						 * remove v from queue for updating the shortestDistance value
						 */
						queue.remove(v);
						v.shortestDistance = distanceFromU;
						v.parent = u;
						queue.add(v);

					}
				}
			}
		}

		public static List<Node> getShortestPathTo(Node target) {

			// trace path from target to source
			List<Node> path = new ArrayList<Node>();
			for (Node node = target; node != null; node = node.parent) {
				path.add(node);
			}

			// reverse the order such that it will be from source to target
			Collections.reverse(path);

			return path;
		}

	}

	// define Node
	class Node implements Comparable<Node> {

		public final int value;
		public Edge[] adjacencies;
		public double shortestDistance = Double.POSITIVE_INFINITY;
		public Node parent;

		public Node(int val) {
			value = val;
		}

		public String toString() {
			return value + "";
		}

		public int compareTo(Node other) {
			return Double.compare(shortestDistance, other.shortestDistance);
		}

	}

	// define Edge
	class Edge {
		public final Node target;
		public final double weight;

		public Edge(Node targetNode, double weightVal) {
			target = targetNode;
			weight = weightVal;
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

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
