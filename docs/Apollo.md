分布式配置中心Apollo
----------
## 简介

Apollo（阿波罗）是携程框架部门研发的分布式配置中心，能够集中化管理应用不同环境、不同集群的配置，配置修改后能够实时推送到应用端，并且具备规范的权限、流程治理等特性，适用于微服务配置管理场景。

[Apollo官网地址](https://ctripcorp.github.io/apollo/#/zh/deployment/quick-start)

### 安装部署
* 通过[网盘链接](https://pan.baidu.com/s/1Ieelw6y3adECgktO0ea0Gg)下载，提取码: 9wwe
* 下载到本地后，在本地解压apollo-quick-start.zip
下载完成之后启动命令：
```
./demo.sh start
```

### 验证安装成功失败
安装完成后，在浏览器输入http://ip:8070/
如果看到如下图片便是安装成功
![nacos](img/apollo.jpg)
### 基于springboot的配置
application.yml

```
apollo:
  meta: http://ip:8080            
  autoUpdateInjectedSpringProperties: true   
  bootstrap:
    enabled: true                            
    namespaces: application                  
    eagerLoad:
      enabled: false                         
```

