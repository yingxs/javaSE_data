package com.yingxs.data_structure.arrayTest;

import com.yingxs.data_structure.array.Array;

public class Test {

	public static void main(String[] args) {
		test1();
			
	}
	
	public static void test1(){
		Array arr = new Array(20);
		for(int i = 0 ; i < 10 ; i++)
			arr.addLast(i);
		System.out.println(arr);
		
		arr.add(1,100);
		System.out.println(arr);
		
		arr.addFirst(-1);
		System.out.println(arr);
	}

}
