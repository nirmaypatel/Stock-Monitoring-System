package edu.umb.cs.cs681;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class BondEventObservable {

	private BondEvent bondEvent;
	private ReentrantLock lock = new ReentrantLock();

	public BondEventObservable(BondEvent be) {
		bondEvent = be;

	}

	private ArrayList<BondEvObserver> observers = new ArrayList<>();

	public void addEventListner(BondEvObserver bo) {
		lock.lock();
		try {
			observers.add(bo);
		} finally {
			lock.unlock();
		}
	}

	public void deleteEventListner(BondEvObserver bo) {
		lock.lock();
		try {
			observers.remove(bo);
		} finally {
			lock.unlock();
		}

	}

	public void notifyObservers(BondEvent bv) {

		lock.lock();
		try {
			for (BondEvObserver beo : observers) {
				beo.updateBond(new BondEvent(bv.getTicker(), bv.getQuote()));
			}
		} finally {
			lock.unlock();
		}

	}

}
