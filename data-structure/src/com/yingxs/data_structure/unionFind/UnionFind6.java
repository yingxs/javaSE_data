package com.yingxs.data_structure.unionFind;


//	�ݹ��·��ѹ�� 
public class UnionFind6 implements UF {
	
	//prant[i]�����i��Ԫ��ָ���ĸ��ڵ�
	private int[] parent;
	//rank[i]��ʾ��iΪ���ļ�������ʾ�����Ĳ���
	private int[] rank;
	
	public UnionFind6(int size) {
		parent = new int[size];
		rank = new int[size];
		for(int i = 0 ; i < size ; i++) {
			parent[i] = i;
			rank[i] = 1;
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
		
		if(p != parent[p]) 
			parent[p] = find(parent[p]);
		return parent[p];
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
		
		//	��������Ԫ����������rank��ͬ�жϺϲ�����
		//	��rank�ļ��Ϻϲ���rank�ߵļ����� 
		if(rank[pRoot] < rank[qRoot]) 
			parent[pRoot] = qRoot;
		else if(rank[qRoot] < rank[pRoot])
			parent[qRoot] = pRoot;
		else{		//sz[pRoot] == sz[qRoot]
			parent[qRoot] = pRoot;
			rank[pRoot] += 1;
		} 
			
		
	}

}
