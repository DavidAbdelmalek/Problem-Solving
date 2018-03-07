import java.util.*;
import java.io.*;

public class KefaAndCompany {
	static int n ;
	static int d ;
	static long [] zones ;
	static long most=0;
	static ArrayList<friend> friends;
	static int start=0;
	public static void main(String[]args){	
		Scanner sc = new Scanner(System.in);

		n  = sc.nextInt();
		d  = sc.nextInt();

		friends= new ArrayList<friend>();
		friends.add(new friend(0,0));
		
		for(int i = 1,zone,money; i <= n ; i++){
			money = sc.nextInt();
			zone = sc.nextInt();
			friends.add(new friend(money,zone));
			most=Math.max(most, zone);
		}
		
		Collections.sort(friends, new Comparator<friend>(){
			@Override
			public int compare(friend one, friend two) {
				return one.money-two.money;
			}
		});
		zones = new long[n+1];
		for(int i = 1 ; i <= n ; i++)zones[i]+=(zones[i-1]+friends.get(i).zone);

		
		for(int i = 0 , end; i <= n ; i++){
			start=i;
			end=BS();
			most = Math.max(most,zones[end]-zones[start]+friends.get(i).zone);
		}
		System.out.println(most);

	}

	static int BS(){
		int low=  start;
		int mid=0;
		int high=  n;
		int money;
		while(low<high){
			mid = low+(high-low+1)/2;
			money = friends.get(mid).money-friends.get(start).money;
			if(money>=d)high=mid-1;
			else low=mid;
		}
		return high;
	}
}
class friend{
	int money;
	int zone;
	public friend(int money,int zone){
		this.money=money;
		this.zone=zone;
	}
}
