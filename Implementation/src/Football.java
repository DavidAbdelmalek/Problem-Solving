import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Football {
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int teamA=1,teamB=0;
		String temp2="";
		String temp = bf.readLine();
		--n;
		for(int i = 0 ; i<n;i++){
			String in =bf.readLine();
			if(temp.equals(in))teamA++;
			else {
				if(temp2.length()==0)temp2=in;
				teamB++;
			}
		}
		System.out.println(teamA>teamB?temp:temp2);
	}
}
