package com.yingxs.data_structure.set;

public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	int getSize();
	boolean isEmpty();
}
