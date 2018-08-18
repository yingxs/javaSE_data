package com.yingxs.data_structure.linkedList.test;

public class Sum {
	
	public static int sum(int[] arr){
		return sum(arr,0);
	}
	//注意递归函数的宏观语义
	//递归函数就是一个函数，完成一个功能
	//计算arr[l...n)范围里的数字的和
	private static int sum(int[] arr ,int l){
		if( l == arr.length )
			return 0;					// <--- 求解最基本的问题
		return arr[l] + sum(arr,l+1);	// <--- 把原问题转换成更小的问题
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		System.out.println( sum(nums) );
	}
	
}
