logstash
----------
## 简介
Logstash 是免费且开放的服务器端数据处理管道，能够从多个来源采集数据，转换数据，然后将数据发送到您最喜欢的“存储库”中。

[logstash官网地址](https://www.elastic.co/cn/logstash)

### 安装部署
[下载链接](https://www.elastic.co/cn/downloads/logstash)

找到config文件夹，执行shell命令
```
vi logstash-es.conf
```

复制以下配置
```
input {
  tcp {
    mode => "server"
    host => "0.0.0.0"
    port => 4560
    codec => json_lines
  }
}
filter {
    grok {
        match => ["message", "%{TIMESTAMP_ISO8601:times}"]
    }
    date {
        match => ["times", "yyyy-MM-dd HH:mm:ss,SSS"]
        locale => "en"
        timezone => "+00:00"
        remove_field => "times"
    }
}
output {
  elasticsearch {
    hosts => "ip:9200"
    index => "springboot-logstash-%{+YYYY.MM.dd}"
  }
}
```

下载完成之后启动命令：
```
nohup ./bin/logstash -f ./config/logstash-es.conf &
```
### 基于springboot的配置
application.yml

```
logging:
  config: classpath:logback-spring.xml                      
```
logback-spring.xml 
```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <conversionRule conversionWord="tid" converterClass="org.apache.skywalking.apm.toolkit.log.logback.v1.x.LogbackPatternConverter"/>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
            <layout class="org.apache.skywalking.apm.toolkit.log.logback.v1.x.mdc.TraceIdMDCPatternLogbackLayout">
                <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%X{tid}] [%thread] %-5level %logger{36} -%msg%n</Pattern>
            </layout>
        </encoder>
    </appender>
    <appender name="ASYNC" class="ch.qos.logback.classic.AsyncAppender">
        <discardingThreshold>0</discardingThreshold>
        <queueSize>1024</queueSize>
        <neverBlock>true</neverBlock>
        <appender-ref ref="STDOUT"/>
    </appender>
    <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
        <!--配置logStash 服务地址-->
        <destination>ip:4560</destination>
        <encoder charset="UTF-8" class="net.logstash.logback.encoder.LogstashEncoder">
            <provider class="org.apache.skywalking.apm.toolkit.log.logback.v1.x.logstash.TraceIdJsonProvider">
            </provider>
        </encoder>
        <encoder class="net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder">
            <providers>
                <timestamp>
                    <timeZone>UTC</timeZone>
                </timestamp>
                <pattern>
                    <pattern>
                        {
                        "level": "%level",
                        "tid": "%tid",
                        "thread": "%thread",
                        "class": "%logger{1.}:%L",
                        "message": "%message",
                        "stackTrace": "%exception{10}",
                        "pid":"auth"
                        }
                    </pattern>
                </pattern>
            </providers>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="LOGSTASH" />
        <appender-ref ref="ASYNC"/>
    </root>
</configuration>                     
```