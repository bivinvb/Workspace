
package pkg1;
import java.util.*;

public class Mainn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d;
		String b=new String();
		Scanner s=new Scanner(System.in);
		d=s.nextInt();
		s.close();
		DecBin n=new DecBin();
		//System.out.println(d);
		b=n.convertDecimal(d);
		System.out.print(b);
		

	}

}
