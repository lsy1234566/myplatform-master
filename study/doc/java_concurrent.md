#Java 并发编程
##1.线程基础知识 
### 1.1 线程的状态
```
new(初始状态)-为调用start
runable之READY(就绪状态)-调用start但不处于执行状态,如线程时间片用完了
runable之RUNNING(运行中状态)-执行中
blocked(阻塞状态)-阻塞在synchronized或lock对象
waiting(等待)-不会被线程时间片唤醒,需要显式地唤醒
timed_waiting(超时等待)-相比waiting状态无须无限等待被唤醒,一定时间后将被唤醒
terminated(终止状态)-线程内容已经执行结束
```
###1.2 线程退出方式
```
thread.interrupt();
thread.stop();
volatile boolean flag=true;  while (flag){}
```
###1.3 
```

```
###1.3 
```

```

