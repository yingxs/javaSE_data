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
	 * ����ĳ��������ʾ��Ԫ�صĸ��ڵ������
	 * @param index
	 * @return 
	 */
	private int parent(int index){
		if(index == 0)
			throw new IllegalAccessError("index-0 doesn't have parent");
		return (index-1)/2;
	}
	
	/**
	 * ����һ����������ʾ��Ԫ�ص���ڵ������
	 * @return
	 */
	private int leftChild(int index) {
		return index * 2 + 1;
	}
	
	/**
	 * ����һ����������ʾ��Ԫ�ص��ҽڵ������
	 * @return
	 */
	private int rightChild(int index) {
		return index * 2 + 2;
	}
	
	
}
