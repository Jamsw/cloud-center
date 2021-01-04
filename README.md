[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 快速开始

### 基础环境

使用本脚手架要求有springboot和springcloud相关基础，部署一下基础环境

- [git](https://git-scm.com/)
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 

### 环境搭建

**具体步骤如下：**

1. 克隆代码库： `git clone https://github.com/Jamsw/cloud-center.git`

2. 根据你的开发工具进行下载各种依赖包

### 安装以下相关工具


|  服务           |   服务名         |  端口     | 备注                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  数据库         |   mysql         |  3306     |启动几个实例都行，脚手架支持多数据源|                         |
|  注册与配置中心  |   nacos         |  8848     |  [安装与使用文档](./docs/nacos.md)             |
|  分布式链路  |   skywalking |  8399     |  [安装与使用文档](./docs/skywalking.md)|
|  数据存储中间件  |   elasticsearch |  9200     |  [安装与使用文档](./docs/elasticsearch.md)   |
|  日志分析工具    |   kibana        |  5601     |  [安装与使用文档](./docs/kibana.md)    |
|  日志收集中间件  |   logstash       |   4560    |  [安装与使用文档](./docs/logstash.md)     |
|  分布式配置中心  |   Apollo       |    8070   |  [安装与使用文档](./docs/Apollo.md)     |
|  高可用防护组件  |   sentinel       |   8718    |  [安装与使用文档](./docs/sentinel.md)     |

* 2.新增数据库及表结构


* 3.脚手架模块介绍

| 模块名称   |   简介      |  应用地址                | 文档                    |
|----------|---------------------------|-------------------------|-------------|
|  auth  |  oauth权限控制    |  http://localhost:8071  | [文档](./auth/readme.md)         |
|  client  |  测试客户端    |  http://localhost:8071  | 无         |
|  common    |  通用模块    |  http://localhost:8071  | 无         |
|  dynamicDataSource  |  多数据源 配置   |  http://localhost:8071  | [文档](./dynamicDataSource/readme.md)         |
|  gateway  |  网关    |  http://localhost:8071  | [文档](./gateway/readme.md)         |
|  monitor  |  微服务监控    |  http://localhost:8071  | [文档](./monitor/readme.md)         |
|  nacos-adapter  |   prometheus适配nacos服务中心   |  http://localhost:8071  | [文档](./nacos-adapter/readme.md)         |

* 4.案例示意图

