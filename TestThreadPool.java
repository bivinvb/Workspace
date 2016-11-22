package com.temp.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bivin
 */
public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(10);
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, workQueue);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, workQueue, new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				try {
					System.out.println("TestThreadPool|main|Executor pool full. Waiting|Request:" + r.toString());
					executor.getQueue().put(r);
					System.out.println("TestThreadPool|main|Executor pool full. Submitted|Request:{}" + r.toString());
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		for (int i = 0; i < 15; i++) {
			Worker task = new Worker();
			executor.submit(task);
		}
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + ":Exiting main Thread");
		/*workQueue = new LinkedBlockingQueue<Runnable>(5);
		executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, workQueue, new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				try {
					System.out.println("TestThreadPool|main|Executor pool full. Waiting|Request:" + r.toString());
					executor.getQueue().put(r);
					System.out.println("TestThreadPool|main|Executor pool full. Submitted|Request:{}" + r.toString());
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});*/
	/*	try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println(executor.isTerminated());
		executor.shutdown();
		while (!executor.isTerminated()) {
			System.out.println("Terminating");
		}
		executor.awaitTermination(10L, TimeUnit.MINUTES);
		System.out.println("Executor shutdown");
		executor.submit(new Worker());
	}
}

class Worker implements Runnable {

	private static int i =0;
	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() + ":Thread running: " + i++);
		try {
			Thread.sleep(30000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
