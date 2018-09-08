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
	
	/**
	 * ��������Ԫ��		O(logn)
	 * @param e
	 */
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	
	/**
	 * Ԫ���ϸ�
	 * @param k �ϸ���Ԫ������
	 */
	private void siftUp(int k){
		while( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
			data.swap(k, parent(k));
			k = parent(k);
		}
	}
	
	/**
	 * �������Ԫ��
	 * @return
	 */
	public E finMax(){
		if(data.getSize() == 0)
			throw new IllegalArgumentException("Can not finMax when heap is empty.");
		return data.get(0);
	}
	
	/**
	 * ȡ�����Ԫ��		O(logn)
	 * @return
	 */
	public E extractMax(){
		
		E ret = finMax();
		data.swap(0,data.getSize()-1);
		data.removeLast();
		siftDown(0);
		return ret;
	}
	
	/**
	 * Ԫ���³�
	 * @param k
	 */
	private void siftDown(int k){
		while(leftChild(k) < data.getSize()){
			int j = leftChild(k);
			if( j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0)
				j=rightChild(k);
			//data[j]��leftChild��rightChild�е����ֵ
			if(data.get(k).compareTo(data.get(j)) >= 0)
				break;
			data.swap(k, j);
			k=j;
		}
	}
	
}
