package com.yingxs.data_structure.segmentTree.test;

import com.yingxs.data_structure.segmentTree.Merger;
import com.yingxs.data_structure.segmentTree.SegmentTree;

public class Test {
	public static void main(String[] args) {
		Integer[] nums = {-2,0,3,-5,2,-1};
		SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
			public Integer merge(Integer a, Integer b) {
				return a+b;
			};
		});
		
		System.out.println(segTree);
	}
}
