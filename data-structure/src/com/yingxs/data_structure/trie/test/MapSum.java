package com.yingxs.data_structure.trie.test;

import java.util.TreeMap;



public class MapSum {
	private class Node{
		public int value;
		public TreeMap<Character,Node> next;
		
		public Node(int value) {
			this.value = value;
			next = new TreeMap<Character,Node>();
		}
		
		public Node() {
			this(0);
		}
	}
	
	private Node root;
	
	public MapSum() {
		root = new Node();
	}
	
	public void insert(String word,int val) {
		
		Node cur = root;
		for(int i = 0 ;i < word.length() ; i++ ) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null)
				cur.next.put(c, new Node());
			cur = cur.next.get(c);
		}
		cur.value = val;
	}
	
	public int sum(String prefix) {
		
		Node cur = root;
		for(int i = 0 ; i < prefix.length() ; i++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null)
				return 0;
			cur = cur.next.get(c);
		}
		//循环结束后cur指向前缀最后一个字符所在的节点
		return sum(cur);
	}
	
	//计算以node为根节点的所有单词的映射数值的和
	private int sum(Node node) {
		int res = node.value;
		
		for(char c : node.next.keySet())
			res += sum(node.next.get(c));
		
		return res;
	}
	

}
