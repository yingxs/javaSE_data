package com.yingxs.data_structure.linkedList;

/**
 * 未使用虚拟头结点
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
}
/**
 * 使用虚拟头结点
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
		
	}
}