/**
 * Filename: TestThreadPool.java
 *
 * © Copyright 2015 Flytxt BV. ALL RIGHTS RESERVED.

 * All rights, title and interest (including all intellectual property rights) in this software and any derivative works based upon or derived from
 * this software belongs exclusively to Flytxt BV.

 * Access to this software is forbidden to anyone except current employees of Flytxt BV and its affiliated companies who have executed non-disclosure
 * agreements explicitly covering such access. While in the employment of Flytxt BV or its affiliate companies as the case may be, employees may use
 * this software internally, solely in the course of employment, for the sole purpose of developing new functionalities, features, procedures,
 * routines, customizations or derivative works, or for the purpose of providing maintenance or support for the software. Save as expressly permitted
 * above, no license or right thereto is hereby granted to anyone, either directly, by implication or otherwise. On the termination of employment,
 * the license granted to employee to access the software shall terminate and the software should be returned to the employer, without retaining any
 * copies.

 * This software is (i) proprietary to Flytxt BV; (ii) is of significant value to it; (iii) contains trade secrets of Flytxt BV; (iv) is not publicly
 * available; and (v) constitutes the confidential information of Flytxt BV.

 * Any use, reproduction, modification, distribution, public performance or display of this software or through the use of this software without the
 * prior, express written consent of Flytxt BV is strictly prohibited and may be in violation of applicable laws.
 *
 */
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
