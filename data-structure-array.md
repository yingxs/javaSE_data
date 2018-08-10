### 简单的事件复杂度分析
* O(1),O(n),O(lgn),O(nlogn),O(n^2)
* O描述的是算法的运行事件和输入数据之间的关系
```
public static int sum(int[] nums){
	int sum = 0;
	for(int nim : nums){
		 sum+=num;
	}
	return sum;
}
```

#### 分析
* O(n),n是nums中的元素个数，算法和n呈线性关系
* 为什么要用O，为什么叫做O(n)
	* 因为在以上算法中，我们忽略了常数，实际上事件是T=c1*n*c2 
	* c1可看做是每次循环的相对时间长度
	* c2可看做是循环开始前的变量和sum的内存开辟，和循环之后的数据返回所占用的相对时间长度
##### 渐进时间复杂度，描述n趋近于与无穷大的情况
* T= 2*n + 2             O(n)
* T= 2000*n + 10000      O(n)
* T= 1*n*n + 0           O(n^2)
* T= 2*n*n +3 00n + 10   O(n^2)


### 分析动态数组的事件复杂度
#### 添加操作
* addLast(e)		O(1)
* addFirst(e)		O(n)
* add(index,e)  	O(n/2)=O(n)
* resize(c)			O(n)
> 总体而言 添加操作的事件复杂度是O(n),(考虑最坏的情况)

#### 删除操作
* removeLast(e)		O(1)
* removeFirst(e)	O(n)
* remove(index,e)  	O(n/2)=O(n)
* resize(c)			O(n)
> 总体而言 删除操作的事件复杂度是O(n),(考虑最坏的情况)


#### 修改操作
* set(index,e)			O(1)

#### 查找操作
* get(index)		O(1)
* contains			O(n)
* find(e)			O(n)

#### 总结
* 增：O(n)
* 删：O(n)
* 改：已知索引O(1);未知索引O(n)
* 查：已知索引O(1);未知索引O(n)


