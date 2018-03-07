import java.io.*;
import java.util.*;

public class New_Year_Candles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();int n  = sc.nextInt();
		Dragon[] dragons = new Dragon[n];

		for(int i = 0 ; i < n ; i ++)dragons[i]=new Dragon(sc.nextInt(),sc.nextInt());

		Arrays.sort(dragons, new Comparator<Dragon>() {
			@Override
			public int compare(Dragon o1, Dragon o2) {
				return o1.strength > o2.strength ? 1 :(o1.strength < o2.strength ? -1 : 0); //Sorted in Ascending
			}
		});
		
		for(int i = 0 ; i<  n ; i++) {
			if(s<=dragons[i].strength) {
				System.out.println("NO");
				return;
			}
			s+=dragons[i].bonus;
		}
		System.out.println("YES");
		

	}

	static class Dragon {
		int strength;
		int bonus;

		public Dragon(int strength, int bonus) {
			// TODO Auto-generated constructor stub
			this.strength = strength;
			this.bonus = bonus;

		}
	}
}