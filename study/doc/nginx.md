#配置
##1.负载均衡 
### 1.1 根据权重
```
upstream backend { 
    server 192.168.0.14 weight=10; 
    server 192.168.0.15 weight=10; 
}
```
###1.2 根据IpHash
```
upstream backend { 
    ip_hash; 
    server   172.16.125.76:8066 weight=10;  
    server   172.16.125.76:8077 down;  
    server   172.16.0.18:8066 max_fails=3 fail_timeout=30s;  
    server   172.16.0.18:8077 backup;  
} 
```
###1.3 智能调度
```
智能调整调度算法，动态的根据后端服务器的请求处理器的请求处理响应的时间来进行均衡分配，
响应时间短，处理效率高的服务器分配到请求的概率高，响应时间长，处理效率低的服务器分配到的请求少；
结合了前两者的优点的一种调度算法。但是需要注意的是nginx默认不支持fair算法，如果要使用这种算法，
需要安装upstream_fair模块。
```
###1.3 根据urlHash
```
按照访问的url的hash结果分配请求，每个请求的url会指向后端固定的某个服务器，
可以在nginx作为静态服务器的情况下提高缓存效率。同样要注意Nginx默认不支持这种调度算法，
要使用的话需要安装nginx的hash软件包。
```

