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