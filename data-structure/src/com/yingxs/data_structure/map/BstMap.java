package com.yingxs.data_structure.map;




public class BstMap<K extends Comparable<K>,V> implements Map<K,V> {
	
	private class Node{
		public K key;
		public V value;
		
		public Node left,right;
		
		public Node(K key,V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	
	public BstMap(){
		root = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * �����������������µ�Ԫ��(key,value)
	 */
	public void add(K key,V value){
			
		root = add(root,key,value);
		
	}
	
	/**
	 * ����nodeΪ���Ķ����������в���Ԫ��(Key,value),�ݹ��㷨
	 * @param node
	 * @param key
	 * @param value
	 * @return ���ز����½ڵ������������ĸ�
	 */
	private Node add(Node node,K key,V value){
		
		if(node == null){
			size++;
			return new Node(key,value);
		}
		
		if( key.compareTo(node.key) < 0)
			node.left = add(node.left,key,value);
		else if( key.compareTo(node.key) > 0)
			node.right = add(node.right,key,value);
		else	//key.compareTo(node.key) == 0
			node.value = value;
		return node;
	}
	
	private Node getNode(Node node,K key){
		if(node == null)
			return null;
		
		if(key.compareTo(node.key)==0)
			return node;
		else if(key.compareTo(node.key) < 0)
			return getNode(node.left, key);
		else
			return getNode(node.right,key);
	}
	
	public boolean contains(K key){
		return getNode(root,key) != null;
	}
	
	public V get(K key){
		Node node = getNode(root,key);
		return node == null ? null : node.value;
	}
	
	public void set(K key,V newValue){
		Node node = getNode(root,key);
		if(node == null)
			throw new IllegalArgumentException(key+" doesn't exist");
		node.value = newValue;
	}
	
	
	/**
	 * ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	 * @param node
	 * @return
	 */
	private Node minimum(Node node){
		if(node.left == null)
			return node;
		return minimum(node.left);
	}
	
	
	/**
	 * ɾ������nodeΪ���Ķ����������е���С�ڵ�
	 * @param node
	 * @return ����ɾ���ڵ���µĶ����������ĸ�
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
	 * �Ӷ�����������ɾ��Ԫ��Ϊe�Ľڵ�
	 * @param e
	 */
	public V remove(K key){
		Node node = getNode(root,key);
		if(node != null){
			root = remove(root,key);
			return node.value;
		}
		
		return null;
	}
	
	/**
	 * ɾ����nodeΪ���Ķ�����������ֵΪe�Ľڵ㣬�ݹ��㷨
	 * @param node
	 * @param e
	 * @return ����ɾ���ڵ���µĶ����������ĸ�
	 */
	private Node remove(Node node,K key){
		
		if(node == null)
			return null;
		
		if(key.compareTo(node.key) < 0){
			node.left = remove(node.left, key);
			return node;
		}else if(key.compareTo(node.key) > 0){
			node.right = remove(node.right, key);
			return node;
		}else{
			
			//��ɾ���ڵ�������Ϊ�յ����
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			
			//��ɾ���ڵ�������Ϊ�յ����
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			
			//��ɾ���ڵ�������������Ϊ�յ����
			//�д��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ�
			//������ڵ㶥��ɾ���ڵ��λ��
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;
			return successor;
		}
		
	}
	

}
