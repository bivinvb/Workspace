package com.temp.test;

/**
 * @author bivin
 */
public class StaticTest {
	private static StaticTest staticTest;

	private StaticTest() {
		
	}
	
	public static StaticTest getStaticTest() {
		if (staticTest == null) {
			staticTest = new StaticTest();
		}
		return staticTest;
	}

	public void start() {
		System.out.println("Inside start:" + staticTest.hashCode());
		
	}
}
