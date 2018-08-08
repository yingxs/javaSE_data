package com.yingxs.data_structure.array;

/**
 * 对java提供得到数组进行二次封装
 * @author yingxs
 *
 */
public class Array {

	private int[] data;
	private int size;
	
	/**
	 * 数组的有参构造函数
	 * @param capacity 数组的容量
	 */
	public void  Array(int capacity){
		this.data = new int[capacity];
		this.size = 0;
	}
	
	/**
	 * 数组的无参构造函数，数组容量默认是10
	 */
	public Array(){
		this.data = new int[10];
		this.size = 0;
	}


	/**
	 * 获取数组中元素的个数
	 * @return 数组中元素的个数
	 */
	public int getSize() {
		return size;
	}
	
	
	
	/**
	 * 获取数组容量
	 * @return 数组容量
	 */
	public int getCapacity() {
		return data.length;
	}
	
	
	/**
	 * 判断数组是否为空
	 * @return 数组为空返回true,反之返回false
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 在数组开头添加一个新元素
	 * @param e 要插入的元素
	 */
	public void addFirst(int e){
		this.add(0,e);
	}
	
	/**
	 * 在数组末尾添加一个新元素
	 * @param e 要插入的元素
	 */
	public void addLast(int e){
		this.add(size,e);
	}
	
	/**
	 * 向指定的位置插入元素
	 * @param index 要插入的位置的索引
	 * @param e	要插入的元素
	 */
	public void add(int index,int e){
		if(size == data.length)		//判断数组是否已满
			throw new IllegalArgumentException("AddLast failed. Array is full.");

		
		if(index < 0 || index > size )		//元素必须紧跟排列，中间不能有空格
			throw new IllegalArgumentException("AddLast failed. Require index >=0 and index <= size.");

		//其后元素后移
		for(int i = size - 1 ;i >= index ; i--)
			data[i + 1] = data[i];
		
		data[index] = e;
		size++;
	}
	
	
	
}
