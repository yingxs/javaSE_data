package com.yingxs.data_structure.queue.test;

import com.yingxs.data_structure.queue.ArrayQueue;

public class Test {
	public static void main(String[] args) {
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
}
