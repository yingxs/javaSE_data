package com.yingxs.data_structure.queue;

import com.yingxs.data_structure.array.Array;

public class ArrayQueue<E> implements Queue<E> {
	
	private Array<E> array;
	
	public ArrayQueue(int capacity){
		array = new Array<E>(capacity);
	}
	public ArrayQueue(){
		array = new Array<E>();
	}
	
	/**
	 * ��ȡ������Ԫ�ظ���		 O(1)
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}
	
	/**
	 * ��ȡ�����Ƿ�Ϊ��		 O(1)
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	public int getCapacity(){
		return array.getCapacity();
	}
	
	/**
	 * ���		O(1)��̯
	 */
	@Override
	public void enqueue(E e) {
		array.addLast(e);
		
	}
	/**
	 * ����		O(n)
	 */
	@Override
	public E dequeue() {
		return array.removeFirst();
	}
	
	
	
	/**
	 * �鿴���ж���Ԫ��		O(n)
	 */
	@Override
	public E getFront() {
		return array.getFirst();
	}
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue:");
		res.append("front [");
		for(int i = 0 ; i < array.getSize() ; i++){
			res.append(array.get(i));
			if( i !=  array.getSize() -1 )
				res.append(", ");
		}
		res.append("] tail");
		return res.toString();
	}
	
	
	
	
	
	
	
}
