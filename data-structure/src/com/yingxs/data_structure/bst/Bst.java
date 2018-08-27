package com.yingxs.data_structure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	 * 向二分搜索树中添加新的元素e,返回树的根
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
	 * 向以node为根的二分搜索树中插入元素e,递归算法
	 * @param node
	 * @param e
	 */
	private Node add(Node node,E e){
		/*
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
	
	/**
	 * 看二分搜索树中是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		return contains(root,e);
	}
	
	/**
	 * 查看以node为根的二分搜索树中是否包含元素e,递归算法
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node,E e){
		
		if(node == null)
			return false;
		
		if( e.compareTo(node.e) == 0)
			return true;
		else if(e.compareTo(node.e) < 0)
			return contains(node.left,e);
		else
			return contains(node.right,e);
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder(){
		preOrder(root);
	}
	
	
	/**
	 * 前序遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void preOrder(Node node){
		
		if(node == null)
			return ;
		
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * 二分搜索树的非递归前序遍历
	 */
	public void preOrderNR(){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node cur = stack.pop();
			System.out.println(cur.e);
			
			if( cur.right != null )
				stack.push(cur.right);
			
			if( cur.left != null)
				stack.push(cur.left);
		}
	}
	
	
	
	/**
	 * 中序遍历
	 */
	public void inOrder(){
		inOrder(root);
	}
	
	
	/**
	 * 中序遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void inOrder(Node node){
		if(node == null)
			return ;
		
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	/**
	 * 二分搜索树的后序遍历
	 */
	public void postOrder(){
		postOrder(root);
	}
	
	/**
	 * 后续遍历以node为根的二分搜索树，递归算法
	 * @param node
	 */
	private void postOrder(Node node) {
		
		if(node == null)
			return ;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
		
	}
	
	/**
	 * 二分搜索树的层序遍历
	 */
	public void levelOrder(){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node cur = q.remove();
			System.out.println(cur.e);
			
			if(cur.left!=null)
				q.add(cur.left);
			if(cur.right!=null)
				q.add(cur.right);
		}
	}
	
	/**
	 * 寻找二分搜索树的最小元素
	 */
	public E minimum(){
		if(size == 0)
			throw new IllegalArgumentException("BST is empty!");
		return minimum(root).e;
	}

	/**
	 * 返回以node为根的二分搜索树的最小值所在的节点
	 * @param node
	 * @return
	 */
	private Node minimum(Node node){
		if(node.left == null)
			return node;
		return minimum(node.left);
	}
	/**
	 * 寻找二分搜索树的最大元素
	 */
	public E maximum(){
		if(size == 0)
			throw new IllegalArgumentException("BST is empty!");
		return maximum(root).e;
	}
	
	/**
	 * 返回以node为根的二分搜索树的最大值所在的节点
	 * @param node
	 * @return
	 */
	private Node maximum(Node node){
		if(node.right == null)
			return node;
		return minimum(node.right);
	}
	
	/**
	 * 从二分搜索树中删除最小值所在节点，返回最小值
	 * @return
	 */
	public E removeMin(){
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}
	
	
	
	/**
	 * 删除掉以node为根的二分搜索树中的最小节点
	 * @param node
	 * @return 返回删除节点后新的二分搜索树的根
	 */
	private Node removeMin(Node node) {
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
		
	}
	/**
	 * 从二分搜索树中删除最大值所在节点，返回最大值
	 * @return
	 */
	public E removeMax(){
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}
	
	
	
	/**
	 * 删除掉以node为根的二分搜索树中的最大节点
	 * @param node
	 * @return 返回删除节点后新的二分搜索树的根
	 */
	private Node removeMax(Node node) {
		
		if(node.right == null){
			Node leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		
		node.right = removeMax(node.right);
		return node;
		
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	
	
	/**
	 * 递归遍历以node为根节点，层级为depth的树
	 * @param node
	 * @param depth
	 * @param res
	 */
	private void generateBSTString(Node node,int depth,StringBuilder res){
		
		if(node == null ){
			res.append(generateDepthString(depth) + "null\n");
			return ;
		}
		
		res.append(generateDepthString(depth)+node.e+"\n");
		generateBSTString(node.left,depth+1,res);
		generateBSTString(node.right,depth+1,res);
		
	}
	
	/**
	 * 根据层级打印线段
	 * @param depth
	 * @return
	 */
	private String generateDepthString(int depth){
		StringBuilder res = new StringBuilder();
		for(int i = 0 ;i < depth ; i++)
			res.append("--");
		return res.toString();
	}
	
	
	
	
}
