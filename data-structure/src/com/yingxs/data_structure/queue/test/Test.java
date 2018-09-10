package com.yingxs.data_structure.queue.test;

import java.util.List;
import java.util.Random;

import com.yingxs.data_structure.queue.ArrayQueue;
import com.yingxs.data_structure.queue.LinkedListQueue;
import com.yingxs.data_structure.queue.LoopQueue;
import com.yingxs.data_structure.queue.Queue;

public class Test {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
		
	}
	
	private static void test5() {
		int[] arr = {1,2,3,4,5,6,1,6,6,2,2,1,4};
		
		List<Integer> list = Solution.topKFrequent(arr, 4);
		System.out.println(list);
	}
	
	
	public static void test4(){
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		for(int i = 0 ;i < 10 ;i++){
			queue.enqueue(i);
			System.out.println(queue);
			
			if( i % 3 == 2){
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
	
	
	public static void test3(){
		
		int opCount = 10000000;
		
//		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
//		double time1 = testQueue(arrayQueue, opCount);
//		System.out.println("ArrayQueue, time: "+time1+" s");
		
		LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
		double time2 = testQueue(loopQueue, opCount);
		System.out.println("LoopQueue, time: "+time2+" s");
		
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
		double time3 = testQueue(linkedListQueue, opCount);
		System.out.println("LinkedListQueue, time: "+time3+" s");
		
		
	}
	
	
	private static double testQueue(Queue<Integer> q,int opCount){
		long startTime = System.nanoTime();
		
		Random random = new Random();
		for(int i = 0 ;i < opCount ; i++){
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		
		for(int i = 0 ;i < opCount ; i++){
			q.dequeue();
		}
		
		long endTime = System.nanoTime();
		return (endTime-startTime)/1000000000.0;
	}
	
	public static void test1(){
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		for(int i = 0 ;i < 10 ;i++){
			queue.enqueue(i);
			System.out.println(queue);
			
			if( i % 3 == 2){
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
	public static void test2(){
		LoopQueue<Integer> queue = new LoopQueue<Integer>();
		for(int i = 0 ;i < 10 ;i++){
			queue.enqueue(i);
			System.out.println(queue);
			
			if( i % 3 == 2){
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
}
