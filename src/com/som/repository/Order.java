package com.som.repository;

/**
 * Created by mobidick on 2016. 1. 4..
 */

public class Order{

	private String orderSRL;
	private String contents;
	private String orderID;
	private String ownerID;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getOrderSRL() {
		return orderSRL;
	}

	public void setOrderSRL(String orderSRL) {
		this.orderSRL = orderSRL;
	}
	@Override public String toString() {
		return getOrderSRL()+","+getOrderID()+","+getOwnerID()+","+getContents();
	}
}
