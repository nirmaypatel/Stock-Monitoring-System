package edu.umb.cs.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadRun implements Runnable {
	private StockEvent se = new StockEvent("BMW", 15);
	private StockEventObservable seo = new StockEventObservable(se);
	private BondEvent be = new BondEvent("Ferrari", 200);
	private BondEventObservable beo = new BondEventObservable(be);
	private ThreeDObserver threed = new ThreeDObserver();
	private TableObserver to = new TableObserver();
	private LineChartObserver li = new LineChartObserver();
	private ReentrantLock lock = new ReentrantLock();

	public ThreadRun() {

		seo.addEventListner(threed);
		seo.addEventListner(to);
		seo.addEventListner(li);

		beo.addEventListner(threed);
		beo.addEventListner(to);
		beo.addEventListner(li);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();
		try {
			seo.notifyObservers(new StockEvent("Apple", 172.91f));
			beo.notifyObservers(new BondEvent("Apple", 172.91f));
			System.out.println("===============================================================");
			seo.notifyObservers(new StockEvent("google", 1069.00f));
			beo.notifyObservers(new BondEvent("google", 1069.00f));
			System.out.println("===============================================================");
			seo.notifyObservers(new StockEvent("Microsoft", 86.47f));
			beo.notifyObservers(new BondEvent("Microsoft", 86.47f));
			System.out.println("===============================================================");
			seo.notifyObservers(new StockEvent("Nasdaq", 6915.70f));
			beo.notifyObservers(new BondEvent("Nasdaq", 6915.70f));
			System.out.println("===============================================================");
		} finally {
			lock.unlock();
		}

	}
}
