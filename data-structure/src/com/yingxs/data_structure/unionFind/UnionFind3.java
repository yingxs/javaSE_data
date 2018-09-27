package com.yingxs.data_structure.unionFind;

public class UnionFind3 implements UF {
	
	//prant[i]�����i��Ԫ��ָ���ĸ��ڵ�
	private int[] parent;
	//zs[i]��ʾ��iΪ���ļ�����Ԫ�ظ���
	private int[] sz;
	
	public UnionFind3(int size) {
		parent = new int[size];
		sz = new int[size];
		for(int i = 0 ; i < size ; i++) {
			parent[i] = i;
			sz[i] = 1;
		}
	}
	

	@Override
	public int getSize() {
		return parent.length;
	}
	
	/**
	 * 	����Ԫ��p��Ӧ�ļ��ϱ��  	O(h)���Ӷȣ�hΪ���ĸ߶�
	 * @param p
	 * @return
	 */
	private int find(int p) {
		
		if(p < 0 && p >= parent.length)
			throw new IllegalArgumentException("p is out of bound");
		
		while(p != parent[p]) 
			p = parent[p];
		return p;
	}

	/**
	 * 	�鿴Ԫ��p��Ԫ��q�Ƿ�����ͬһ������ O(h)���Ӷȣ�hΪ���ĸ߶�
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * 	�ϲ�Ԫ��p��Ԫ��q�����ļ��ϣ� O(h)���Ӷȣ�hΪ���ĸ߶�
	 */
	@Override
	public void unionElements(int p, int q) {

		int pRoot = find(p);
		int qRoot = find(q);

		if(pRoot == qRoot)
			return ;
		
		//	��������Ԫ����������Ԫ�ظ�����ͬ�жϺϲ�����
		//	��Ԫ�ؽ��ٵ�Ԫ�غϲ���Ԫ�ؽ϶�ļ����� 
		if(sz[pRoot] < sz[qRoot]) {
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}else {		//sz[pRoot] >= sz[qRoot]
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		} 
			
		
	}

}
