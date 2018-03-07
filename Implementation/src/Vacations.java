import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Vacations {
	static int n;
	static int[] arr;
	static int[][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		String in [] = bf.readLine().split(" ");
		arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(in[i]);

		memo = new int[n][3];
		Arrays.fill(memo, -1);

		for(int i = 0 ; i<n;i++)memo[i][0]=-1;

		System.out.println(getMax(0, false, false));
	}

	static int getMax(int i,boolean gym,boolean contest) {

		if (i == n)
			return 0;

		int target = arr[i];
		int ve=0;
		
		if(memo[i]!=-1)return memo[i]+getMax(i+1,gym,contest);
		if(target==0 || target==1&&contest||target==2&&gym){
			gym= false;
			contest=false;
			ve++;
		}
		if(target==1&&!contest){
				contest=true;
				gym=false;
			}

		if(target==2&&!gym){
			contest=false;
			gym=true;
		}
		if(target==3)
			if(!contest)
				if(!gym){
					int gymOnly = getMax(i+1,true,false);
					int contest223 = getMax(i+1,false,true);
					if(gymOnly<=contest223){
						memo[i][0]=Math.min(gymOnly, contest223);
						memo[i][1]=1;
						memo[i][2]=0;
					}
				
				}
				else return memo[i]= getMax(i+1,false,true);
			else
				if(!gym) return memo[i]=getMax(i+1,true,false);
		return memo[i]=ve+getMax(i+1,gym,contest);
	}
}