### JRE与JDK
* JRE java运行环境，和java程序所需的核心类库，如果想要运行好一个开发好的java程序,计算机中只需要安装JRE即可
* JDK java开发工具包
* JDK是提供给java开发人员使用的,其中包含了java的开发工具也包含了JRE，所以安装了JDK，就不用单独安装JRE了,其中的开发工具：编译工具(javac.exe),打包工具(jar.exe)等
* 简单而言：使用JDK开发完成的java程序，交给JRE去运行
* 简而言之：
	* JRE：JVM+类库
	* JDK：JRE+JAVA的开发工具 

### JDK安装路径下的目录
* bin:该目录用于存放一些可执行程序
	* javac.exe java编译器
	* java.exe java运行工具
	* javadoc.exe 文档生成工具
* db:db目录是一个小型的数据库，从jdk6.0开始，java中引用了一个新成员javaDB,这是一个纯java实现、开元的数据库管理系统，这个数据库不仅轻便，而且支持JDBC4.0的所有规范,在学习JDBC时候，不需要额外安装数据库软件，直接选择javaDB即可
* jre:java运行环境，此目录是java运行时环境的根目录，它包含java虚拟机,运行时类包，java应用启动器以及一个bin目录，但不包含开发环境中的开发工具
* inclide:由于JDK是通过C和C++实现的，因此在启动的时候需要引入一些C语言的头文件，该目录就是用于存放这些头文件的
* lib:library的缩写，意为java类库或库文件，是开发工具使用的归档包文件
* src.zip文件：src.zip为src文件夹的压缩文件，src中放置的是JDK核心类的源代码,通过该文件可以查看java基础类的源代码

### 任意进制到十进制互转
```
System.out.println(0b100);			//二进制表示形式前面加0b(b可以大写也可以小写)
System.out.println(0100);			//八进制表示形式前面加0
System.out.println(100);
System.out.println(0x100);			//十六进制表示形式前面加0x
```
* 基数：转换为X进制，基数就是X
* 权：自右向左从0开始数字依次递增编号
* 结果：系数*基数的全次幂


### 反码与补码
* 源码
	* 二进制定点表示法，最高位为符号位，0表示正，1表示负；其余位表示数值大小
	* 通过一个字节，也就是8个二进制位表示+7和-7
	* 0(符号位) 0000111
	* 1(符号位) 0000111
* 反码
	* 正数的反码与其源码相同
	* 负数的反码是对原码逐位取反，但符号位除外
* 补码
	* 正数的补码与其原码相同
	* 负数的补码是在其反码的末尾加1

### 数据类型转换
* 隐式转换
	* 小的数据类型和大的数据类型机型运算时，小的数据类型会自动转换为大的数据类型    
* 强制转换
	```
		int x = 3;
		byte b = 4;
		b = (byte) (x + b);
		System.out.println(b);
	``` 
* 强制转换超出范围
	```
		byte b = (byte)(126+4);
		System.out.println(b);				//-126

	
		/*
			130  -> 00000000 00000000 000000000 10000010
			当去掉前三个8位的时候就成了 10000010  -> -126补码
									 10000001  -> 减1求-126反码
								     11111110  -> -126的原码
		*/		

		byte b2 = (byte)300;
		System.out.println(b2);				//44

		/*
			300   ->   0000000 0000000 00000001 00101100
			当去掉前三个8位的时候就成了 00101100  -> 44的补码
										    
			
		*/
        			

	```
### 面试题
```
	//看下面的程序是否有问题，如果有问题，请指出并说明理由
	byte b1 = 3;
	byte b2 = 4;
	byte b3 = b1 + b2;
	System.out.println(b3);

	/*
		解释1：byte和byte(short,char)进行运算的时候会提升为Int,两个int相加的结果也是int类型
		解释2：b1和b2是两个变量，变量存储的值是变化的，在编译的时候无法判断里面具体得到值，相加有可能会超出bute的取值范围
	*/

	byte b4 = 3 + 4;			//java编译器有常量优化机制
	System.out.println(b4);

```

