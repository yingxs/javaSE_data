package com.yingxs.data_structure.bst;

public class Bst<E extends Comparable<E>> {
	
	/**
	 * 二分搜索树的节点类
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
	 * 向二分搜索树中添加新的元素e
	 * @param e
	 */
	public void add(E e){
		if(root == null){
			root = new Node(e);
			size++;
		}else{
			add(root ,e);
		}
	}
	
	/**
	 * 向以node为根的二分搜索树中插入元素e,递归算法
	 * @param node
	 * @param e
	 */
	private void add(Node node,E e){
		if(e.equals(node.e))			   //要插入的元素在树中已经存在
			return ;
		else if(e.compareTo(node.e) < 0 && node.left == null){  //插入到当前元素的左子树
			node.left = new Node(e);
			size++;
			return ;
		}else if(e.compareTo(node.e) > 0 && node.left == null){	//插入到当前元素的右子树
			node.right = new Node(e);
			size++;
			return ;
		}
		
		if( e.compareTo(node.e) < 0)
			add(node.left,e);
		else
			add(node.right,e);
		
	}
	
	
	
	
	
}
