package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class StockEventObservable {

	private StockEvent stockEvent;
	private ReentrantLock lock = new ReentrantLock();

	public StockEventObservable(StockEvent se) {
		stockEvent = se;

	}

	private ArrayList<StockEvObserver> observers = new ArrayList<>();

	public void addEventListner(StockEvObserver so) {
		lock.lock();
		try {
			observers.add(so);
		} finally {
			lock.unlock();
		}
	}

	public void deleteEventListner(StockEvObserver so) {
		lock.lock();
		try {
			observers.remove(so);
		} finally {
			lock.unlock();
		}
	}

	public void notifyObservers(StockEvent ev) {
		lock.lock();
		for (StockEvObserver seo : observers) {
			seo.updateStock(new StockEvent(ev.getTicker(), ev.getQuote()));
		}
		lock.unlock();
	}

}