### long与float取值范围比较
* 进行混合运算的时候,byte,short,char不会相互转换，都会自动提升为int，其他类型进行混合运算的是小的类型提升为大的
* byte,short,char -> int -> long ->float -> fouble
* long:8字节
* float：4字节
* 4字节是32个二进制位，一位是符号位，8位是指数位，23位是尾数位
```
//看下面得到程序是否有问题，有问题，请指出
short s=1; s=s+1;		//编译出错，当short与int进行运算时，会提升为int
short ss=1;ss+=1;		//正常   s = (short)(s+1);
```


### 数组
* 数组的定义

```
	//动态初始化
	int[] arr = new int[5];
	
	/*
	左边:
		int : 数据类型
		[]  : 代表的数组，几个中括号就是几位数组
		arr : 合法的标识符
	右边：
		new : 创建新的实体或对象
		int : 数据类型
		[]  : 代表的数组
		 5  : 代表数组的长度
	*/
	//静态初始化
	/*
	格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2};
	简化格式：数据类型[] 数组名 = {元素1,元素2}; //声明和赋值必须在同一行
	*/
	
	//可行
	int[] arr;
	arr = new int[]{11,22,33,44,55};
	
		//不可行,简写形式，声明和赋值必须在同一行
	int[] arr2;
	arr2 = {11,22,33,44,55};

```

* 整数类型：byte,short,int,long默认初始化值都是0
* 浮点类型：float,double默认初始化值都是0.0
* 布尔类型：boolean默认初始化值false
* 字符类型：char默认初始化值'\u0000'
* 内存划分：
	* 栈：存储局部变量
	* 堆：存储new出来的数组或对象
	* 方法区：面向对象部分讲解
	* 寄存器：给CPU使用 


