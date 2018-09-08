package com.yingxs.data_structure.heap;

import com.yingxs.data_structure.array.Array;

public class MaxHeap<E extends Comparable<E>> {
	
	private Array<E> data;
	
	public MaxHeap(int capacity){
		data = new Array<E>(capacity);
	}
	
	public MaxHeap(){
		data = new Array<E>();
	}
	
	public int size(){
		return data.getSize();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	/**
	 * 计算某个索引表示的元素的父节点的索引
	 * @param index
	 * @return 
	 */
	private int parent(int index){
		if(index == 0)
			throw new IllegalAccessError("index-0 doesn't have parent");
		return (index-1)/2;
	}
	
	/**
	 * 计算一个索引所表示的元素的左节点的索引
	 * @return
	 */
	private int leftChild(int index) {
		return index * 2 + 1;
	}
	
	/**
	 * 计算一个索引所表示的元素的右节点的索引
	 * @return
	 */
	private int rightChild(int index) {
		return index * 2 + 2;
	}
	
	/**
	 * 向堆中添加元素
	 * @param e
	 */
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	/**
	 * 元素上浮
	 * @param k 上浮的元素索引
	 */
	private void siftUp(int k){
		while( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
			data.swap(k, parent(k));
			k = parent(k);
		}
	}
	
	
}
