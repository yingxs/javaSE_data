package com.yingxs.data_structure.bst.test;

import com.yingxs.data_structure.bst.Bst;

public class Test {
	public static void main(String[] args) {
		Bst<Integer> bst = new Bst<Integer>();
		
		int[] nums = {5,3,6,8,4,2};
		for(int num :nums)
			bst.add(num);
			
		bst.levelOrder();
//		bst.preOrder();
//				
//				
//		System.out.println();
//		bst.preOrderNR();
		
//		bst.inOrder();
//		
//		System.out.println();
//		
//		bst.postOrder();
//		System.out.println(bst);
		
	}
}
