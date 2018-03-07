import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class uva10130 {
	static int N;
	static Pair obj[];
	static int G;
	static int memo[][];
	static int weight;
	public static void main(String[]args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder("");

		while(T-->0) {
			N = sc.nextInt();

			obj = new Pair[N+1];
			for(int i = 0; i < N ; i++)obj[i]=new Pair(sc.nextInt(),sc.nextInt());

			memo=new int [10001][31];//index // weight
			for(int i = 0 ; i <1000 ; i++)Arrays.fill(memo[i], -1);


			G=sc.nextInt();
			int ans = 0;

			for(int i = 0;  i<G;i++){
				weight = sc.nextInt();
				ans += dp(0,weight);
			}
			sb.append(ans);
			if(T!=0)sb.append("\n");
		}
		pw.println(sb);
		pw.flush();
		pw.close();

	}
	static int  dp(int index,int remWeight) {

		if(remWeight<0)return -100000000;
		if(index==N)return 0;
		if(memo[index][remWeight]!=-1)return memo[index][remWeight];
		
		int ans1 = dp(index+1,remWeight);

		int ans2=0;

		if(remWeight-obj[index].weight>=0)
			ans2 = obj[index].price+dp(index+1,remWeight-obj[index].weight);

		return memo[index][remWeight]=Math.max(ans1, ans2);
	}
}
class Pair {
	int price;
	int weight;
	public Pair(int price,int weight) {
		this.price=price;
		this.weight=weight;
	}
}
