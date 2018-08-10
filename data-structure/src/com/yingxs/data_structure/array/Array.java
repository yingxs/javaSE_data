package com.yingxs.data_structure.array;

/**
 * 对java提供得到数组进行二次封装
 * @author yingxs
 *
 */
public class Array<E> {

	private  E[] data;
	private int size;
	
	/**
	 * 数组的有参构造函数
	 * @param capacity 数组的容量
	 */
	public Array(int capacity){
		this.data = (E[]) new Object[capacity];
		this.size = 0;
	}
	
	/**
	 * 数组的无参构造函数，数组容量默认是10
	 */
	public Array(){
		this.data = (E[]) new Object[10];
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
	public void addFirst(E e){
		this.add(0,e);
	}
	
	/**
	 * 在数组末尾添加一个新元素
	 * @param e 要插入的元素
	 */
	public void addLast(E e){
		this.add(size,e);
	}
	
	/**
	 * 向指定的位置插入元素
	 * @param index 要插入的位置的索引
	 * @param e	要插入的元素
	 */
	public void add(int index,E e){
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
	/**
	 * 获取index索引位置的元素
	 * @param index 要获取的元素的索引
	 * @return 返回获取到的元素
	 */
	public E get(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed.Index is illegal");
		return data[index];
	}
	
	/**
	 * 修改index索引位置的元素为e
	 * @param index 要修改的元素的索引
	 * @param e	该修改为的元素
	 */
	void set(int index,E e){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed.Index is illegal");
		data[index] = e;
	}
	
	/**
	 * 查找数组中是否含有元素e
	 * @param e 
	 * @return 存在就返回true,反之返回false
	 */
	public boolean contains(E e){
		for(int i = 0 ;i < size ; i++){
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	/**
	 * 查找数组中元素e所在索引，如果不存在就返回-1
	 * @param e
	 * @return
	 */
	public int find(E e){
		for(int i = 0 ;i < size ; i++){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	/**
	 * 从数组中删除Index位置的元素，并将删除的元素返回
	 * @param index 索引
	 * @return 删除的元素
	 */
	public E remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed.Index is illegal");

		E ret = data[index];
		for(int i = index+1 ; i < size ; i++)
			data[i-1] = data[i];
		size--;
		data[size] = null;
		return ret;
	
	}
	
	/**
	 * 删除数组中第一个元素，并将删除的元素返回
	 * @return
	 */
	public E removeFirst(){
		return remove(0);
	}
	
	/**
	 * 删除数组中最后一个元素，并将删除的元素返回
	 * @return
	 */
	public E removeLast(){
		return remove(size-1);
	}
	
	/**
	 * 从数组中删除元素e,有就删除，数组中不存在该元素，就什么也不做
	 * @param e
	 */
	public void removeElement(E e){
		int index = find(e);
		if(index != -1)
			remove(index);
	}
	
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size = %d , capcity = %d\n",size,data.length));
		res.append('[');
		for(int i = 0 ; i < size ; i++){
			res.append(data[i]);
			if( i != size-1 )
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}
	
}
