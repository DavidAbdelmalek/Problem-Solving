import java.util.*;
import java.io.*;


public class FormingTeams {
	static ArrayList<Integer>[]dfs;
	static int count=1;
	static boolean visited[];
	static int n ;
	static int [] chain;
	static int [] cycles;
	static int cycle=1;
	static int remove;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//Number of students
		int m = sc.nextInt();//Number of pairs arch

		dfs = new ArrayList[n+1];//1 based
		visited=new boolean[n+1];

		for(int i = 1 ; i <= n ; i++)dfs[i]=new ArrayList<Integer>();

		for(int i = 0 ,f,s; i < m ; i ++) {
			f=sc.nextInt();
			s=sc.nextInt();
			dfs[f].add(s);
			dfs[s].add(f);
		}
		for(int i  = 1;i<=n; i++){
			if(!visited[i]){
				dfs(i);
				System.out.println(count);
				if(count!=1&count%2==1)remove++;
				count=1;
			}
		}
		System.out.println(remove);
	}
	
	static void dfs(int target){
		visited[target]=true;
		for(int i = 0,child ; i < dfs[target].size();i++){
			child=  dfs[target].get(i);
			if(!visited[child]){
				dfs(child);
				++count;
			}
		}
	}	
	static void init(){
		for(int i = 1 ; i <= n;i++)visited[i]=false;
	}
}