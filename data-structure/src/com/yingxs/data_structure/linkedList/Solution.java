package com.yingxs.data_structure.linkedList;

/**
 * δʹ������ͷ���
 * @author admin
 *
 */
public class Solution {
	public ListNode removeElements(ListNode head , int val){
		while(head != null && head.val == val){
//			ListNode delNode = head;
//			delNode.next = null;
			head = head.next;
		}
		if(head == null)
			return null;
		
		ListNode prev = head;
		while(prev.next != null){
			if(prev.next.val == val){
//				ListNode delNode = prev.next;
//				prev.next = delNode.next;
//				delNode.next = null;
				prev.next = prev.next.next;
			}else{
				prev = prev.next;
			}
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,6,3,4,5,6};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		ListNode res =  new Solution2().removeElements(head, 6);
		System.out.println(res);
	}
}
/**
 * ʹ������ͷ���
 * @author admin
 *
 */
 class Solution2 {
	public ListNode removeElements(ListNode head , int val){
		
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		
		ListNode prev = dummyHead;
		while(prev.next != null){
			if(prev.next.val == val){
				prev.next = prev.next.next;
			}else{
				prev = prev.next;
			}
		}
		
		return dummyHead.next;
	}
}



class ListNode {
	
	public int val;
	public ListNode next;
	public ListNode(int x){
		val = x;
	}
	/**
	 * ʹ��arr��Ϊ����������һ��������ǰ��ListNodeΪ�����ͷ���
	 * @param arr
	 */
	public ListNode(int[] arr){
		if(arr == null || arr.length == 0)
			throw new IllegalArgumentException("arr can not be empty");
		this.val = arr[0];
		ListNode cur = this;
		for(int i = 1 ; i < arr.length ; i ++){
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		
	}
	
	/**
	 * �Ե�ǰ�ڵ�Ϊͷ����������Ϣ�ַ���
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while(cur != null){
			res.append(cur.val + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
	
	
	
	
}















