package com.sparticles.gateway;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.sparticles.gateway.config.DynamicDataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableMethodCache(basePackages = "com.sparticles.gateway")
@EnableCreateCacheAnnotation
@Import({DynamicDataSourceConfig.class})
@MapperScan("com.sparticles.gateway.dao")
@ComponentScan("com.sparticles.*")
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
public class GatewayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayApplication.class, args);
        log.info("success");
    }
}
