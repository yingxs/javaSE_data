package com.yingxs.data_structure.array;

/**
 * ��java�ṩ�õ�������ж��η�װ
 * @author yingxs
 *
 */
public class Array {

	private int[] data;
	private int size;
	
	/**
	 * ������вι��캯��
	 * @param capacity ���������
	 */
	public void  Array(int capacity){
		this.data = new int[capacity];
		this.size = 0;
	}
	
	/**
	 * ������޲ι��캯������������Ĭ����10
	 */
	public Array(){
		this.data = new int[10];
		this.size = 0;
	}


	/**
	 * ��ȡ������Ԫ�صĸ���
	 * @return ������Ԫ�صĸ���
	 */
	public int getSize() {
		return size;
	}
	
	
	
	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public int getCapacity() {
		return data.length;
	}
	
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return ����Ϊ�շ���true,��֮����false
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * �����鿪ͷ���һ����Ԫ��
	 * @param e Ҫ�����Ԫ��
	 */
	public void addFirst(int e){
		this.add(0,e);
	}
	
	/**
	 * ������ĩβ���һ����Ԫ��
	 * @param e Ҫ�����Ԫ��
	 */
	public void addLast(int e){
		this.add(size,e);
	}
	
	/**
	 * ��ָ����λ�ò���Ԫ��
	 * @param index Ҫ�����λ�õ�����
	 * @param e	Ҫ�����Ԫ��
	 */
	public void add(int index,int e){
		if(size == data.length)		//�ж������Ƿ�����
			throw new IllegalArgumentException("AddLast failed. Array is full.");

		
		if(index < 0 || index > size )		//Ԫ�ر���������У��м䲻���пո�
			throw new IllegalArgumentException("AddLast failed. Require index >=0 and index <= size.");

		//���Ԫ�غ���
		for(int i = size - 1 ;i >= index ; i--)
			data[i + 1] = data[i];
		
		data[index] = e;
		size++;
	}
	
	
	
}
