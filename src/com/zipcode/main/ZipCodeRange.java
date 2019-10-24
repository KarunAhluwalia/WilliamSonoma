package com.zipcode.main;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class ZipCodeRange {
	
	private int startRange;
	private int endRange;

	public ZipCodeRange(int startRange, int endRange){
		this.startRange = startRange;
		this.endRange = endRange;
	}
	
	public int getStartRange() {
		return startRange;
	}
	public void setStartRange(int startRange) {
		this.startRange = startRange;
	}
	public int getEndRange() {
		return endRange;
	}
	public void setEndRange(int endRange) {
		this.endRange = endRange;
	}

	
	
}
