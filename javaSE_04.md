# IO流
* 字节流的抽象父类
	* InputStream字节输入流所有类的超类
	* OutputStream字节输出流所有类的超类
* 字符流的抽象父类
	* Reader字符输入流
	* Writer字符输出流
	
### FileInputStream
![](http://yingxs.com/img/fileInputStream.png)
* read()方法读取的是一个字节，返回值为什么不是int而是byte？
> 因为字节数入流可以操作任意类型的文件，比如图片音频，这些文件底层都是用二进制形式存储的，如果每次都返回byte，有可囊在读到文件中间的时候遇到11111111而11111111是byte类型的-1，程序就会中断，所以在读取的时候用int类型接收如果是11111111会在前面补上24个0凑足4个字节，那么byte类型的-1就变成int类型的255了 这样就可以保证整个数据读完，而结束标记的-1就是int类型的


### FileOutputStream
> FileOutputStream创建对象的时候，如果没有这个文件，会自动创建出来，如果有这个文件就会先将文件清空，再写入，实现追加可使用 new FileOutputStream("yyy.txt",true)；实现追加
![](http://yingxs.com/img/fileOutputStream.png)

### 拷贝
* 逐个字节拷贝，效率太低
![](http://yingxs.com/img/copyimg1.png)

* 一次性拷贝，可能会导致内存溢出
	* available() 读取到文件的所有字节数，也就是说获取文件多少字节；
	![](http://yingxs.com/img/copyimg2.png)
	
* 小数组拷贝
	![](http://yingxs.com/img/copyimg3.png)


### BufferInputStream
![](http://yingxs.com/img/bufferinputstream1.png)
* 原理图
![](http://yingxs.com/img/bufferinputstream2.png)


### flush()和close()的区别
* close()
	* 具备刷新的功能 ，在关闭流之前会刷新一次缓冲区，将缓冲区剩余的字节全都刷新到文件上，再关闭流；close()方法刷新完之后就不能再写入了
* flush()
	* 具备刷新的功能，刷完之后还可以继续写 


### 字节流读写中文
* 字节流读取中文的问题
	* 字节流在读取中文的时候可能会独到半个中文，造成乱码
![](http://yingxs.com/img/io_ch1.png)

----------

![](http://yingxs.com/img/io_ch2.png)
* 字节流写出中文的问题
	* 字节流直接操作的是字节，所以写出中文必须将字符串转换成字节数组
	* 写出回车换行write("\r\n".getBytes());  
![](http://yingxs.com/img/io_ch3.png)

### IO流的标准异常处理代码
```
//jdk1.6
FileInputStream fis = null;
FileOutputStream fos = null;

try {
	fis = new FileInputStream("xxx.txt");
	fos = new FileOutputStream("xxx.txt");
	
	int b;
	while( (b = fis.read()) != -1 ){
		fos.write(b);
	}
} finally{
	//try...finally的嵌套目的是能关一个尽量关一个
	try{
		if(fis != null)
			fis.close();
	}finally {
		if(fos != null)
			fos.close();
	}
	
	
	
}
```


```
/**
 * 自动关流，实现了AutoCloseable接口
 */
try(
	FileInputStream fis = new FileInputStream("xxx.txt");
	FileOutputStream fos = new FileOutputStream("xxx.txt");
){
	int b;
	while((b = fis.read()) != -1){
		fos.write(b);
	}
}
```

```
//图片加密
BufferedInputStream bis = new BufferedInputStream(new FileInputStream("copy.jpg"));
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.jpg"));
	
int b;
while( (b = bis.read() ) != -1 ){
	bos.write(b ^ 123);
}

bis.close();
bos.close();
```

```
/**
 * 在控制台录入文件的路径，将文件拷贝到当前项目下
 */
public static void main(String[] args) throws IOException {
	File file = getFile();
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
	
	int b;
	while( ( b = bis.read() ) != -1){
		bos.write(b);
	}
	
	bis.close();
	bos.close();
	
}

public static File getFile(){
	Scanner sc = new Scanner(System.in);
	while(true){
		String line = sc.nextLine();
		File file = new File(line);
		if(!file.exists()) {
			System.out.println("你录入的文件路径不存在，请重新录入：");
		}else if(file.isDirectory()){
			System.out.println("你录入的是文件夹路径，请重新录入：");
		}else {
			return file;
		}
	}
	
}

```

```
/**
 * 将键盘录入的数据拷贝到当前项目下的text.txt文件中，键盘录入数据当遇到quit就退出
 * @param args
 * @throws IOException 
 */
public static void main(String[] args) throws IOException {
	//1.创建键盘录入对象
	Scanner sc = new Scanner(System.in);
	//2.创建输出流对象，关联text.txt文件
	FileOutputStream fos = new FileOutputStream("text.txt");
	//3.定义无限循环
	while(true){
		String line = sc.nextLine();
		//4.遇到quit退出循环
		if("quit".equals(line)){
			break;
		}
		//5.如果不是quit,就将内容写出
		fos.write(line.getBytes());
		fos.write("\r\n".getBytes());
	}
	//6.关流
	fos.close();
	
}
```


### 字符流
* 字符流是什么
	* 字符流就是可以直接读写字符的IO流
	* 字符流读取字符，就是先读取到字节数据，然后转为字符，如果要写出字符，需要把字符转换为字节再写出
	
#### FileReader & FileWriter
```
//文件读取流读取字符
public static void main(String[] args) throws IOException {
	
	FileReader fr = new FileReader("xxx.txt");
	int c;
	
	while((c = fr.read()) != -1){ 			//通过项目默认的码表一次读取一个字符
		System.out.println((char)c);
	}
	
	fr.close();
	
}
```
```
FileWriter fw = new FileWriter("yyy.txt");
fw.write("字符串！！！")；
fw.write(97);		//a
fw.close();
```


### 字符流拷贝
```
FileReader fr = new FileReader("xxx.txt");
FileWriter fw = new FileWriter("zzz.txt");

int c;
while((c = fr.read()) != -1){ 			//通过项目默认的码表一次读取一个字符
	fw.write(c);
}

fr.close();
fw.close();				//Writer类中有一个2k的缓冲区，如果不关流就不会将缓冲区内容写入
```

> 字符流也可以拷贝文本文件，但不推荐使用，因为读取时会把字节转为字符，写出时还要把字符转回字节
> 程序需要读取一短文本，或者需要写出一段文本的时候可以使用字符流
> 读取的时候可以按照字符的大小读取，不会出现半个中文
> 写出的时候可以直接将字符串写出，不用转换为字节数组


```
//小数组拷贝
FileReader fr = new FileReader("xxx.txt");
FileWriter fw = new FileWriter("zzz.txt");

char[] arr = new char[1024];
int len;
while( (len = fr.read(arr)) != -1 ){		//将文件上的数据读取到字符数组中
	fw.write(arr,0,len);					//将字符数组中的数据写到文件上
}

fr.close();
fw.close();
		
```

### 带缓冲区的字符流
* BufferedReader的read()方法读取字符时回一次读取若干字符到缓冲区，然后逐个返回给程序，降低读取文件的次数，提高效率
* BufferedWriter的write()方法写出字符时会先写到缓冲区，缓冲区写满时才会写到文件，降低写文件的次数，提高效率

```
BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
BufferedWriter bw = new BufferedWriter(new FileWriter("xxx.txt"));

int c;
while( (c = br.read()) != -1 ){
	bw.write(c);
}

br.close();
bw.close();
		
```

### readLine()和newLine()方法
* BufferedReader的readLine()方法可以读取一行字符(不包含换行符),读取到末尾时返回null
* BufferedWriter的newLine()可以输出一个跨平台的换行符号"\r\n"


### LineNumberReader(BufferedReader的子类对象)
```
public static void main(String[] args) throws IOException {
	
	LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));
	String line;
//		lnr.setLineNumber(100);  readLine()一次,行号自增1
	while( (line = lnr.readLine()) != null) {
		System.out.println(lnr.getLineNumber()+":"+line);
	}
	
	lnr.close();
}
	
```



### 装饰设计模式
> 耦合性不强，被装饰的类的变化与装饰类的变化无关；


```

public class Test {
	
	public static void main(String[] args) throws IOException {
		HeimaStudent hms = new HeimaStudent(new Student());
		hms.code();
	}
	
}

interface Coder {
	public void code();
}


class Student implements Coder{

	public void code() {
		System.out.println("javase");
		System.out.println("javaweb");
	}
}

class HeimaStudent implements Coder{
	//1.获取被装饰类的引用
	private Student s;			//获取学生引用

	//2.在构造方法中传入被装饰类的对象
	public HeimaStudent(Student s) {
		super();
		this.s = s;
	}
	//3.对原有的功能进行升级
	public void code() {
		// TODO Auto-generated method stub
		s.code();
		System.out.println("SSH");
		System.out.println("数据库");
		System.out.println("大数据");
		System.out.println("...");
	}
	
	
	
}

```

### InputStreamReader && OutputStreamWriter
* InputStreamReader 字节流通向字符流的桥梁，可由指定的编码表读取字节并将其解码为字符
* OutputStreamWriter 字符流通向字节流的桥梁，由指定的编码表将要写入流中的字符编码成字节
```
public static void main(String[] args) throws IOException {
	InputStreamReader isr = new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8");		//指定码表读字符
	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");			//指定码表写字符		
	int c;
	while( (c = isr.read()) != -1){
		osw.write(c);
	}
	
	isr.close();
	osw.close();
}
```
![](http://yingxs.com/img/zhuanhuanliu.png)

### 统计文本文件中各个字符个数
```
//统计字符个数
public class Test {
	
	public static void main(String[] args) throws IOException {
		//1.创建带缓冲区的输入流对象
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		//2.创建双列集合对象TreeMap
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		
		int ch;
		while( (ch = br.read()) != -1 ){
			char c = (char)ch;
			if(!tm.containsKey(c)){
				tm.put(c, 1);
			}else{
				tm.put(c,tm.get(c)+1);
			}
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
		for(Character key : tm.keySet()) {
			switch (key){
				case '\t':
					bw.write("\\t" + "=" + tm.get(key));
					break;
				case '\n':
					bw.write("\\n" + "=" + tm.get(key));
					break;
				case '\r':
					bw.write("\\r" + "=" + tm.get(key));
					break;
			default:
				bw.write(key + "=" + tm.get(key));
				break;
			}
			
			
			bw.newLine();
		}
		
		bw.close();
	}
	
}
```

```
//试用版软件
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("config.txt"));
	String line = br.readLine();
	int times = Integer.parseInt(line);
	if(times > 0){
		System.out.println("你还有" + times-- + "次机会");
		FileWriter fw = new FileWriter("config.txt");
		fw.write(times+"");
		fw.close();
	}else{
		System.out.println("你的使用次数已到，请购买正版！");
	}
}
```