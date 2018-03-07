import java.util.*;
import java.io.*;

public class Marcus {
	static char [][]dfs;
	static int n;
	static int m;
	static boolean visited[][];
	static StringBuilder sb ;
	static int check []={0,1,0,-1,-1,0};
	static ArrayList<Integer>res;

	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while(T-->0){
			res=new ArrayList<Integer>();
			String s[] = bf.readLine().split(" ");
			n = Integer.parseInt(s[0]);;
			m = Integer.parseInt(s[1]);;
			dfs= new char[n][m];
			visited=new boolean[n][m];
			sb = new StringBuilder();
			String s1;
			int start=0;
			for(int i = 0 ; i < n ; i++){
				s1=bf.readLine();
				for(int j = 0 ; j < m;j++){
					dfs[i][j]=s1.charAt(j);
					if(dfs[i][j]=='@')start=j;
				}
			}
			dfs(n-1,start);
			int size= res.size();
			for(int w = 0,i ; w <size;w++){
				i=res.get(w);
				if(i==0)sb.append("right");
				else if(i==2)sb.append("left");
				else sb.append("forth");
				if(w<size-1)sb.append(" ");
			}
			System.out.println(sb);
		}
	}
	static void dfs(int x, int y){
		visited[x][y]=true;

		if(dfs[x][y]=='#')return;
		for(int i = 0 ; i  < 6; i+=2){
			if(check(x,y,check[i],check[i+1]))
				if(!visited[x+check[i]][y+check[i+1]]){
					res.add(i);
					dfs(x+check[i],y+check[i+1]);
				}
		}
	}
	static boolean check(int curenX,int curenY,int newX,int newY){
		curenX+=newX;
		curenY+=newY;

		boolean condition = curenX==-1||curenX>=n||curenY==-1||curenY>=m;
		if(!condition)
			if((dfs[curenX][curenY]=='I'
			||dfs[curenX][curenY]=='E'
			||	dfs[curenX][curenY]=='H'
			||dfs[curenX][curenY]=='O'
			||dfs[curenX][curenY]=='V'
			||dfs[curenX][curenY]=='A' 
			||dfs[curenX][curenY]=='#' ))
				return true;
		return false;
	}
}

