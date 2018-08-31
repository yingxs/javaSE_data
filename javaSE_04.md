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