import java.util.Scanner;

public class Kolya_And_Tandem_Repeat {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k   = sc.nextInt(), len = s.length(), maxLen=0,pointer2=0,pointer1,temp;
		boolean takenBefore=false;
		int i,j;
		int firstHalf=0;
		int secondHalf=0;
		for( i= 0 ; i < len;i++) {
			pointer1=i;
			takenBefore=false;
			temp=i;
			for( j  = temp +1 ; j< len && i<len ;j++) {
				if(s.charAt(i)==s.charAt(j)) {
					if(!takenBefore) {
						takenBefore=true;
						pointer2=j;
					}
					if(i+1<pointer2)i++;
					else {
						if(j+1==len) {System.out.println("GG " + "pointer1 "+pointer1 + " with pointer2 "+pointer2);j++;break;}
						firstHalf=pointer2-pointer1;
						secondHalf=j-pointer2+1;
						System.out.println(firstHalf + " "+secondHalf);
						if(firstHalf==secondHalf)maxLen=Math.max(firstHalf*2, maxLen);
						i=temp;takenBefore=false;
						System.out.println("RESET "+temp + " while j "+j);
					}
				}
				else
					if(takenBefore)  {
						if(j+1==len) {j++;break;}
						firstHalf=pointer2-pointer1;
						secondHalf=j-pointer2;
						System.out.println(firstHalf + " "+secondHalf);
						if(firstHalf==secondHalf)maxLen=Math.max(firstHalf*2, maxLen);
						i=temp;takenBefore=false;
						System.out.println("RESET "+temp + " while j "+j);
					}
				
				
				
				
			if(takenBefore)System.out.println("TMAM   "+pointer1 + " pointer2 "+pointer2+" with i "+i+" and j "+j);
			}
		
			if(takenBefore) {
				System.out.println("HERE "+j);
				System.out.println(pointer1 + " "+pointer2);
				firstHalf=pointer2-pointer1;
				secondHalf=j-pointer2+k;
				System.out.println(secondHalf);
				if(firstHalf<=secondHalf)maxLen=Math.max(firstHalf+(secondHalf-firstHalf)/2,maxLen);
			}
			i=temp;
		}
		System.out.println(maxLen);
	}
}
