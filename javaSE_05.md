### 多线程
* 什么是线程
	* 线程是程序执行的一条路径，一个进程中可以包含多条线程
	* 多线程并发执行可以提高程序的效率，可以同时完成多项工作
* 多线程的应用场景
	* 迅雷同时开启多条线程一起下载
	* QQ同时和多个人一起视频
	* 服务器同时处理多个客户端请求 
### Java
* Java命令会启动Java虚拟机，启动JVM，等于启动了一个应用程序，也就是启动了一个进程，该进程会自动启动一个“主线程”，然后主线程去调用某个类的main方法
* Jvm的启动时多线程的吗
	* JVM至少启动了辣鸡回收线程和朱现车呢个，所以是多线程的  
```
//证明JVM是多线程
public class Test {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		for(int i = 0 ; i < 1000000 ; i++){
			new Demo();
		}
		
		for(int i = 0 ; i < 10000 ; i++){
			System.out.println("主线程...");
		}
		
	}
	
}

class Demo {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("垃圾清扫了");
	}

	
}

```

### Java实现多线程
```
//实现方式1
public class Test {
	
	public static void main(String[] args)  {
		MyThread mt = new MyThread();				//4.创建Thread的子类对象
		mt.start();									//5.开启线程
		
		for(int i = 0 ; i < 1000 ;i++){
			System.out.println("bb");
		}
		
	}
	
}

class MyThread extends Thread {						//1.继承Thread
	public void run() {								//2.重写run()方法
		for(int i = 0 ; i < 1000 ;i++ ) {			//3.将要执行的代码写在run方法中
			System.out.println("aaaaaa");
		}
	}
}

```

```
//实现方式2
public class Test {
	
	public static void main(String[] args)  {
		MyRunnable mr = new MyRunnable();				//4.创建Runnable的子类对象
		Thread t = new Thread(mr);						//5.将其当做参数传递
		t.start();										//6.开启线程
		
		for(int i = 0 ; i < 1000 ;i++){
			System.out.println("bb");
		}
		
	}
	
}

class MyRunnable implements Runnable  {						//1.定义一个类实现Runnable
	
	public void run() {										//2.重写run方法
		for(int i = 0 ; i < 1000 ;i++){					//3.将要执行的代码写在run方法中
			System.out.println("aaaaaaaaaa");
		}
		
	}
}


```

### 两种实现方式的区别
* 源码来看：
	* 继承Thread类的构造函数，传递了Runnable接口的引用
	* 实现Runnable:构造函数中传入了Runnable的引用，成员变量记住了它，start()调用run()方法时内部判断成员变量Runnable的引用是否为空，不为空时看的是Runnable的run(),运行时执行的是子类run()方法

* 继承Thread
	* 可以直接使用Thread类中的方法，代码简单
	* 如果有了父类，就不能使用这种方法
* 实现Runnable接口
	* 即使自己定义的线程类有了父类也没有关系，因为有了父类也可以实现接口，而且接口是可以多实现的
	* 不能直接使用Thread中的方法需要先获取到线程对象后，才能得到Thread的方法，代码复杂   

### 匿名内部类实现多线程
```
//继承Thread
new Thread(){										//1.继承Thread类
	@Override											
	public void run() {								//2.重写run方法
		for(int i = 0 ; i < 1000 ; i++){			//3.将要执行的代码写在run方法中
			System.out.println("aaaaaa");
		}
	}
}.start();											//4.开启线程
	
```

```
//实现Runnable接口
new Thread(new Runnable(){							//1.将Runnable的子类对象传递给Thread构造方法
	public void run() {								//2.重写run方法
		for(int i = 0 ; i < 1000 ; i++){			//3.将要执行的代码写在run方法中	
			System.out.println("bb");		
		}
	}
}).start();											//4.开启线程
		
```