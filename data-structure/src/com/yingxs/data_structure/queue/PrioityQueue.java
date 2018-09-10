package com.yingxs.data_structure.queue;

import com.yingxs.data_structure.heap.MaxHeap;

public class PrioityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;
	
	public PrioityQueue(){
		maxHeap = new MaxHeap<E>();
	}
	
	@Override
	public int getSize(){
		return maxHeap.size();
	}
	
	@Override
	public boolean isEmpty(){
		return maxHeap.isEmpty();
	}
	
	@Override
	public E getFront(){
		return maxHeap.finMax();
	}
	
	@Override
	public void enqueue(E e){
		maxHeap.add(e);
	}
	
	@Override
	public E dequeue(){
		return maxHeap.extractMax();
	}
	
}
