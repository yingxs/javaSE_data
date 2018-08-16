package com.yingxs.data_structure.stack.test;

import java.util.Random;

import com.yingxs.data_structure.stack.ArrayStack;
import com.yingxs.data_structure.stack.LinkedListStack;
import com.yingxs.data_structure.stack.Stack;

public class Test {
	public static void main(String[] args) {
		
		test3();
	}
	
	
	public static void test1(){
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		for(int i = 0 ;i < 5;i++){
			stack.push(i);
			System.out.println(stack);
		}
		stack.pop();
		System.out.println(stack);
	}
	
	public static void test2(){
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		for(int i = 0 ;i < 5;i++){
			stack.push(i);
			System.out.println(stack);
		}
		stack.pop();
		System.out.println(stack);
		
	}
	
	
	public static double testStack(Stack<Integer> stack, int opCount){
		
		long startTime = System.nanoTime();
		
		Random random = new Random();
		for(int i = 0 ;i < opCount ; i++){
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		
		for(int i = 0 ;i < opCount ; i++){
			stack.pop();
		}
		
		long endTime = System.nanoTime();
		return (endTime-startTime)/1000000000.0;
	}
	
	public static void test3(){
		
		int opCount = 10000000;
		
		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
		double time1 = testStack(arrayStack,opCount);
		System.out.println("ArrayStack, time:" + time1 + "s");
		
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
		double time2 = testStack(linkedListStack,opCount);
		System.out.println("LinkedListStack, time:" + time2 + "s");
		
		
	}
	
}
