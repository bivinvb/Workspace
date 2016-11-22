package pkg3;
import java.util.*;

public class LMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m,t1=0,t2=0,t3=0,t4=0;
		Scanner c=new Scanner(System.in);
		n=c.nextInt();
		c.close();
		m=n/6;
		if(n<3)
			System.out.println(n);
		else
		{
			/*System.out.println(6*m-1 );
			System.out.println(6*m+1);
			System.out.println(6*(m-1)-1);
			System.out.println(6*(m-1)+1);*/
			if(checkPrime(6*m-1)==0)
				t1=(6*m-1);
			if(checkPrime(6*m+1)==0)
				t2=6*m+1;
			if(checkPrime(6*(m-1)-1)==0)
				t3=(6*(m-1)-1);
			if(checkPrime(6*(m-1)+1)==0)
				t4=(6*(m-1)+1);
			System.out.println(Math.max(Math.max(t1, t2),Math.max(t3, t4)));
			
		
		}

	}
	public static int checkPrime(int m)
	{
		int i;
		if(m<1)
			return 1;
		for(i=2;i<=m/2;i++)
		{
			if(m%i==0)
			{
				
				return 1;
			}
		}
		
		return 0;
	}

}
