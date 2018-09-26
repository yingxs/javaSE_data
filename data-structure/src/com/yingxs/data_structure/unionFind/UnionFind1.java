package com.yingxs.data_structure.unionFind;

public class UnionFind1 implements UF {
	
	private int[] id;
	
	public UnionFind1(int size) {
		id = new int[size];
		for(int i = 0 ; i < id.length ; i++)
			id[i] = i;
	}

	@Override
	public int getSize() {
		return id.length;
	}

	/**
	 * 	查询元素p和q是否属于同一个集合	O(1)
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 *	 合并元素p和q所属的集合		O(n)
	 */
	@Override
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID)
			return ;
		
		for(int i = 0 ; i < id.length ; i++)
			if(id[i] == pID)
				id[i] = qID;

	}
	
	
	/**
	 * 	查询元素p所对应的集合编号
	 * @param p
	 * @return
	 */
	private int find(int p) {
		if(p < 0 && p >= id.length)
			throw new IllegalArgumentException("p is out of bound");
		return id[p];
	}

}
