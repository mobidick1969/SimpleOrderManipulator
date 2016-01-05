package com.som.service;

import com.som.repository.Repository;
import com.som.service.queue.Queue;

import java.io.IOException;
import java.util.List;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public interface Service<E> {
	void setRepository(Repository<E> repository);
	void setQueue(Queue<E> queue);
	List<E> showAll() throws IOException;
	List<E> showOrderID(String orderId) throws IOException;
	void processAllOrders() throws IOException;
	void addToWorkingQueue(E order);
}
