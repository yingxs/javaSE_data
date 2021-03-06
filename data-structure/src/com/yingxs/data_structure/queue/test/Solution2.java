package com.yingxs.data_structure.queue.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Solution2 {
	
	public static List<Integer> topKFrequent(int[] nums,int k){
		final TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int num:nums){
			if(map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a,Integer b){
				return map.get(a) - map.get(b);
			}
		}
//		(a,b)->map.get(a).map.get(b)
				);
		for(int key:map.keySet()){
			if(pq.size() < k)
				pq.add(key);
			else if(map.get(key) > map.get(pq.peek()) ){
				pq.remove();
				pq.add(key);
			}
		}
		LinkedList<Integer> res = new LinkedList<Integer>();
		while(!pq.isEmpty())
			res.add(pq.remove());
		
		return res;
		
	}
}
