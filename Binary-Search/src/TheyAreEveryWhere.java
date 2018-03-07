import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TheyAreEveryWhere {
	static int n;
	static char[]arr;
	static int Types;
	static String t;

	public static void main(String[]args) throws NumberFormatException, IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char [] arr = sc.next().toCharArray();
		TreeSet<Character> ts = new TreeSet<>();
		for (char c : arr) ts.add(c);

		int numOfChars = ts.size();
		int min = (int)1e9;
		TreeMap<Character, Integer> last = new TreeMap<>();

		for (int i = 0 , j = 0 ; j < n ; ++ j) {
			last.put(arr[j], j);
			while (i < n && last.get(arr[i]) != i) i++;
			if (last.size() == numOfChars) min = Math.min(min, j - i+1);
		}
		System.out.println(min);
	}
}
