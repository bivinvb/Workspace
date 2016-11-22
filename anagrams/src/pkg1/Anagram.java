package pkg1;

import java.util.*;


public class Anagram {

	public boolean isAnagram(String s1,String s2)
	{
		HashMap <Character,Integer> hm=new HashMap <Character,Integer>();
		HashMap <Character,Integer> hm2=new HashMap <Character,Integer>();
		char []c=s1.toCharArray();
		char []c2=s2.toCharArray();
		int i,j,x;
		if(s1.length()!=s2.length())
		{
			System.out.println(s1.length());
			System.out.println(s2.length());
			System.out.println("Not anagram");
			return false;
		}
		for(i=0;i<s1.length();i++)
		{
			hm.put(c[i],0);
			//System.out.println(hm.get(c[i]));
		}
		for(i=0;i<s1.length();i++)
		{
			
			if(hm.get(c[i])==0)
			{
		
				hm.put(c[i], 1);
			}
			else
			{
				x=hm.get(c[i]);
				hm.put(c[i], x+1);
				
			}
			//System.out.println(hm.get(c[i]));
		}
		for(j=0;j<s1.length();j++)
		{
			hm2.put(c2[j],0);
			//System.out.println(hm2.get(c2[j]));
		}
		for(j=0;j<s1.length();j++)
		{
			if(hm2.get(c2[j])==0)
			{
				hm2.put(c2[j], 1);
			}
			else
			{
				x=hm2.get(c2[j]);
				hm2.put(c2[j], x+1);
				
			}
			System.out.println(hm2.get(c2[j]));
		}
		for(i=0;i<s1.length();i++)
		{
			if(hm.get(c[i])!=hm2.get(c[i]))
			{
				
				System.out.println("Not anagram");
				return false;
			}
		}
		System.out.println("Anagram");
		return true;
	}
}
