package edu.umb.cs.cs681;

public class BondEvent {
	
	private String ticker;
	private float quote;
	
	
	
	public BondEvent(String ticker,float quote){
		this.ticker = ticker;
		this.quote = quote;
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public float getQuote(){
		return this.quote;
	}

}
