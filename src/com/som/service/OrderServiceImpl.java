package com.som.service;

import com.som.service.queue.Queue;
import com.som.repository.Order;
import com.som.repository.Repository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public class OrderServiceImpl implements Service<Order>{
	private Repository<Order> repository;
	private Queue<Order> queue;

	@Override public void setRepository(Repository<Order> repository) {
		this.repository = repository;
	}

	@Override public void setQueue(Queue<Order> queue) {
		this.queue = queue;
	}

	@Override public List<Order> showAll() throws IOException {
		return repository.findAll();
	}

	@Override public List<Order> showOrderID(String orderId) throws IOException {
		return repository.findByOrderID(orderId);
	}
	@Override public void processAllOrders() throws IOException {
		List<Order> jobs = new LinkedList<>();
		while ( !queue.isEmpty() )
		{
			Order order = queue.dequeue();
			jobs.add(order);
		}
		repository.SaveAll(jobs);
	}
	@Override public void addToWorkingQueue(Order order) {
		queue.enqueue(order);
	}

}
