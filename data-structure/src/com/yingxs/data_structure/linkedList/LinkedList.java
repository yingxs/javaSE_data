package com.yingxs.data_structure.linkedList;
/**
 * 增删改查时间复杂度为O(n),但是如果只对链表头进行操作的话时间复杂度就是O(1)
 * 由此可见，链表只适合增删链表头元素，不要去修改，只差链表头元素O(1)
 * @author admin
 * @param <E>
 */
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
	 * 向index索引位置添加元素e	O(n/2)=O(n)
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
	 * 在链表头添加新元素e	O(n)
	 * @param e
	 */
	public void addFirst(E e){
		add(0,e);
	}
	
	
	/**
	 * 向链表末尾添加新的元素 e		O(1)
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
	/**
	 * 根据索引获得元素		O(n)
	 * @param index
	 * @return
	 */
	public E get(int index){
		
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed. Illegal index.");
		
		Node cur = dummyHead.next;
		for(int i = 0 ;i < index ;i++)
			cur = cur.next;
		return cur.e;
	}
	
	/**
	 * 获得链表的第一个元素	
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}
	/**
	 * 获得链表的最后一个元素	
	 * @return
	 */
	public E getLast(){
		return get(size-1);
	}
	
	/**
	 * 修改某一位置的元素	 O(n)
	 * @param index
	 * @param e
	 */
	public void set(int index,E e){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Set failed. Illegal index.");
		
		Node cur = dummyHead.next;
		for(int i = 0 ;i < index ;i++)
			cur = cur.next;
		cur.e = e;
	}
	
	/**
	 * 查找链表中是否含有元素e		O(n)
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		
		Node cur = dummyHead.next;
		while(cur != null){
			if(cur.e.equals(e))
				return true;
		}
		return false;
	}
	
	/**
	 * 删除链表中某一索引的元素		O(n)
	 * @param index	
	 * @return
	 */
	public E remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");
		
		Node prev = dummyHead;
		for(int i = 0 ; i < index ;i ++)
			prev = prev.next;
		
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size--;
		
		return retNode.e;
		
	}
	
	/**
	 * 删除链表的第一个元素		O(1)
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * 删除链表的最后一个元素		O(n)
	 * @return
	 */
	public E removeLast(){
		return remove(size-1);
	}
	
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		
		/*
		Node cur = dummyHead.next;
		while(cur != null){
			res.append(cur+"->");
			cur = cur.next;
		}
		*/
		
		for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
			res.append(cur+"->");
		
		res.append("NULL");
		return res.toString();
	}
	
	
	
	
	
	
	
	
}
