package com.yingxs.data_structure.linkedList.test;

public class Sum {
	
	public static int sum(int[] arr){
		return sum(arr,0);
	}
	//ע��ݹ麯���ĺ������
	//�ݹ麯������һ�����������һ������
	//����arr[l...n)��Χ������ֵĺ�
	private static int sum(int[] arr ,int l){
		if( l == arr.length )
			return 0;					// <--- ��������������
		return arr[l] + sum(arr,l+1);	// <--- ��ԭ����ת���ɸ�С������
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		System.out.println( sum(nums) );
	}
	
}
