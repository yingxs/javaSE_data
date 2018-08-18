package com.yingxs.data_structure.linkedList;

/**
 * 未使用虚拟头结点
 * @author admin
 *
 */
public class Solution {
	public ListNode removeElements(ListNode head , int val){
		while(head != null && head.val == val){
			head = head.next;
		}
		if(head == null)
			return null;
		
		ListNode prev = head;
		while(prev.next != null){
			if(prev.next.val == val){
				prev.next = prev.next.next;
			}else{
				prev = prev.next;
			}
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {6,6,1,1,2,6,3,4,5,6,6};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		ListNode res =  new Solution4().removeElements(head, 6,0);
		System.out.println(res);
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
 
 
 class Solution3 {
	 public ListNode removeElements(ListNode head , int val){
		if(head == null)
			return null;
		/*
		ListNode res = removeElements(head.next, val);
		if(head.val == val)
			return res;
		else{
			head.next = res;
			return head;
		}
		*/
		head.next = removeElements(head.next, val);
		
		return head.val == val ? head.next :head;
		
		
	 }
 }
 
 
 class Solution4 {
	 public ListNode removeElements(ListNode head , int val,int depth){
		 String depthString = generateDepthString(depth);
		 System.out.print(depthString);
		 System.out.println("Call:remove "+val+" in "+head);
		 if(head == null){
		 	System.out.print(depthString);
		 	System.out.println("Return: "+head);
			 return head;
		 }
		 ListNode res = removeElements(head.next, val,depth+1);
		 System.out.print(depthString);
		 System.out.println("After remove "+val+": "+res);
		 
		 ListNode ret;
		 if(head.val == val)
			 ret = res;
		 else{
			 head.next = res;
			 ret = head;
		 }
		 System.out.print(depthString);
	 	System.out.println("Return: "+ret);
		 return ret;
	 }
	 
	 private String generateDepthString(int depth){
		 StringBuilder res = new StringBuilder();
		 for(int i = 0 ;i <depth ;i ++)
			 res.append("--");
		 return res.toString();
	 }
 }



class ListNode {
	
	public int val;
	public ListNode next;
	public ListNode(int x){
		val = x;
	}
	/**
	 * 使用arr作为参数，创建一个链表，当前的ListNode为链表的头结点
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
	 * 以当前节点为头结点的链表信息字符串
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















