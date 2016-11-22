package pkg2;
import java.util.*;
public class RMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Rndomize an array
		int n,i,x;
		int b[]=new int [10];
		int a[]=new int [10];
		System.out.println("Enter the size:");
		Scanner inp=new Scanner(System.in);
		Scanner p=new Scanner(System.in);
		n=inp.nextInt();
		System.out.println("enter array in sorted order");
		for(i=0;i<n;i++)
		{
			
			a[i]=p.nextInt();
		}
		for(i=0;i<n;i++)
		{
			b[i]=0;
		}
		for(i=0;i<n;i++)
		{
			do
			{
			 x=0+(int)(Math.random()*n);
			}while(b[x]!=0);
			b[x]=a[i];
			
		}
		for(i=0;i<n;i++)
			System.out.print(b[i]);
		inp.close();
		p.close();
	}

}
