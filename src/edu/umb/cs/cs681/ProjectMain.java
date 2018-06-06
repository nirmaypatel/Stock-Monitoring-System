package edu.umb.cs.cs681;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProjectMain {

	private static final int nThread = 5;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadRun tr = new ThreadRun();

		ExecutorService executor = Executors.newFixedThreadPool(nThread);

		for (int i = 0; i < 5; i++) {

			executor.execute(tr);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {

		}
		System.out.println("\nFinished all threads");

	}

}
