package com.yingxs.data_structure.queue.test;

import java.util.Random;

import com.yingxs.data_structure.queue.ArrayQueue;
import com.yingxs.data_structure.queue.LoopQueue;
import com.yingxs.data_structure.queue.Queue;

public class Test {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
	
	public static void test3(){
		
		int opCount = 100000;
		
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
		double time1 = testQueue(arrayQueue, opCount);
		System.out.println("ArrayQueue, time: "+time1+" s");
		
		LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
		double time2 = testQueue(loopQueue, opCount);
		System.out.println("LoopQueue, time: "+time2+" s");
		
		
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
