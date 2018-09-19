package com.yingxs.data_structure.trie;

import java.util.TreeMap;

public class Trie {

	private class Node{
		public boolean isWord;
		public TreeMap<Character,Node> next;
		
		public Node(boolean isWorld) {
			this.isWord = isWorld;
			next = new TreeMap<Character,Node>();
		}
		
		public Node() {
			this(false);
		}
	}
	
	private Node root;
	private int size;
	
	public Trie() {
		root = new Node();
		size = 0;
	}
	
	/**
	 * 	���Trie�д洢�ĵ�������
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 *	 ��Trie�����һ���µĵ���word
	 * @param word
	 */
	public void add(String word) {
		
		Node cur = root;
		for(int i = 0 ;i < word.length() ; i++ ) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null)
				cur.next.put(c, new Node());
			cur = cur.next.get(c);
		}
		
		if(!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}
	
	/**
	 * 	��ѯ����word�Ƿ���Trie��
	 * @param word
	 * @return
	 */
	public boolean contains(String word) {
		
		Node cur = root;
		for(int i = 0 ; i < word.length() ; i ++ ) {
			char c = word.charAt(i);
			if( cur.next.get(c) == null )
				return false;
			cur = cur.next.get(c);
		}
		
		return cur.isWord;
	}
	
	/**
	 * ��ѯ�Ƿ���Trie���е�����prefixΪǰ׺
	 * @param prefix
	 * @return
	 */
	public boolean isPrefix(String prefix) {
		
		Node cur = root;
		for(int i = 0 ;i < prefix.length() ; i++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null)
				return false;
			cur = cur.next.get(c);
		}
		return true;
	}
	
}