### static关键字
* 未加静态
![](http://yingxs.com/img/javase_static1.png)
* 加静态
![](http://yingxs.com/img/javase_static2.png)

### static关键字的特点
* 随着类的加载而加载
* 优先于对象存在
* 被类的所有对象共享
* 可通过类名调用 
	* 静态修饰的内容一般称其为:与类相关的，类成员，类方法 
* 共享用静态，特性用非静态

### static静态的注意事项
* 在静态方法中是没有this关键字的
	* 静态是随着类的加载而加载，this是随着对象的创建而存在 
	* 静态比对象先存在
* 静态方法只能访问静态的成员变量和静态的成员方法
	*  静态只能访问静态

### 静态变量和成员变量的区别
* 静态变量也叫类变量 成员变量也叫对象变量
* 所属不同
	* 静态变量属于类，所以也称为类变量
	* 成员变量属于对象，所以也称为对象变量或者实例变量
* 内存中位置不同
	* 静态变量存储于方法区的静态区
	* 成员变量存储于堆内存
* 内存出现的时间不同
	* 静态变量随着类的加载而加载，随着类的消失而消失
	* 成员变量随着对象的创建而存在，随着对象的小时而消失
* 调用不同
	* 静态变量可以通过类名调用，也可以通过对象调用
	* 成员变量只能通过对象名调用    
	

### main的详细解释
* public  被jvm调用，所以权限要足够大
* static  被jvm调用，不需要创建独享，直接类名.调用即可
* void	  被jvm调用，不需要有任何返回值
* main    只有这样写才能被jvm识别,main不是关键字
* string[] args:以前是用来接受键盘录入的

### 类说明书
* 对工具类加入文档注释
	* @author (作者信息)
	* @version 版本信息
	* @param   参数信息
	* @return  返回值
	* @param   参数名称，形式参数的变量名称
* 通过javadoc命令生成说明书
	* javadoc -d 指定生成的文件目录 -author -version ArrayTool.java 

### 代码块概述
* 局部代码块
	* 在方法中出现；限定变量的生命周期，及早释放，提高内存利用率 
	```
		public static void main(String[] args) {
			{
				int x = 10;					//限定变量的生命周期
				System.out.println(x);
			}
		}
	```
* 构造代码块
	* 在类中方法外出现；多个构造方法中相同的代码存放到一起，每次调用构造都执行，并在构造方法之前执行 
* 静态代码块
	* 在类中方法外出现，加上了static修饰
	* 用于类初始化，在加载的时候就执行，并且只执行一次，一般用于加载驱动
	* 静态代码块优先于主方法之前执行 
* 同步代码块(多线程)


### 继承的好处和弊端
* 好处
	* 提高了代码的复用性
	* 提高代码的维护性
	* 让类与类之间产生了关系，是多态的前提
* 继承的弊端
	* 累的耦合性增强了

* 开发的原则：高内聚，低耦合
* 耦合：类与类之间的关系
* 内聚：类自己的完整性、独立性
   
### java中类的继承特点
* Java值支持单继承，java支持多层继承
* 如果想用这个体系的所有功能用底层的类创建对象
* 如果想看这个体系的共性功能，看最顶层的类

### 继承的注意事项
* 子类只能继承父类所有非私有的成员(成员方法和成员变)
* 子类不能继承父类的构造方法，但是可以通过super关键字去访问父类的构造方法
* 不要为了部分功能而去继承
* 同名的变量
	* 子父类出现同名的变量只是在讲课中举例子有，在开发中是不会出现这种情况的
	* 子类继承父类就是为了使用父类的成员，那么如果定义了同名的成员变量就没有意义了
	
### this和super的区别和应用
* this代表当前对象的引用
* super代表当前对象父类的引用
* this和super在使用上的区别
	* 调用成员变量
		* this 可调用本类的成员变量，也可以调用父类的成员变量
		* super 调用父类的成员变量
	* 调用构造方法
		* this(...) 调用本类的构造方法
		* super(...) 调用父类的成员方法
	* 调用成员方法
		* this 可调用本类的成员方法，也可以调用父类的成员方法
		* super 调用父类的成员方法  
		
### 继承中构造方法的关系	   
* 子类中所有的构造方法默认都会访问父类中空参的构造方法
	* 因为子类会继承父类中的数据，可能还会使用父类的数据
	* 所以，子类初始化之前，一定要先完成父类的初始化 
* 其实，没一个构造方法的第一条语句默认都是super() Object类第最顶层的类
* 父类中没又无参构造，子类怎么办
	* super(...)解决,在子类中用super访问父类的有参构造
	* this(...)解决，在子类无参构造里用this(..)访问子类有参构造，进而访问父类有参构造 

### 方法重写的注意事项
* 父类中私有方法不能被重写，因为私有方法根本无法继承
* 子类重写父类方法时，访问全向不能更低，最好一致
* 父类静态方法，子类也必须通过静态方法进行重写，其实算不上重写(多态讲解)


### final概述
* final 最终的
* final修饰特点
	* 修饰类，类不能被继承
	* 修饰变量，变量就成了常量，只能赋值一次
	* 修饰方法，方法不能被重写  

### final修饰局部变量
* 基本类型，是值不能被改变
* 引用数据类型，是地址值不能被改变，对象中的属性可以改变

### final修饰的变量初始化的时机
* 显示初始化
```
	final int num = 10;			//显示初始化，成员变量的默认初始化值是无效值

```
* 在对象构造时初始化值
```
	final int num;
	public Demo(){
		num = 10;
	}
```

### 多态前提
* 要有继承关系
* 要有方法重写
* 要有父类引用指向子类对象


### 多态中成员的访问特点

* 成员变量
	* 编译看左边(父类)，运行看左边(父类)
* 成员方法
	* 编译看左边(父类)，运行看右边(子类)，动态绑定
* 静态成员方法
	* 编译看左边(父类)，运行看左边(父类)
	* 静态和类相关，算不上重写，所以，访问还是左边的，只有非静态的成员方法，编译看左边，运行看右边

父类引用指向子类对象是向上转型

### 多态的好处和弊端
* 好处
	* 提高了代码的维护性(继承保证)
	* 提高了代码的拓展性(多态保证)
	* 可以当做形式参数，接受任意类型的子类对象
* 弊端
	* 不能使用子类特有的属性和行为  


### 抽象概述
* 抽象类特点
	* 抽象类和抽象方法必须用abstract关键字修饰
		* abstract class 类名{}
		* public abstract void eat();s
	* 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类或接口
	* 抽象类不能实例化，按照多态的方式，有具体的子类实例化，这也是多态的一种，抽象类多态
	* 抽象类的子类，要么是抽象类，要么实现抽象类中所有抽象方法  

### 抽象类成员特点
* 抽象类的成员特点
	* 成员变量：既可以是变量，也可以是常量，abstract不能修饰成员变量 
	* 有构造方法，用于子类访问父类数据的初始化
	* 成员方法：既可以是抽象的，也可以说非抽象的
* 抽象类的成员方法特性：
	* 抽象方法，强制要求子类实现
	* 非抽象方法，子类继承，提高代码复用性 
	

* 一个抽象类如果没有抽象方法，可不可以定义为抽象类？如果可以，有什么意义？
	* 可以，这么做的目的只有一个，就是不让其他类创建本类对象，交给子类完成
* abstract不能和final,static,private共存
	*  被abstract修饰的方法没有方法体
	*  被static修饰的可以用类名.调用，但是类名.调用抽象方法是没有意义的
	*  被abstract修饰的方法强制子类重写
	*  被final修饰的方法不让自类重写，所以他两是矛盾的
	*  被abstract修饰的方法是为了让子类看到并强制重写
	*  被private修饰不让子类访问，所以矛盾
	

### 接口
* 接口的子类
	* 可以是抽象类，但是意义不大
	* 可以是具体类。但是要重写接口中所有的抽象方法
	* 接口中所有方法都可以是抽象的 
	
### 接口的成员特点
* 成员变量：只能是常量，并且是静态的公共的
	* 默认修饰符：public static final
	* 建议手动给出修饰符
* 构造方法：接口没有构造方法
* 成员方法：只能是抽象方法
	* 默认修饰符：public abstract
	* 建议手动给出修饰符  
	
### 类与类，类与接口，接口与接口的关系
* 类与类
	* 继承关系，只能单继承，可以多层继承
* 类与接口
	* 实现关系，可以单实现，也可以多实现
	* 并且还可以继承一个类的同时实现多个接口
* 接口与接口
	* 继承关系，可以单继承，也可以多继承   
	
### 抽象类与接口的区别
##### 成员区别
* 抽象类：
	* 成员方法：可以是变量，也可以是常量
	* 构造方法：有
	* 成员方法：可以抽象，也可以非抽象
* 接口：
	* 成员变量：只可以是常量，静态
	* 成员方法：只可以抽象 
##### 关系区别
* 类与类
	* 继承，单继承
* 类与接口
	* 实现，单实现，多实现
* 接口与接口
	* 继承，单继承，多继承

##### 设计理念区别
* 抽象类：被继承体现的是"is a"的关系，抽象类中定义的是该继承体系的共性功能
* 接口 ：被实现体现的是"like a"的关系，接口中定义的是该继承体系的扩展功能   



### 权限修饰符
```

			   本类 		   同一个包下(子类和无关类)		不同包下(子类)	不同包下(无关类)
private			Y				
默认				Y				Y
protected		Y				Y							Y
public 			Y				Y							Y				Y

```

### 内部类

内部类访问特点：
* 内部类可以直接访问外部类的成员，包括私有
* 外部类要访问内部类的成员，必须创建对象
* 外部类名.内部类名 变量名 =  外部类对象.内部类对象


```
class Demo1_InnerClass {
	public static void main(String[] args){
		Outer.Inner oi = new Outer().new Inner();	//创建内部类对象
	}
}

class Outer {
	class Inner {
		public void method(){
			System.out.println("Hello World!");
		}
	}
}
```

### 成员内部类私有
```

public class Test {
	public static void main(String[] args) {
//		Outer.Inner oi = new Outer().new Inner();
//		oi.method();
		
		Outer o = new Outer();
		o.print();
	}
	
}


class Outer {
	private int num = 10;
	private class Inner {
		public void method(){
			System.out.println("Hello World!");
		}
	}
	
	
	public void print(){
		Inner i = new Inner();
		i.method();
	}
}
```


### 静态成员内部类
```

public class Test {
	public static void main(String[] args) {
		//外部类名.内部类名 对象名 = 外部类名.内部类对象
		Outer.Inner oi = new Outer.Inner();
		oi.method();
		
		Outer.Inner2.print();
	}
	
}


class Outer {
	static class Inner {
		public void method(){
			System.out.println("method");
		}
	}
	static class Inner2 {
		public static void print(){
			System.out.println("print");
		}
	}
}
```

### 题目
```

public class Test {
	public static void main(String[] args) {
		Outer.Inner oi = new Outer().new Inner();
		oi.show();
		
	}
	
}


class Outer {
//内部类之所以能获取到外部类的成员，是因为他能获取到外部类的引用 -> 外部类名.this
	public int num = 10;
	class Inner {
		public int num = 20;
		public void show(){
			int num = 30;
			System.out.println(num);
			System.out.println(this.num);
			System.out.println(Outer.this.num);
		}
	}

}
```

### 局部内部类访问局部变量
* 局部内部类访问局部变量必须用final修饰
* 局部内部类在访问它所在的方法中的局部变量时，局部变量必须用final修饰,为什么？
	* 因为当调用这个方法时，局部变量如果没有用final修饰，他的生命周期和它的方法的生命周期是一样的，当方法弹栈，这个局部变量也会消失 ，那么如果局部内部类对象还没有马上消失想用这个局部变量，而这个变量已经没有了，如果用final修饰会在类加载的时候进入常量池，即使方法弹栈，常量池的常量还在，也可以继续使用，但是jdk1.8没有这个要求
```
public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}
	
}

class Outer {
	public void method(){
		final int num = 10;
		class Inner {
			public void print(){
				System.out.println(num);
			}
		}
		
		Inner i = new Inner();
		i.print();
	}
}
```


### 匿名内部类
* 匿名内部类是局部内部类的一种，因此匿名内部类必须写在方法中
* 本质：
	* 是一个继承了该类或者实现了该接口的子类匿名对象 
```
//非匿名的内部类
public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}
	
}

interface Inter {
	public void print();
}


class Outer {
	class Inner implements Inter {
		public void print(){
			System.out.println("print");
		}
	}
	
	public void method(){
		Inner i = new Inner();
		i.print();
	}
	
	
}
```


```
//匿名内部类
public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}
	
}

interface Inter {
	public void print();
}


class Outer {
	class Inner implements Inter {
		public void print(){
			System.out.println("print1");
		}
	}
	
	public void method(){
//		Inner i = new Inner();
//		i.print();
		new Inter(){			//实现Inter接口,Inter的子类对象
			public void print() {
				System.out.println("print");//重写抽象方法
			}
		}.print();
		
	}
	
	
}
```

### 匿名内部类重写多个方法调用
```

public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}
	
}

interface Inter {
	public void show1();
	public void show2();
}

//匿名内部类最好只针对重写一个方法的时候使用
class Outer {
	public void method(){
		Inter i  = new Inter(){			//实现Inter接口,Inter的子类对象,父类引用指向子类对象，弊端：无法使用子类特有的方法
			public void show1() {
				System.out.println("show1");
			}
			public void show2() {
				System.out.println("show2");
			}
			/*public void show3() {
				System.out.println("show3");
			}*/
			
			
		};
		
		i.show1();
		i.show2();
//		i.show3();		//匿名内部类是不能向下转型的，因为没有子类类名
		
	}
	
	
}
```

### 匿名内部类在开发中的应用
```

public class Test {
	public static void main(String[] args) {
		//如何使用PersonDemo中的method方法呢
		PersonDemo pd = new PersonDemo();
		pd.method(new Person(){			//匿名内部类当做参数传递(本质把匿名内部类当做一个对象)
			public void show() {
				System.out.println("show");
			}
		});
	}
	
}

//这里写抽象类，接口都行
abstract class Person {
	public abstract void show();
}

class PersonDemo {
	public void method(Person p){
		p.show();
	}
}
```

