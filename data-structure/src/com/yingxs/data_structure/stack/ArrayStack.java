package com.yingxs.data_structure.stack;

import com.yingxs.data_structure.array.Array;
/**
 * ��̬����ʵ�ֵ�ջ
 * @author yingxs
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
	
	Array<E> array;
	
	
	public ArrayStack(int capacity){
		array = new Array<E>(capacity);
	}
	
	public ArrayStack(){
		array = new Array<E>();
	}
	
	/**
	 * ��ȡջ��Ԫ������     O(1)
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * �ж�ջ�Ƿ�Ϊ��	O(1)
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity(){
		return array.getCapacity();
	}
	
	/**
	 * ��ջ     O(1)��̯
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}

	/**
	 * ��ջ     O(1)��̯
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}

	/**
	 * ��ȡջ��Ԫ��      O(1)
	 */
	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack:");
		res.append("[:");
		for(int i = 0; i<array.getSize();i++ ){
			res.append(array.get(i));
			if(i != array.getSize() -1 )
				res.append(", ");
		}
		res.append("] top");
		return res.toString();
	}
	
	
	
	
	

}
