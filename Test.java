package com.temp.test;

/**
 * @author bivin
 */
public class Test {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				StaticTest test = StaticTest.getStaticTest();
				test.start();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				StaticTest test = StaticTest.getStaticTest();
				test.start();
			}
		});
		t1.start();
		t2.start();
	}
}
