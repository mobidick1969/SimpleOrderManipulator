package com.som.service.queue;

/**
 * Created by mobidick on 2016. 1. 4..
 */
public interface Queue<E> {
	E dequeue();
	void enqueue(E e);
	E peek();
	boolean isEmpty();
	boolean isFull();
}
