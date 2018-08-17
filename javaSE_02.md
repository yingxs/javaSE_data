## 集合


#### 集合继承体系图
* Collection 单列集合的根接口
	* List 有序(存和取的顺序一致)，有索引，可以存储重复
		* ArrayList 数组实现
		* LinkedList 链表实现
		* Vector 数组实现
	* Set 无序(存和取的顺序不 一致)，无索引，不可以存储重复
		* HashSet 哈希算法
		* TreeSet二叉树算法
![](http://www.yingxs.com/img/collection01.png)

## Collection
### 常用方法
* boolean add(E e)添加
* boolean remov e(Object o)删除
* void clear()清空
* boolean contains(Object o)是否包含某元素
* boolean isEmpty()判断是否为空
* int size()获取集合中元素个数
* boolean addAll(Collection c)将指定Collection中的元素都添加到此Collection中
* boolean removeAll(Collection c)删除交集
* boolean containsAll(Collextion c)判断传入的集合是否为调用的集合真子集
* boolean retainAll(Collection c)取交集，并将交集赋予调用集合，如果调用集合改变就返回true，不改变就返回flase


### 迭代
> 集合用来存储元素，存储的元素需要查看，那么就需要迭代(遍历)

* Iterator<E> iterator()获取迭代器
* boolean hasNext()判断集合中是否还有元素可以迭代
* E next()获取元素 
* void remove()


## List集合  
### 常用方法
* void add(int index,E element)指定位置插入元素index<=size
* boolean addAll(Collection<? extends E> c)
* E remove(int index)删除指定对象并返回
* E get(int index)通过索引获取指定元素
* E set(int index,E element)修改指定位置的元素

## 并发修改异常
```
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("a");
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		/*
		Iterator it = list.iterator();
		while(it.hasNext()){ 
			String str = (String) it.next();
			if("world".equals(str)){
				list.add("javaee");              //遍历的同时增加元素  并发修改异常 通过ListIterator解决
			}
		}*/
		
		ListIterator lit = list.listIterator();  //获取迭代器
		while(lit.hasNext()){ 
			String str = (String) lit.next();
			if("world".equals(str)){
				//list.add("javaee");
				lit.add("javaee");
			}
		}
		
		System.out.println(list);
	}
```



## ListIterator(List专属迭代器)
### 常用方法

* void add(E e)遍历的同时向集合中添加元素
* boolean hasNext()是否有下一个
* boolean hasPrevious()是否有前一个
* 
* Object next()返回下一个对象
* Object previous()返回上一个元素


## Vector
### 常用方法
* add(E e)
* addEmement(E e)
* Enumeration<E> elements()返回枚举值，相当于迭代器
* boolean hasMoreElement()测试此枚举是否包含更多的元素，相当于判断是否有下一元素
* E nextElement()返回枚举的下一元素

## List的三个子类的特点
* ArrayList：
	* 底层数据结构是数组，查询快，增删慢
	* 线程不安全，效率高
* Vector
	* 底层数据结构是数组，查询快，增删慢
	* 线程安全，效率低
* Vector相对ArrayList查询慢(线程安全的)
* Vector相对ArrayList增删慢(数组结构)
* LinkedList：
	* 底层数据结构是链表，查询慢，增删快
	* 线程不安全，效率高
* Vector好和ArrayList的区别
	* Vector是线程安全的，线率低
	* ArrayList是线程不安全的，效率高
	* 都是数组实现的
* ArrayList和LinkedList的区别
	* ArrayList底层是数组结构，查询和修改快
	* LinkedList底层是链表结构的，增删比较快，查询和修改比较慢。
	* 都是线程不安全的

	
* 查询多用ArrayList
* 增删多用LinkedList
* 都多ArrayList
