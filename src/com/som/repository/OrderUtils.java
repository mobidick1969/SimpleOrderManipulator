package com.som.repository;

import com.som.Configuration;

import java.util.Date;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public class OrderUtils {
	static public long getUniqueOrderSerial(Date currentTime){
		return currentTime.getTime();
	}
	static public Order convertToOrder(String line)
	{
		Order order = new Order();
		String[] tokens = line.split(",");
		order.setOrderSRL(tokens[0]);
		order.setOrderID(tokens[1]);
		order.setOwnerID(tokens[2]);
		order.setContents(tokens[3]);
		return order;
	}
	static public String convertToString(Order order)
	{
		return String.format("%s,%s,%s,%s%n",
			String.valueOf(getUniqueOrderSerial(new Date())),
			order.getOrderID(),
			order.getOwnerID(),
			order.getContents() );
	}
	static public Order convertToUserOrder(String line){
		return convertToOrder("0"+ Configuration.argumentDelimiter+line);
	}
}
