package com.yingxs.data_structure.linkedList;
/**
 * ��ɾ�Ĳ�ʱ�临�Ӷ�ΪO(n),�������ֻ������ͷ���в����Ļ�ʱ�临�ӶȾ���O(1)
 * �ɴ˿ɼ�������ֻ�ʺ���ɾ����ͷԪ�أ���Ҫȥ�޸ģ�ֻ������ͷԪ��O(1)
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
	 * ��ȡ�����е�Ԫ�ظ���
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	
	/**
	 * ��index����λ�����Ԫ��e	O(n/2)=O(n)
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
	 * ������ͷ�����Ԫ��e	O(n)
	 * @param e
	 */
	public void addFirst(E e){
		add(0,e);
	}
	
	
	/**
	 * ������ĩβ����µ�Ԫ�� e		O(1)
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
	/**
	 * �����������Ԫ��		O(n)
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
	 * �������ĵ�һ��Ԫ��	
	 * @return
	 */
	public E getFirst(){
		return get(0);
	}
	/**
	 * �����������һ��Ԫ��	
	 * @return
	 */
	public E getLast(){
		return get(size-1);
	}
	
	/**
	 * �޸�ĳһλ�õ�Ԫ��	 O(n)
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
	 * �����������Ƿ���Ԫ��e		O(n)
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
	 * ɾ��������ĳһ������Ԫ��		O(n)
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
	 * ɾ������ĵ�һ��Ԫ��		O(1)
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * ɾ����������һ��Ԫ��		O(n)
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
