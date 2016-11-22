package pkg1;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st1,st2;
		Scanner b=new Scanner(System.in);
		st1=b.nextLine();
		System.out.println(st1);
		Scanner c=new Scanner(System.in);
		st2=c.nextLine();
		c.close();
		b.close();
		Anagram a=new Anagram();
		a.isAnagram(st1,st2);

	}

}
