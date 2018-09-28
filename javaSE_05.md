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

### 线程安全
```
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}
	
}

class Ticket extends Thread {
	private static  int ticket = 100;
	@Override
	public void run() {
		while(true){
			synchronized (Ticket.class) {
				
					if(ticket <= 0){
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+"这是第"+ ticket-- +"号票");
				}
		}
		
	}
	
}

```

```
public class Test {
	
	public static void main(String[] args) throws InterruptedException  {
		MyTicket mt = new MyTicket();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
	}
	
}

class MyTicket implements Runnable { 

	private int ticket = 1000;
	
	public void run() {
		while(true){
			synchronized (this) {
				
					if(ticket <= 0){
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"这是第"+ ticket-- +"号票");
				}
		}
	}
}

```

### 死锁
> 同步代码块不要嵌套


### 线程安全类回顾
* Vector是线程安全的，ArrayList是线程不安全的
* StringBuffer实现是线程安全的，StringBulider是线程不安全的
* Hashtable是线程安全的，HashMap是线程不安全的



### 单例设计模式
> 单例设计模式：保证内存中只有只有一个对象

#### 饿汉式
* 1.私有构造方法，在外部不能访问该类构造
* 2.创建本类私有对象
* 3.对外提供get方法
```
//饿汉式
public class Test {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1==s2);
	}
}

class Singleton{
	//1.私有构造方法，在外部不能访问该类构造
	private Singleton(){}
	//2.创建本类私有对象
	private static Singleton s = new Singleton();
	//3.对外提供get方法
	public static Singleton getInstance() {
		return s;
	}
}
```
```
//懒汉式，多线程时有安全隐患
class Singleton{
	//1.私有构造方法，在外部不能访问该类构造
	private Singleton(){}
	//2.声明一个引用
	private static Singleton s ;
	//3.对外提供get方法
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}
}

```

```
//第三种
class Singleton{
	//1.私有构造方法，在外部不能访问该类构造
	private Singleton(){}
	//2.声明一个引用
	public final static Singleton s = new Singleton() ;
}
```

#### 区别
* 1.饿汉式是空间换时间，懒汉式是时间换空间
* 2.多线程访问时，饿汉式不会创建多个对象，而懒汉式有可能会创建多个对象
* Runtime就是一个单例类，可执行字符串(DOS)命令

### Timer 定时器
```
public class Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		Timer t = new Timer();
		
		//t.schedule(new MyTimerTask(), new Date(118,8,16,22,25,40));	//指定时间执行指定任务,第一个参数是任务，第二个参数是时间，第三参数是间隔时长(毫秒值)
		t.schedule(new MyTimerTask(), new Date(118,8,16,22,25,40),3000);//指定时间执行指定任务，并在第一次执行完毕后，间隔执行
		while(true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}
}

class MyTimerTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("背单词");
	}
}

```


## 线程通信
### 两个线程间的通信
* 1.什么时候需要通信
	* 多个线程并发执行时，在默认情况下CPU是随机谢欢线程的
	* 如果我们希望他们有规律的执行，就可以使用线程通信，例如每个线程执行一次打印
* 2.怎么通信
	* 如果希望线程等待，就调用wait()
	* 如果希望唤醒等待的线程，就调用notify()
	* 这两个方法必须在同步代码中执行，并且使用同步锁对象来调用  
```
public class Demo1_Notify {
	public static void main(String[] args) {
		final Printer p = new Printer();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
}

class Printer {
	private int flag = 1;
	//非静态的同步方法锁对象是this
	//静态的同步方法的锁对象是该类的字节码对象
	public  void print1() throws Exception {						//同步方法只需要在方法上加上synchronized关键字即可
			synchronized (this) {
				if(flag != 1) {
					this.wait();
				}
				System.out.print("y");
				System.out.print("i");
				System.out.print("n");
				System.out.print("g");
				System.out.print("x");
				System.out.print("s");
				System.out.println();
				flag = 2;
				this.notify();
			}
	}
	public  void print2() throws Exception {
		synchronized (this) {
			if( flag != 2 ) {
				this.wait();
			}
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
			flag = 1;
			this.notify();
		}
		
	}
}
```

### 三个线程间通信
```
public class Demo2_NotifyAll {
	public static void main(String[] args) {
		final Printer2 p = new Printer2();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print3();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
	}
}
class Printer2 {
	private int flag = 1;
	//非静态的同步方法锁对象是this
	//静态的同步方法的锁对象是该类的字节码对象
	public  void print1() throws Exception {						//同步方法只需要在方法上加上synchronized关键字即可
			synchronized (this) {
				while(flag != 1) {
					this.wait();
				}
				System.out.print("y");
				System.out.print("i");
				System.out.print("n");
				System.out.print("g");
				System.out.print("x");
				System.out.print("s");
				System.out.println();
				flag = 2;
				this.notifyAll();
			}
	}
	public  void print2() throws Exception {
		synchronized (this) {
			while( flag != 2 ) {
				this.wait();
			}
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
			flag = 3;
			this.notifyAll();
		}
		
	}
	
	public  void print3() throws Exception {
		synchronized (this) {
			while( flag != 3 ) {
				this.wait();
			}
			System.out.print("w");
			System.out.print("w");
			System.out.print("w");
			System.out.println();
			flag = 1;
			this.notifyAll();
		}
		
	}
}
```

* 1.在同步方法中，用哪个对象锁就用哪个对象调用wait方法
* 2.为什么wait方法和notify方法定义在Object类中
	* 锁对象可以是任意对象，Object是所有对象的超类
