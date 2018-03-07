import java.io.*;
import java.util.*;


public class Cakeminator {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		char[][] grid = new char[r][c];
		String s;
		for (int i = 0; i < r; i++) {
			s = sc.nextLine();
			for (int j = 0; j < c; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		int count = 0;

		boolean visited[][] = new boolean[r][c];

		boolean contains = false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; !contains && j < c; j++) {
				if (grid[i][j] == 'S')
					contains = true;
			}
			if (!contains) {
				count += c;
				for (int j = 0; j < c; j++)
					visited[i][j] = true;
			}
			contains = false;
		}

		for (int i = 0; i < c; i++) {
			int count2 = 0;
			for (int j = 0; !contains && j < r; j++) {
				if (grid[j][i] == 'S')
					contains = true;
				else if (!visited[j][i])
					count2++;
			}

			if (!contains)
				count += count2;

			contains = false;
		}

		System.out.println(count);
	}


}
