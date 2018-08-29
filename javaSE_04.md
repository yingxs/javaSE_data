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
