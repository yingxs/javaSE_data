package com.yingxs.data_structure.array.test;

import com.yingxs.data_structure.array.Array;
import com.yingxs.data_structure.heap.MaxHeap;

public class Test {

	public static void main(String[] args) {
		test1();
//		test2();
			
	}
	
	
	
	public static void test1(){
		Array<Integer> arr = new Array<Integer>(10);
		for(int i = 0 ; i < 10 ; i++)
			arr.addLast(i);
		System.out.println(arr);
		
		arr.add(1,100);
		System.out.println(arr);
		
		arr.addFirst(-1);
		System.out.println(arr);
//		[-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		arr.remove(2);
		System.out.println(arr);
		
		arr.removeElement(4);
		System.out.println(arr);
		
		arr.removeFirst();
		System.out.println(arr);
		
		
	}
	
	
	public static void test2(){
		Array<Student> arr = new Array<Student>();
		arr.addLast(new Student("Alice",100));
		arr.addLast(new Student("Bob",66));
		arr.addLast(new Student("Charlie",88));
		System.out.println(arr);
	}

}
