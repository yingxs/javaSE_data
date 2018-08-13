package com.yingxs.data_structure.queue;

public interface Queue<E> {
	public abstract int getSize();
	public abstract boolean isEmpty();
	public abstract void enqueue(E e);
	public abstract E dequeue();
	public abstract E getFront();
}
