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

```
//获取和设置名字
new Thread("芙蓉姐姐"){										//1.继承Thread类
	@Override											
	public void run() {								//2.重写run方法
			System.out.println(this.getName()+"...aaaaaa");
	}
}.start();											//4.开启线程


new Thread("fengjie"){										//1.继承Thread类
	@Override											
	public void run() {								//2.重写run方法
			System.out.println(this.getName()+"...bbb");
	}
}.start();										//4.开启线程
```


### 获取当前线程对象

```
new Thread(){										//1.继承Thread类
	@Override											
	public void run() {								//2.重写run方法
			System.out.println(this.getName()+"...aaaaaa");
	}
}.start();											//4.开启线程


new Thread(new Runnable(){							//1.将Runnable的子类对象传递给Thread构造方法
	public void run() {								//2.重写run方法
			System.out.println(Thread.currentThread().getName()+"...bb");		
	}
}).start();											//4.开启线程
Thread.currentThread().setName("我是主线程");
System.out.println(Thread.currentThread().getName());	
```

### 休眠线程
```
//在主线程中
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		
		for(int i = 20;i>=0;i--){
			Thread.sleep(1000);
			System.out.println("倒计时第"+i+"秒");
		}
		
	}
}
```
```
new Thread(){
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName()+"...aaaaaaa");
		}
	}
}.start();

new Thread(){
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName()+"...bb");
		}
	}
}.start();
/**运行结果
 *  Thread-0...aaaaaaa
	Thread-1...bb
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-0...aaaaaaa
	Thread-1...bb
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-0...aaaaaaa
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-1...bb
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-0...aaaaaaa
	Thread-1...bb
	Thread-0...aaaaaaa
	Thread-1...bb

 */
		
```
### 守护线程
> setDaemon(),设置一个线程为守护线程，该线程不会单独执行，当其他非守护线程都执行结束后，自动退出

```
Thread t1 = new Thread(){
	public void run() {
		for(int i = 0;i<2;i++){
			System.out.println(getName()+"...aaaaaaa");
		}
	}
};

Thread t2 = new Thread(){
	public void run() {
		for(int i = 0;i<500;i++){
			System.out.println(getName()+"...bb "+i);
		}
	}
};


t2.setDaemon(true);					//当传入true就是意味着设置为守护线程
									//当其他线程(t1)结束时,该线程自动退出

t1.start();
t2.start();
```

### 加入线程
* join()，当前线程暂停，等待指定的线程执行结束后，当前线程再继续
* join(int),可以等待指定的毫秒之后继续
```

 final Thread t1 = new Thread("线程1"){
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println(getName()+"...aaaaaaa "+i);
		}
	}
};

//匿名内部类在使用它所在的方法中的 局部变量时，该变量必须要用final修饰
Thread t2 = new Thread("线程2"){
	public void run() {
		for(int i = 0;i<10;i++){
			if(i==2){
				try {
					//t1.join();							//插队
					t1.join(1);							//指定插队的事件，过了指定的事件后，两条线程交替执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(getName()+"...bb "+i);
		}
	}
};


t1.start();
t2.start();
```

### 礼让线程
> 效果不明显，了解
```
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		
		new MyThread().start();
		new MyThread().start();
		
	}
	
}


class MyThread extends Thread {
	@Override
	public void run() {
		for(int i = 1;i<=10;i++){
			if(i%10==0){
				Thread.yield();			//让出CPU
			}
			System.out.println(getName()+"...... "+i);
		}
	}
}
```

### 线程优先级
```
Thread t1 = new Thread(){
	public void run() {
		for(int i = 0 ;i < 1000 ;i++){
			System.out.println(getName()+"....aaaa");
		}
	};
};

Thread t2 = new Thread(){
	public void run() {
		for(int i = 0 ;i < 1000 ;i++){
			System.out.println(getName()+"....bbb");
		}
	};
};

//t1.setPriority(10);							//设置最大的线程优先级
//t2.setPriority(1);							//设置最小的线程优先级

t1.setPriority(Thread.MIN_PRIORITY);		//设置最小的线程优先级
t2.setPriority(Thread.MAX_PRIORITY);		//设置最大的线程优先级


t1.start();
t2.start();
```

### 同步代码块
* 1.什么情况下需要同步
	* 当多线程并发，有多段代码同时执行时，我们希望某一段代码执行的过程中CPU不要切换到其他线程工作，这时就需要同步代码块
	* 如果两段代码是同步的,那么同一时间只能执行一段，在一段代码没有执行结束之前，不会执行另外一段代码
* 2.同步代码块
	* 使用synchronized关键字加上一个所对象来定义一段代码，这就叫同步代码块
	* 多个同步代码块如果使用相同的锁对象，那他们就是同步的 
	
```

public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		
		final Printer p = new Printer();
		new Thread(){
			public void run() {
				while(true){
					p.print1();
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					p.print2();
				}
			};
		}.start();
		
	}
	
}

class Printer {
	Demo d = new Demo();
	
	public void print1() {
		//synchronized (new Demo()) {						
		synchronized (d) {									//同步代码块，锁机制，锁对象可以是任意的
			System.out.print("y");
			System.out.print("i");
			System.out.print("n");
			System.out.print("g");
			System.out.print("x");
			System.out.print("s");
			System.out.println();
		}
		
	}
	public void print2() {
		//synchronized (new Demo()) {						//锁对象不能用匿名对象，因为匿名对象不是同一个对象
		synchronized (d) {
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
		}
		
	}
}


class Demo{}


``` 

### 同步方法
```
//非静态的同步方法
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		
		final Printer p = new Printer();
		new Thread(){
			public void run() {
				while(true){
					p.print1();
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					p.print2();
				}
			};
		}.start();
		
	}
	
}

class Printer {
	Demo d = new Demo();
	//非静态的同步方法锁对象是this
	public synchronized void print1() {						//同步方法只需要在方法上加上synchronized关键字即可
			System.out.print("y");
			System.out.print("i");
			System.out.print("n");
			System.out.print("g");
			System.out.print("x");
			System.out.print("s");
			System.out.println();
		
	}
	public void print2() {
		synchronized (this) {
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
		}
		
	}
}

class Demo{}

```

```
//静态的同步方法
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		
		final Printer p = new Printer();
		new Thread(){
			public void run() {
				while(true){
					p.print1();
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					p.print2();
				}
			};
		}.start();
		
	}
	
}

class Printer {
	Demo d = new Demo();
	//非静态的同步方法锁对象是this
	//静态的同步方法的锁对象是该类的字节码对象
	public static synchronized void print1() {						//同步方法只需要在方法上加上synchronized关键字即可
			System.out.print("y");
			System.out.print("i");
			System.out.print("n");
			System.out.print("g");
			System.out.print("x");
			System.out.print("s");
			System.out.println();
		
	}
	public static void print2() {
		synchronized (Printer.class) {
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
		}
		
	}
}

class Demo{}

```