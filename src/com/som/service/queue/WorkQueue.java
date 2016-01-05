package com.som.service.queue;

/**
 * Created by mobidick on 2015. 12. 29..
 */
public class WorkQueue<E> implements Queue,ResizingArrayQueue<E> {
	static final int initialCapacity = 10;
	private int capacity;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	private E [] container;

	private void generateContainer() {
		container = (E[]) new Object[capacity];
	}
	public WorkQueue()
	{
		this.capacity = initialCapacity;
		generateContainer();
	}
	public WorkQueue(int capacity)
	{
		this.capacity = capacity;
		generateContainer();
	}
	@Override
	public boolean isFull() { return size == capacity; }
	@Override
	public boolean isEmpty()
	{
		return head==tail;
	}
	@Override
	public E peek()
	{
		return container[head];
	}
	@Override
	public E dequeue()
	{
		if(isEmpty()) throw new UnsupportedOperationException();
		resize();
		size--;
		E r = container[head];
		container[head++]=null;
		return r;
	}
	@Override public void enqueue(Object o) {
		if( isFull() ) resize();
		E e = (E)o;
		size++;
		container[tail++]=e;
	}

	private void adjust(int newCapacity)
	{
		E [] comer = (E[]) new Object[newCapacity];
		int j = 0;
		for(int i=head;i<tail;i++) comer[j++] = container[i];
		head = 0;
		tail = j;
		capacity = newCapacity;
		container = comer;
	}
	@Override
	public void resize()
	{
		adjust(2*capacity);
	}
	@Override
	public String toString()
	{
		return "current capacity:"+capacity+"current size:"+size+"["+head+","+tail+","+peek()+"]";
	}

}
