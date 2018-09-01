package com.yingxs.data_structure.set;

import com.yingxs.data_structure.bst.Bst;

public class BstSet<E extends Comparable<E>> implements Set<E> {

	private Bst<E> bst;
	
	public BstSet(){
		bst = new Bst<E>();
	}
	
	
	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bst.isEmpty();
	}

	
	
}
