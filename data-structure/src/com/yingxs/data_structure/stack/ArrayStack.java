package com.yingxs.data_structure.stack;

import com.yingxs.data_structure.array.Array;
/**
 * 动态数组实现的栈
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
	 * 获取栈中元素数量     O(1)
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * 判断栈是否为空	O(1)
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity(){
		return array.getCapacity();
	}
	
	/**
	 * 入栈     O(1)均摊
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}

	/**
	 * 退栈     O(1)均摊
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}

	/**
	 * 获取栈顶元素      O(1)
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
