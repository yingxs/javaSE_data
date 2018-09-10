package com.yingxs.data_structure.queue.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Solution3 {
	
	private static class Freq {
		public int e,freq;
		
		public Freq(int e, int freq) {
			super();
			this.e = e;
			this.freq = freq;
		}

		/*@Override
		public int compareTo(Freq o) {
			if(this.freq < o.freq)
				return -1;
			else if(this.freq > o.freq)
				return 1;
			else 
				return 0;
		}*/
	}
	
	private static class FreqComparator implements Comparator<Freq>{
		
		@Override
		public int compare(Freq a,Freq b){
			return a.freq - b.freq;
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
		
//		FreqComparator fr = new FreqComparator();
		
		PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
		for(int key:map.keySet()){
			if(pq.size() < k)
				pq.add(new Freq(key, map.get(key)));
			else if(map.get(key) > pq.peek().freq){
				pq.remove();
				pq.add(new Freq(key, map.get(key)));
			}
		}
		LinkedList<Integer> res = new LinkedList<Integer>();
		while(!pq.isEmpty())
			res.add(pq.remove().e);
		
		return res;
		
	}
}
