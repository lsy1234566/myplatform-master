#Java JDK
##1.JVM 
### 1.1 内存模型
```
方法区 堆 虚拟机栈 本地方法栈 程序计数器

线程共享区:堆、方法区
线程私有区:虚拟机栈、本地方法栈、程序计数器

堆:新生代 老年代
新生代:伊甸园区 幸存者一区 幸存者二区
伊甸园区-TLAB(线程私有分配缓冲区):小对象通常JVM会优先分配在TLAB,无需锁(线程私有),速度快,

方法区(HotSpot-元空间,脱离堆):类信息、常量、静态变量、即时编译器编译后的代码等数据
运行时常量池:方法区的一部分，用于存放编译期生成的各种字面量和符号引用
字面量：字面量比较接近Java语言层次的常量概念，如文本字符串、被声明为final的常量值等
符号引用：符号引用属于编译原理方面的概念，包括以下三类常量：类和接口的全限定名、字段的名称和描述符、方法的名称和描述符
因为运行时常量池（Runtime Constant Pool）是方法区的一部分，那么当常量池无法再申请到内存时也会抛出 OutOfMemoryError 异常

虚拟机栈:局部变量,操作数栈,动态连接方法,返回地址

本地方法栈:

程序计数器:jvm独立实现的计数器,记录执行到的字节码
```
###1.2 java获取内存dump的几种方式
```
1、获取内存详情：jmap -dump:format=b,file=e.bin pid
这种方式可以用 jvisualvm.exe 进行内存分析，或者采用 Eclipse Memory Analysis Tools (MAT)这个工具

2. 获取内存dump：  jmap -histo:live pid
这种方式会先出发fullgc，所有如果不希望触发fullgc 可以使用jmap -histo pid

3.第三种方式：jdk启动加参数：
-XX:+HeapDumpBeforeFullGC 
-XX:HeapDumpPath=/httx/logs/dump
这种方式会产生dump日志，再通过jvisualvm.exe 或者Eclipse Memory Analysis Tools 工具进行分析
```
###2基础
###2.1三种遍历方式
```
keySet,foreach,iterator(迭代器)
Set<String> objects = objectObjectHashMap.keySet(); 
objectObjectHashMap.forEach((k,v)->{ });
Iterator<String> iterator = objects.iterator();
```

