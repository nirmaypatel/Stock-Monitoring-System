package edu.umb.cs.cs681;

public class LineChartObserver implements StockEvObserver, BondEvObserver {

	@Override
	public void updateStock(StockEvent se) {
		// TODO Auto-generated method stub

		System.out.println("The Stock is " + se.getTicker() + " and it's value is " + se.getQuote());

	}

	@Override
	public void updateBond(BondEvent be) {
		// TODO Auto-generated method stub
		System.out.println("The Bond is " + be.getTicker() + " and it's value is " + be.getQuote());
	}
}
