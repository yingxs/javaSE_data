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
	public Array(int capacity){
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
	/**
	 * ��ȡindex����λ�õ�Ԫ��
	 * @param index Ҫ��ȡ��Ԫ�ص�����
	 * @return ���ػ�ȡ����Ԫ��
	 */
	public int get(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed.Index is illegal");
		return data[index];
	}
	
	/**
	 * �޸�index����λ�õ�Ԫ��Ϊe
	 * @param index Ҫ�޸ĵ�Ԫ�ص�����
	 * @param e	���޸�Ϊ��Ԫ��
	 */
	void set(int index,int e){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed.Index is illegal");
		data[index] = e;
	}
	
	/**
	 * �����������Ƿ���Ԫ��e
	 * @param e 
	 * @return ���ھͷ���true,��֮����false
	 */
	public boolean contains(int e){
		for(int i = 0 ;i < size ; i++){
			if(data[i] == e)
				return true;
		}
		return false;
	}
	
	/**
	 * ����������Ԫ��e������������������ھͷ���-1
	 * @param e
	 * @return
	 */
	public int find(int e){
		for(int i = 0 ;i < size ; i++){
			if(data[i] == e)
				return i;
		}
		return -1;
	}
	
	/**
	 * ��������ɾ��Indexλ�õ�Ԫ�أ�����ɾ����Ԫ�ط���
	 * @param index ����
	 * @return ɾ����Ԫ��
	 */
	public int remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed.Index is illegal");

		int ret = data[index];
		for(int i = index+1 ; i < size ; i++)
			data[i-1] = data[i];
		
		size--;
		return ret;
	
	}
	
	/**
	 * ɾ�������е�һ��Ԫ�أ�����ɾ����Ԫ�ط���
	 * @return
	 */
	public int removeFirst(){
		return remove(0);
	}
	
	/**
	 * ɾ�����������һ��Ԫ�أ�����ɾ����Ԫ�ط���
	 * @return
	 */
	public int removeLast(){
		return remove(size-1);
	}
	
	
	public void removeElement(int e){
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
