package com.yingxs.data_structure.heap.test;

import java.util.Random;

import com.yingxs.data_structure.heap.MaxHeap;

public class Test {
	public static void main(String[] args) {
//		test1();
		
		int n = 10000000;
		Random random = new Random();
		Integer[] testData = new Integer[n];
		for(int i = 0 ;i < n ; i++)
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		
		double time1 = testHeap(testData,false);
		System.out.println("Without heapify:"+time1+" s");
		
		double time2 = testHeap(testData,true);
		System.out.println("With heapify:"+time2+" s");
	}

	private static void test1() {
		int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		Random random = new Random();
		for(int i = 0 ;i < n ; i++)
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		int[] arr = new int[n];
		for(int i = 0 ;i < n ;i++ )
			arr[i] = maxHeap.extractMax();
		for(int i = 1 ;i < n ;i++ )
			if(arr[i-1] < arr[i])
				throw new IllegalArgumentException("Error");
		
		System.out.println("Test MaxHeap completed");
	}
	
	private static double testHeap(Integer[] testData,boolean isHeapify){
		long startTime = System.nanoTime();
		
		MaxHeap<Integer> maxHeap;
		if(isHeapify)
			maxHeap = new MaxHeap<Integer>(testData);
		else{
			maxHeap = new MaxHeap<Integer>();
			for(int num:testData)
				maxHeap.add(num);
		}
		
		
					
					
		int n = testData.length;
		
		int[] arr = new int[n];
		for(int i = 0 ;i < n ;i++ )
			arr[i] = maxHeap.extractMax();
		for(int i = 1 ;i < n ;i++ )
			if(arr[i-1] < arr[i])
				throw new IllegalArgumentException("Error");
		
		System.out.println("Test MaxHeap completed");
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000000000.0;
	}
	
}