* 3.sleep和wait方法的区别
	* sleep方法必须传入参数，参数为时间，时间到了自动醒来
	* wait方法 可传参可不传参，传入参数在参数的时间后的鞥带，不传入参数就是直接等待
	* sleep方法在同步函数或同步代码块中不释放锁
	* wait方法在同步函数和同步代码块中释放锁
	

### 互斥锁(JDK1.5)
#### 同步
* 使用RenntrantLock类的lock()和unlock()方法进行同步
#### 通信
* 使用RenntrantLock类的newCondition()方法可以获取Condition对象
* 需要等待的时候使用Condition的await()方法，唤醒的时候用signal()方法
* 不同的线程使用不同的Condition,这样就能区分唤醒的时候找哪个线程了
```
public class Demo3_RenntrantLock {
	public static void main(String[] args) {
		final Printer3 p = new Printer3();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print3();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
	}
}


class Printer3 {
	private ReentrantLock r = new ReentrantLock();
	private Condition c1 = r.newCondition();
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();
	
	private int flag = 1;
	//非静态的同步方法锁对象是this
	//静态的同步方法的锁对象是该类的字节码对象
	public  void print1() throws Exception {						//同步方法只需要在方法上加上synchronized关键字即可
			r.lock();//获取锁
				if(flag != 1) {
					c1.await();
				}
				System.out.print("y");
				System.out.print("i");
				System.out.print("n");
				System.out.print("g");
				System.out.print("x");
				System.out.print("s");
				System.out.println();
				flag = 2;
				c2.signal();
			r.unlock();//释放锁
	}
	public  void print2() throws Exception {
		r.lock();//获取锁
			if( flag != 2 ) {
				c2.await();
			}
			System.out.print(".");
			System.out.print("c");
			System.out.print("o");
			System.out.print("m");
			System.out.println();
			flag = 3;
			c3.signal();
		r.unlock();//释放锁
		
	}
	
	public  void print3() throws Exception {
		r.lock();//获取锁
			while( flag != 3 ) {
				c3.await();
			}
			System.out.print("w");
			System.out.print("w");
			System.out.print("w");
			System.out.println();
			flag = 1;
			c1.signal();
		r.unlock();//释放锁
		
	}
}
```

## 线程组
* Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，Java允许程序直接对线程组进行控制
* 默认情况下，所有的线程都属于主线程组
	* public final ThreadGroup getThreadGroup()	通过线程对象获取他所属于的组
	* public final String getName()			通过线程组对象获取组名
* 给线程设置分组
	* 1.ThreadGroup(String name) 创建线程组对象并给其复制名字
	* 2.创建线程对象
	* 3.Thread(ThreadGroup group,Runnable target,String name)
	* 4.设置整组的优先级或者守护线程   
	
```
MyRunnable mr = new MyRunnable();
Thread t1 = new Thread(mr, "张三");
Thread t2 = new Thread(mr, "李四");

ThreadGroup tg1 = t1.getThreadGroup();
ThreadGroup tg2 = t2.getThreadGroup();
System.out.println(tg1.getName());		//main
System.out.println(tg2.getName());		//main
```

```
ThreadGroup tg = new ThreadGroup("我是一个新的线程组");		//创建新的线程组
MyRunnable mr = new MyRunnable();						//创建Rnnable的子类对象

Thread t1 = new Thread(tg,mr,"张三");						//将线程放在组中
Thread t2 = new Thread(tg,mr,"李四");

System.out.println(t1.getThreadGroup().getName());
System.out.println(t2.getThreadGroup().getName());

```

### 线程的物种状态
* 线程的生命周期
	* 新建：创建线程对象
	* 就绪：线程对象已经启动了，但是没有获取到CPU的执行权
	* 运行：获取到CPU的执行权
	* 阻塞：没有CPU的执行权，回到就绪状态
	* 死亡：程序运行完毕，线程消亡
	![](http://yingxs.com/img/threa_more.png) 


### 线程池
> JDK5新增了一个Executors工厂类来产生线程池，有如下几个方法
* public static ExecutorService newFixedThreadPool(int nThreads)
* public static ExecutorService newSingleThreadExecutor()
	* 这些方法返回值是一个ExecutorService，该线程表示一个线程池对象，可以执行Runnable对象或者Callable对象代表的线程，提供了如下方法
		* Futurn<?> submit(Runnable task)
		* <T> Futurn<T> submit(Callable<T> task)
```
//简单的线程池
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
		pool.submit(new MyRunnable());	//将线程放进池子里并执行
		pool.submit(new MyRunnable());
//		pool.shutdown();			//关闭线程池
	}
	
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i = 0 ;i < 1000 ;i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
	
}
```

#### 线程池&&多线程实现的第三种方式
```
public class Demo6_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
		Future<Integer> f1 = pool.submit(new MyCallable(100));	//将线程放进池子里并执行
		Future<Integer> f2 = pool.submit(new MyCallable(50));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		
		pool.shutdown();			//关闭线程池
	}
}

class MyCallable implements Callable<Integer>{

	private int num;
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1 ;i <= num ; i++) {
			sum += i;
		}
		return sum;
	}
}
```

### 简单工厂模式
> 简单工厂模式又叫静态方法模式，它定义一个具体的类负责创建一些类的实例

* 优点
	* 客户端不需要负责对象的创建，从而明确了个各类的职责
* 缺点
	* 这个静态工厂类负责所有对象的创建，如果有新的对象增加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利于后期的维护
