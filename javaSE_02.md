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



## LinkedList
### 常用方法
* pulic void addFirst(E e)及addLast(E e)在第一个或最后一个位置添加元素
* public E getFirst()及getLast()获取第一个或最后一个元素并返回
* public E removeFirst()及public E removeLast()删除第一个或最后一个元素并返回
* public E get(int index)获取指定位置的元素
* 



## 泛型
* 非静态方法的泛型最好和该类的泛型一致，也可以不一致
* 静态方法的泛型必须与该类的泛型不一致
* 方法泛型定义格式：
	* public <泛型类型> 返回类型 方法名 (泛型类型 变量名)

	
## 泛型接口
	public interface 接口名<泛型>

### 泛型高级之通配符
* 泛型通配符＜？＞
	* 任意类型，如果没有明确，那就是Object以及任意类
		* List<?> list = new ArrayList<Interger>();
		* 当右边的泛型是不确定时，左边可以指定为？ 	
	* ？ extends E
		* 向下限定，E及其子类
	* ？ super E
		* 向上限定，E及其父类




## 增强型for循环
> 简化数组和Collection集合遍历
> 底层依赖迭代器

### 格式：
* for(元素数据类型 变量 ： 数组或者Collection集合){
	* 使用变量即可，该变量就是元素
* }
* 


## 三种迭代方式能否删除元素
* 普通for循环，可以删除，但是删除的同时索引要自减
* 迭代器可以删除，但是必须使用迭代器自身的remove方法，否则会出现并发修改异常
* 增强for循环不能删除元素
* 


### 静态导入
> 静态导入是导入类中的静态方法
* 格式：
	* ipmort static 包名.类名.方法名；
	* 可以直接导入到方法级别
* 方法必须是静态的，如果有多个同名静态方法，容易不知道使用谁，这时要加前缀，由此可见意义不大，一般不常用


## 可变参数
### 可变参数概述
* 定义方法时不知该定义多少个参数
### 格式
* 修饰符 返回值类型 方法名（数据类型 ... 变量名）{}
### 注意事项
* 这里的变量是一个数组
* 如果一个方法有可变参数，并且有多个参数，那么可变参数肯定定是最后一个


## 数组转集合 static <T> List <T> asList(T...a)
> 数组转换城集合
> 数组转换成集合虽然不能增加或减少元素，但是可以用集合的思想去操作数组，也就是说可以使用集合中其他方法
> 将数组传换成集合，数组必须是引用数据类型。基本数据类型的数组转换成集合，会将整个数组当做一个对象，因为集合中只能存储引用数据类型
![](http://www.yingxs.com/img/aslist.png)


## 集合转数组

* Object[] toArray()
* <T> T[]  toArray(T[] a)
* 当集合转换成数组时，数组长度如果是小于或等于集合的size时，转换后的数组长度等于集合的size，如果数组的长度大于size，分配的数组长度就和你指定的长度一样
![](http://www.yingxs.com/img/toArray.png)


## set
### Hash保证元素唯一的原理
* 1.HashSet原理
	* 当我们使用Set集合都是需要去掉重复元素的，如果在存储的时候逐个equels()比较，效率较低，哈希算法提高了去重复的效率，降低了使用equels（）方法的次数
	* 当HashSet调用add存储对象的时候，先调用对象的hasCode()方法得到一个哈希值，然后在集合中查找是否有哈希值相同的对象
		* 如果没有哈希值相同的对象就直接存入集合
		* 如果有哈希值相同的对象，就和哈希值相同的对象逐个进行equels比较，比较结果为flase就存入，true就不存
* 2.将自定义类的对象存入HashSet去重复
	* 类中必须重写hasCode()和equels()方法
	* hasCode():属性相同的对象返回值必须相同，属性不同的返回值尽量不同(提高效率)
	* equels():属性相同返回true,属性不同返回false,返回false的时候存储   

### LinkedHashSet
* 底层由链表实现，是set集合中唯一一个能保证怎么存就怎么取的集合对象
* 因为是HashSet的 子类，所以也是保证元素唯一的， 与HashSet的原理一样


## TreeSet集合
* TreeSet是用来对元素进行排序的，它也可以保证元素的唯一
* 在TreeSet集合中如何存取元素取决于compareTo方法的返回值
* 被排序类实现Comparable接口并重写compareTo方法
	* 当compareTo方法返回0的时候集合中只有一个元素
	* 当compareTo方法返回正数的时候集合怎么存怎么取
	* 当compareTo方法返回负数的时候集合倒序存储
	
### TreeSet集合排序原理
> 在TreSet集合中如何存储元素取决于compareTo()方法返回值,小的存储在左边(负数),大的存储在右边(正数)，相等就不存(0)

![](http://www.yingxs.com/img/TreeSet.png)

----------

![](http://www.yingxs.com/img/TreeSet2.png)

----------

![](http://www.yingxs.co m/img/TreeSet3.png)



## TreeSet比较器排序
> 需求：将字符串按照长度排序

```
//默认是按照字典顺序排的，传入比较器，自定义排序
TreeSet<String> ts = new TreeSet(new CompareByLen())<>;
ts.add("aaaaaa");
ts.add("fasdf");
ts.add("asd");
ts.add("fadfadfa");
System.out.println(ts)
```
```
class CompareByLen implements Comparator<String>{
	public int compare(String s1,String s2){		//按照字符串的长度比较
	int num = s1.length()-s2.length();				//长度为主要条件
		return num == 0 ? s1.compareTo(s2) : num;	//内容为次要条件
	}
}
```

## map
#### map接口和Collection接口的不同
* map是双列集合的根接口，Collection是单列结合的跟接口
* Map的键是唯一的，Collection的子体系Set是唯一的
* MAp集合的数据结构针对键有效，根治无关；Collection集合的数据结构针对元素有效
* 单例集合底层依赖双列集合


### Map功能
#### 添加
* V put (K Key , V value)添加元素
	* 相同的键不存储，只进行指覆盖，把覆盖的值返回,也就是说，如果存入的键在集合中不存在，那么返回null，当键在原本集合中存在时，覆盖值并返回被覆盖的值

#### 删除功能
* void clear()移除所有的键值对元素
* V remove(Object key)根据键删除键值对元素，并把值返回

#### 判断功能
* boolean containsKey(Object Key)判断集合是否包含指定的键
* boolean containsVal(Object value)判断集合是否包含指定的值
* Boolean isEmpty()判断集合是否为空

#### 获取功能
* Set<Map.Entry<K,V>> entryset();
* V get(Object key)根据值获取键
* Set(K) keySet()获取集合中所有值的集合
* Collection<V> values()获取集合中所有值的集合

#### 长度功能
* int size（）返回集合中的键值对的个数