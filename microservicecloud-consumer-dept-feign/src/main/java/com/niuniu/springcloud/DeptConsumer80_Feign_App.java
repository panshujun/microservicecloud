package com.niuniu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

//import com.niuniu.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableFeignClients(basePackages= {"com.niuniu.springcloud"})
@ComponentScan("com.niuniu.springcloud")
public class DeptConsumer80_Feign_App{
	public static void main(String[] args){
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}
}

