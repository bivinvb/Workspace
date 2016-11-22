package com.temp.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bivin
 */
public class Test1 {

	public static void main(String[] args) {
		/*String a = "10";
		Double val = Double.parseDouble(a);
		System.out.println(String.valueOf(val));*/
		
		Map<Long, String> testMap = new HashMap<Long, String>();
		testMap.put(new Long(2), "test");
		System.out.println(testMap.get(2));
		int a = 5;
		System.out.println(a + 1 +"_test");
		
		String className = Test.class.getCanonicalName();
		System.out.println(className);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		String date = sdf.format(new Date(System.currentTimeMillis()));
		System.out.println(date);
		
		/*System.out.println(Integer.MAX_VALUE);
//		System.out.println(String.valueOf(null));
		long trans =92L;
		String formatted = String.format("%030d", trans);
		System.out.println(formatted);
		Integer a =1000;
		Integer b = 1000;
//		System.out.println(a.equals(b));
		
		Test test = (Test)null;
		System.out.println(test);*/
	}
}
