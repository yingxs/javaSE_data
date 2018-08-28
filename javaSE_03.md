## 异常
> 异常就是Java程序在运行过程中出现的错误

#### 异常的分类
* Error
* Exception
	* RuntimeException
#### 异常的继承体系
* Throwable
	* Error
	* Exception
		* RuntimeException  
		
### JVM默认如何处理异常
* main函数接收到这个问题时，有两种处理方式
	* 自己将该问题处理，然后继续运行
	* 自己没有针对的处理方式，只有交给调用main的jvm来处理
* jvm有一个默认的异常处理机制，就将该异常进行处理
* 并将该异常的名称、异常的信息，异常出现的位置打印在了控制台上，同时程序停止运行 	
 
### 异常处理
* try{}catch{}
### 编译期异常与运行期异常的区别
* java中的异常分为两大类：编译时异常和运行时异常
* 所有的RuntimeException类及其子类的实例被称为运行时异常，其他的异常就是编译时异常
* 编译时异常：Java程序必须显示处理，否则程序就会发生错误，无法编译通过，未雨绸缪
* 运行时异常：可处理可不处理

### Throwable的几个常见方法
* getMessage() 获取异常信息，返回字符串
* toString()	获取异常类名和异常信息，返回字符串
* printStackTrace()获取异常类名和异常信息，以及异常出现在程序中的位置返回值void

### throws方式处理异常
* 定义功能方法时，需要把出现的问题暴露出来让调用者去处理
* 那么就童年过throws在方法上标识
* 编译时异常的抛出必须对其进行处理
* 运行时异常的抛出可以处理，也可以不处理

### throw的概述
> 在功能方法内部出现某种情况，程序不能继续运行，需要进行跳转，就用throw将异常对象抛出


#### throw和throws的区别
* throws
	* 用在方法声明后面，跟的是异常类名
	* 可以跟多个异常类名，用逗号隔开
	* 表示抛出异常，由该方法得到调用者来处理
* throw
	* 用在方法体内，跟的是异常对象名
	* 只能抛出一个异常对象
	* 表示抛出异常，由方法体内的语句处理
	
* final,finally,finalize的区别
	* final可以修饰类，不能被继承  
	* 修饰方法，不能被重写
	* 修饰变量，只能赋值一次，常量 
	* finally是try语句总的一个语句体，不能单独使用，用于释放资源
	* finalize是一个方法，当垃圾回收期确定不存在对该对象的更多引用时，由垃圾回收期调用此方法
	

### 自定义异常
> 通过名字区分到底是什么一场，有针对得到解决


```
class AgeOutofBoundsException extends Exception {
	/*访问父类的构造*/
	public AgeOutofBoundsException（）{
		super();
	}

	public AgeOutofBoundsException（String message）{
		super(message);
	}
}

//throw new AgeOutofBoundsException("年龄非法");


```

### 异常的注意事项
* 子类重写父类方法式，子类的方法必须抛出相同的异常或者父类异常的子类
* 如果父类抛出多个异常，子类重写父类时，只能抛出相同异常或者他的子集，子类不能抛出父类没有的异常
* 如果被重写得到方法没有抛出异常，那么子类的方法绝对不可以抛出异常，如果子类方法内有异常发生，那么子类只能try..catch不能throws



## File类
### 常用构造
* File(String pathname)根据一个路径得到File对象
* File(String parent,String child)根据一个目录和一个子文件/目录得到File对象
* File(File parent,String child)根据一个File对象和一个子文件/目录得到File对象


### 常用方法
#### 创建功能
* public boolean createNewFile()创建文件，如果存在就不创建了
* public boolean mkdir()创建文件夹，如果存在就不创建
* public boolean mkdirs()创建文件夹，如果父文件夹不存在，会帮你创建出类
#### 重命名和删除功能
* public boolean renameTo(File dest)把文件重弄命名为指定的文件路径
	* 如果路径名相同，就是改名
	* 如果路径名不同，就是改名并剪切
* public boolean delete()删除文件或文件夹
* 


#### 判断功能
* public boolean isDirectory()判断是否是目录
* public boolean isFile()判断是否是文件
* public boolean exists()判断文件或目录是否存在
* public boolean canReand()判断是否可读
* public boolean canWrite()判断是否可写
* public boolean isHidden()判断师是否隐藏
* 


#### 获取功能
* public String getAbsolutePath()获取绝对路径
* public String getPath()获取构造方法中传入的路径
* public String getName()获取名称
* public long length()获取长度，字节数
* public long lastModified()获取最后一次修改事件，毫秒值
* public String[] list()获取指定目录下所有文件或者文件夹的名称数组
* public File[] listFiles()获取指定目录下的所有文件或者文件夹的File数组
* boolean setReadable()设置为是否可读(windows认为一切文件可读，无论设置true还是false都是可读，但在linux中不一样)
*  boolean setWritable()设置为是否可写

#### 文件名过滤器
![](http://yingxs.com/img/filenamefilter.png)