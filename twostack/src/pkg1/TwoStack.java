package pkg1;

import java.util.Scanner;
import java.util.Stack;

public class TwoStack {

	//private static Stack s1;
	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Queue using 2 stacks
		Stack s1=new Stack();
		Stack s2=new Stack();
		int b=0,c=1,item;
		Scanner s=new Scanner(System.in);
		while(b!=4){
		System.out.println("Enter 1 to insert 2 to delete 3 to display 4 to exit");
		
		b=s.nextInt();
		
		switch(b)
		{
		  case 1:while(c==1)
		      {
			   System.out.println("Enter element to be inserted");
			   item=s.nextInt();
			   insertrear(s1,item);
			   System.out.println("Press 1 to continue");
			   //Scanner z=new Scanner(System.in);
				c=s.nextInt();
		      }
		      break;
		  case 2:c=1;
			  while(c==1)
			  {
				  deletefront(s1,s2);
				  System.out.println("Press 1 to continue");
				  //Scanner s=new Scanner(System.in);
				  c=s.nextInt();
			  }
			  break;
		  case 3:display(s1,s2);
		         break;
		  case 4:break;
		}
		
		}
		s.close();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertrear(Stack s1,int x)
	{
		
		s1.push(x);
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void deletefront(Stack s1,Stack s2)
	{
		
		
		while(!s1.isEmpty())
		{
		s2.push(s1.pop());
		
		
		}
		System.out.println("The deleted element is:"+s2.pop());
		while(!s2.isEmpty())
		{
		s1.push(s2.pop());
		
		
		}
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void display(Stack s1,Stack s2)
	{
		Stack s=new Stack();
		while(!s1.isEmpty())
		{
		s2.push(s1.pop());
		
		
		}
		while(!s2.isEmpty())
		{
		 s.push(s2.pop());
		 System.out.println(s.get(0));
		s1.push(s.pop());
		
		
		}
		
	}

}
