package com.som.repository;

import com.som.repository.blockdevice.DataBlock;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public class OrderRepositoryImpl implements Repository<Order>{

	private DataBlock dataBlock;

	public void setDataBlock(DataBlock dataBlock) {
		this.dataBlock = dataBlock;
	}

	public OrderRepositoryImpl(DataBlock dataBlock){
		setDataBlock(dataBlock);
	}
	@Override public List<Order> findAll() throws IOException {
		List<String> lines = dataBlock.fetchAll();
		List<Order> orders = new LinkedList<>();
		for( String line : lines )
		{
			orders.add(OrderUtils.convertToOrder(line));
		}
		return orders;
	}

	@Override public List<Order> findByOrderID(String orderID) throws IOException {
		List<String> lines = dataBlock.fetchAll();
		List<Order> orders = new LinkedList<>();
		for( String line : lines )
		{
			Order order = OrderUtils.convertToOrder(line);
			if( orderID.equals(order.getOrderID() ) )
				orders.add(order);
		}
		return orders;
	}

	@Override public void SaveAll(List<Order> orders) throws IOException {
		List<String> lines = new LinkedList<>();
		for(Order order : orders )
		{
			lines.add( OrderUtils.convertToString( order ) );
		}
		dataBlock.saveAll(lines);
	}
}
