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


### resize的复杂度分析s-均摊复杂度
假设当前capacity=8,并且每次添加操作都使用addLast
1 1 1 1 1 1 1 1    8+1

9次addLast操作，触发resize，总共进行了17次基本操作
平均，每次addLast操作，进行了2次基本操作

假设capacity = n,n+1次addLast,触发resize,总共进行2n+1次基本操作
平均，每次addLast操作，进行了2次基本操作
这样均摊计算，时间复杂度是O(1)！！！

> 在这个例子中，这个均摊计算，比计算最坏的情况更有意义，因为最坏的情况并不是每次都出现

同理，我们看removeLast操作，均摊下来，平均复杂度也为O(1)

### 复杂度震荡
当我们同时看addLast和removeLast操作：
有一个数组arr它的capacity=n,数组中装满了元素，然后进行以下操作，以及所对应的事件复杂度
addLast				O(n)
removeLast 			O(n)
addLast				O(n)
removeLast 			O(n)
出现该问题的原因是:removeLast时resize操作过于着急(Eager),解决方案是
采用一种懒惰一点的方案进行解决，当size == capacity/4时，才将capacity减半




## 递归
### 本质上，将原来的问题，转换为更小的问题
#### 举例：数组求和
* Sum( arr[0...n-1] ) = arr[0]+Sum( arr[1...n-1] )
* Sum( arr[1...n-1] ) = arr[1]+Sum( arr[2...n-1] )
* ...
* Sum( arr[n-1...n-1] ) = arr[n-1]+Sum([])


## 树
> 树结构本身是一种天然的组织结构

* 高效
* 将数据使用树结构存储后，出奇的高效
	* 二分搜索树(Binary Search Tree)
	* 平衡二叉树：AVL，红黑树
	* 堆；并查集
	* 线段树；Trie(字典树，前缀树) 
	

### 二分搜索树
* 二分搜索树是二叉树
* 二分搜索树的每个节点的值：
	* 大于其左子树的所有节点的值
	* 小于其有字数的所有节点的值
* 每一颗子树也是二分搜索树 
* 存储的元素必须有可比性


### 集合的时间复杂度的分析
* LinkedListSet		O(n)	
* BstSet			O(h)	O(logn)平均    O(n)最差
> h = log2^(n+1) = O(log2^n) = O(logn)

虽然平均来讲二分搜索树的事件复杂度为O(logn),但是在最坏的情况下，它的性能也是O(n)，
二分搜索树的这个局限性可以用平衡二叉树进行解决

### 有序集合和无序集合
* 有序集合中元素具有顺序性		基于搜索树实现
* 无需集合中元素没有顺序性		基于哈希表实现

> 多重集合


### 映射的时间复杂度分析
*     LinkedListMap 		BstMap
*          O(n)              O(h)      O(logn)平均         O(n)最差


### 有序映射和无序映射
* 有序映射中元素具有顺序性		基于搜索树实现
* 无需映射中元素没有顺序性		基于哈希表实现

> 多重集合 映射的键可以重复


### 优先队列
*                      入队					出队（拿出最大元素）
*  普通线性结构		   O(1)     					O(n)
*  顺序线性结构		   O(n)							O(1)
*      堆			   O(logn)						O(logn)


### 二叉堆
> 二叉堆是一颗完全二叉树，堆中的某个节点的值总是不大于其父节点的值，因此根元素往往是最大的元素，称为最大堆，相应的可以定义最小堆。

* 完全二叉树：把元素顺序排列成树的形状
* 用数组存储二叉堆
![](http://yingxs.com/img/erchadui_array.png)
![](http://yingxs.com/img/erchadui_array2.png)


#### replace
> 取出最大元素后，放入一个新元素
* 实现1：可以先extractMax，再add，两次O(logn)的操作
* 实现2：可以直接将堆顶的元素替换后再sift Down，这是一次O(logn)的操作

#### Heapify的事件复杂度
* 将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)
* Heapify的过程算法复杂度为O(n)


#### 优先队列的经典问题
> 在N个元素中选出前M个元素，比如，在1000000个元素中选出前100名 M<<N

* 使用最小堆，或最大堆中，最小的元素优先级最高
如果逐个排序事件复杂度为NlogN,但是如果使用优先队列，时间复杂度将为NlogM

> compareTo中，当前元素比传入元素大的话返回1，反之返回-1