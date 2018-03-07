import java.util.*;
import java.io.*;

public class RankList {
	static ArrayList<Team>teams;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();

		teams = new ArrayList<Team>();

		for(int i = 0 ;i <  n ;  i++) teams.add(new Team(sc.nextInt(),sc.nextInt()));

		Collections.sort(teams, new Comparator<Team>(){
			public int compare(Team team1, Team team2) {
				if(team1.problems-team2.problems==0)return team1.penalty-team2.penalty;
				else return team2.problems - team1.problems;
			}
		});
		int [] count=new int[n];
		for(int i = 0 , count1; i < n;){
			count1=check(i);
			if(count1>1){
				for(int j = i+1; j<i+count1 ; j++) count[j]=count1;
				count[i]=count1;
				i+=count1;
			}else {
				count[i]=1;
				i++;
			}
		}
		k--;
		System.out.println(count[k]);
	}
	static int check(int index){
		int problems = teams.get(index).problems;
		int penalty = teams.get(index).penalty;
		int count=1;
		for(int j = index+1;j<n;j++)
			if(teams.get(j).problems==problems&&teams.get(j).penalty==penalty)count++;
		return count;
	}
}
class Team{
	int problems;
	int penalty;
	Team(int problems,int penalty){
		this.problems=problems;
		this.penalty=penalty;
	}
}