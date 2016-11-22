package com.temp.test;

/**
 * @author bivin
 */
public class TestSynchronisation {

	public static void main(String[] args) {
		TestVo testVo = new TestVo("10", "12");
		String a = testVo.getA();

		TestThread testThread = new TestThread(a);
		testThread.run();
		synchronized (testVo) {

			System.out.println(testVo.getA());
		}
	}
}

class TestThread implements Runnable {

	private String a;

	public TestThread(String a) {
		this.a = a;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	}

}
