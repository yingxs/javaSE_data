package com.yingxs.data_structure.bst;

public class Bst<E extends Comparable<E>> {
	
	/**
	 * �����������Ľڵ���
	 * @author admin
	 *
	 */
	private class Node{
		public E e;
		public Node left,right;
		
		public Node(E e){
			this.e = e;
			left = null;
			right = null;
		}
	}
	
	
	private Node root;
	private int size;
	public Bst(){
		root = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * �����������������µ�Ԫ��e,�������ĸ�
	 * @param e
	 */
	public void add(E e){
		
		/*if(root == null){
			root = new Node(e);
			size++;
		}else{
			add(root ,e);
		}*/
		
		root = add(root,e);
		
		
		
		
	}
	
	/**
	 * ����nodeΪ���Ķ����������в���Ԫ��e,�ݹ��㷨
	 * @param node
	 * @param e
	 */
	private Node add(Node node,E e){
		/*
		if(e.equals(node.e))			   //Ҫ�����Ԫ���������Ѿ�����
			return ;
		else if(e.compareTo(node.e) < 0 && node.left == null){  //���뵽��ǰԪ�ص�������
			node.left = new Node(e);
			size++;
			return ;
		}else if(e.compareTo(node.e) > 0 && node.left == null){	//���뵽��ǰԪ�ص�������
			node.right = new Node(e);
			size++;
			return ;
		}
		*/
		
		if(node == null){
			size++;
			return new Node(e);
		}
		
		
		if( e.compareTo(node.e) < 0)
			node.left = add(node.left,e);
		else if( e.compareTo(node.e) > 0)
			node.right = add(node.right,e);
		
		return node;
		
	}
	
	
	
	
	
}
