## 反射
### 类的加载时机与概述
* 类的加载概述
	* 当程序要加载某个类的时候，如果该类还没有被加载到内存中，则系统会通过加载，连接，初始化三步来实现对这个类进行初始化
	* 加载
		* 就是指将class文件读入内存，并为之创建一个class对象，任何类被使用时系统都会建立class对象
	* 连接
		* 验证 是否有正确的内部结构，并和其他类协调一致
		* 准备 负责为类的静态成员分配内存，并设置默认初始化值
		* 解析 将类的二进制数据中的符号引用替换为直接引用
	* 初始化 
* 加载时机
	* 创建类的实例
	* 访问类的静态变量，或者为静态变量赋值
	* 调用类的静态方法
	* 使用反射方式来强制创建某个类或接口的class对象
	* 初始化某个类的子类
	* 直接使用java命令来运行某个主类

### 类加载器的概述和分类
> 类加载器负责将.class文件加载到内存中，并生成对应的class对象，虽然我们不需要关系加载机制，但是了解这个机制我们能刚好的理解程序的运行

* 类加载器的分类
	* Bootsrtap ClassLoader 根类加载器
	* Extension ClassLoader 扩展类加载器
	* System  ClassLoader   系统类加载器
* 作用
	* Bootsrtap ClassLoader 根类加载器
		* 也被称为引导类加载器，负责Java核心类的加载
		* 比如System,String等，在JDK中lib目录下的tr.jar文件
	* Extension ClassLoader 扩展类加载器
		* 负责JRE扩展目录中的jar包的加载
		* JDK中lib目录下的ext目录
	* System  ClassLoader   系统类加载器
		* 负责JVM启动的 时候加载来自java命令的class文件以及classpath环境变量中所指定的jar包和类路径
	
### 反射
> 反射的核心是先拿到该类的字节码对象

![](http:/yingxs.com/img/java_fanshe01.png)

* clazz.newInstance()  使用空参构造创建对象

* 根据已知的参数列表获取构造函数
```
//获得有参构造
Constructor c = clazz.getConstructor(String.class,int.class)；
//通过有参构造创建对象
Person p = (Person) c.newInstance("张三",23)；

```
* 通过反射获取成员变量并使用
	* class.getField(String)方法可以获取类中指定的字段(可见的)
	* class.getDeclaedField(String) 获取私有的字段
	* Field.set(Object obj,obj val) 修改字段值
	* Field.setAccessible(true) 去除私有权限
	* Field.get(obj) 获取值
	```
	Constructor c = clazz.getConstructor(String.class,int.class)；
	Person p = (Person) c.newInstance("张三",23)；
	
	Field f = clazz.getDeclaedField("name");
	f.setAccessible(true);
	f.set(p,"李四")
	
	```
* 反射获取方法
	* class.getMethod(String,class...) 根据方法名称和参数列表获取方法
	* class.getDeclaredMethod(String,class...) 根据方法名称和参数列表获取私有方法
	* Method.invoke(String,Object ...)		调用方法并添加参数

* 反射越过泛型检查
```
@Test
public void test02() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	ArrayList<Integer> list = new ArrayList<>();
	list.add(111);
	list.add(222);
	
	Class clazz = Class.forName("java.util.ArrayList");
	Method m = clazz.getMethod("add", Object.class);
	m.invoke(list, "abc");
	
	System.out.println(list);
}
```

### 动态代理
> 在java中java.lang.reflect包下提供了Proxy类和一个InvocationHandler接口，通过使用这个类和接口就可以生成动态代理对象，JDK提供的代理只能针对接口做代理，更强大的代理cglib,Proxy类中的方法创建动态代理对象

```
public class Test {
	
	public static void main(String[] args) {
		UserImp ui = new UserImp();
		ui.add();
		ui.delete();
		System.out.println("----------------------------------");
		User u = (User) Proxy.newProxyInstance(
					ui.getClass().getClassLoader(),
					ui.getClass().getInterfaces(), 
					new MyInvocationHandler(ui)
				);
		u.add();
		u.delete();
		
		
	}
		
}

class MyInvocationHandler implements InvocationHandler{

	private Object target;
	
	public MyInvocationHandler(Object target) {
		//被代理的对象
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验");
		method.invoke(target, args);//指定被代理target对象的方法
		System.out.println("日志记录");
		
		return null;
	}
	
}
```

### 模板设计模式
> 模板方法模式就是定义一个算法的股价，而将具体的算法延迟到子类中来实现

* 优点和缺点
	* 优点
		* 使用模板方法模式，在定义算法骨架的同时，可以很灵活的实现具体的算法，满足用户灵活多变的需求
	* 缺点
		* 如果算法骨架有修改的话，则需要修改抽象类

```
public class Test {
	public static void main(String[] args) {
		long len = new Demo().getTime();
		System.out.println(len);
	}
}

abstract class GetTime{
	public final long getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public abstract void code();
}

class Demo extends GetTime{

	@Override
	public void code() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("...");
		}
	}
	
}
```

### 枚举
```
public enum Week {
	 
	MON,TUE,WED

}
enum Week2 {
	
	MON("星期一"),TUE("星期二"),WED("星期三");
	
	private String name;
	private Week2(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

enum Week3 {
	
	MON("星期一"){
		public void show() {
			System.out.println("星期一");	
		}
		
	},TUE("星期二"){
		public void show() {
			System.out.println("星期二");	
		}
		
	},WED("星期三"){
		public void show() {
			System.out.println("星期三");	
		}
		
	};
	
	private String name;
	private Week3(String name) {
		this.name = name;
	}
	
	public abstract void show();
}

```