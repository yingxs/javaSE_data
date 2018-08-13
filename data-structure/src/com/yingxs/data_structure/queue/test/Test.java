package com.yingxs.data_structure.queue.test;

import com.yingxs.data_structure.queue.ArrayQueue;
import com.yingxs.data_structure.queue.LoopQueue;

public class Test {
	public static void main(String[] args) {
//		test1();
		test2();
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
