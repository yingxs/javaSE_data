package com.yingxs.data_structure.queue.test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import com.yingxs.data_structure.queue.PrioityQueue;

public class Solution {
	
	private static class Freq implements Comparable<Freq>{
		public int e,freq;
		
		public Freq(int e, int freq) {
			super();
			this.e = e;
			this.freq = freq;
		}

		@Override
		public int compareTo(Freq o) {
			if(this.freq < o.freq)
				return 1;
			else if(this.freq > o.freq)
				return -1;
			else 
				return 0;
		}
	}
	
	public static List<Integer> topKFrequent(int[] nums,int k){
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int num:nums){
			if(map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}
		
		PrioityQueue<Freq> pq = new PrioityQueue<Freq>();
		for(int key:map.keySet()){
			if(pq.getSize() < k)
				pq.enqueue(new Freq(key, map.get(key)));
			else if(map.get(key) > pq.getFront().freq){
				pq.dequeue();
				pq.enqueue(new Freq(key, map.get(key)));
			}
		}
		LinkedList<Integer> res = new LinkedList<Integer>();
		while(!pq.isEmpty())
			res.add(pq.dequeue().e);
		
		return res;
		
	}
}
