package com.yingxs.data_structure.linkedList;

public class LinkedList<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e,Node next){
			this.e = e;
			this.next = next;
		}
		
		public Node(E e){
			this(e,null);
		}
		
		public Node(){
			this(null,null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedList(){
		dummyHead = new Node(null,null);
		size = 0;
	}
	
	/**
	 * 获取链表中的元素个数
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	
	/**
	 * 向index索引位置添加元素e
	 * @param index
	 * @param e
	 */
	public void add(int index,E e){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add failed. Illegal index.");
			
		Node prev = dummyHead;
		for(int i = 0 ;i < index ; i++)
			prev = prev.next;
//		Node node = new Node(e);
//		node.next = prev.next;
//		prev.next = node;
		
		prev.next = new Node(e,prev.next);
		size++;
	}
	
	/**
	 * 在链表头添加新元素e
	 * @param e
	 */
	public void addFirst(E e){
		add(0,e);
	}
	
	
	/**
	 * 向链表末尾添加新的元素 e
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
