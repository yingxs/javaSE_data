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