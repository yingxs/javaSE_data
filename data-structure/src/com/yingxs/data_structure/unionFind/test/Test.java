package com.yingxs.data_structure.unionFind.test;

import java.util.Random;

import com.yingxs.data_structure.unionFind.UF;
import com.yingxs.data_structure.unionFind.UnionFind1;
import com.yingxs.data_structure.unionFind.UnionFind2;
import com.yingxs.data_structure.unionFind.UnionFind3;

public class Test {

	
	private static double testUF(UF uf,int m) {
		int size = uf.getSize();
		
		Random random = new Random();
		long startTime = System.nanoTime();
		
		for(int i = 0 ; i < m ;i ++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.unionElements(a, b);
		}
		
		for(int i = 0 ; i < m ;i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			uf.isConnected(a, b);
		}
		
		long endTime = System.nanoTime();
		return (endTime - startTime)/1000000000.0;
	}
	
	public static void main(String[] args) {
			
		
		int size = 100000;
		int m = 100000;
		
		UnionFind1 uf1 = new UnionFind1(size);
		System.out.println("UnionFind1 : "+testUF(uf1,m)+" s");
		System.out.println();
		
		UnionFind2 uf2 = new UnionFind2(size);
		System.out.println("UnionFind2 : "+testUF(uf2,m)+" s");
		System.out.println();
		
		UnionFind3 uf3 = new UnionFind3(size);
		System.out.println("UnionFind3 : "+testUF(uf3,m)+" s");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}