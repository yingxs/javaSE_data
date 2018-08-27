package com.yingxs.data_structure.bst.test;

import java.util.ArrayList;
import java.util.Random;

import com.yingxs.data_structure.bst.Bst;

public class Test {
	public static void main(String[] args) {
//		test1();
		
		test2();
		test3();
		 
	}

	private static void test3() {
		Bst<Integer> bst = new Bst<Integer>();
		Random random = new Random();
		 int n = 1000;
		 
		 for(int i = 0 ;i < n ; i++)
			 bst.add(random.nextInt(10000));
		
		 ArrayList<Integer> nums = new ArrayList<Integer>();
		 while(!bst.isEmpty())
			 nums.add(bst.removeMax());
		 System.out.println(nums);
		 
		 for(int i = 1 ; i<nums.size();i++)
			 if(nums.get(i-1) < nums.get(i))
				 throw new IllegalArgumentException("Error");
		 System.out.println("removeMin test completed");
	}

	private static void test2() {
		Bst<Integer> bst = new Bst<Integer>();
		Random random = new Random();
		 int n = 1000;
		 
		 for(int i = 0 ;i < n ; i++)
			 bst.add(random.nextInt(10000));
		
		 ArrayList<Integer> nums = new ArrayList<Integer>();
		 while(!bst.isEmpty())
			 nums.add(bst.removeMin());
		 System.out.println(nums);
		 
		 for(int i = 1 ; i<nums.size();i++)
			 if(nums.get(i-1) > nums.get(i))
				 throw new IllegalArgumentException("Error");
		 System.out.println("removeMin test completed");
	}

	private static void test1() {
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
