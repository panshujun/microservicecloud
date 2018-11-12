package com.niuniu.springcloud.cfgbeans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.niuniu.springcloud.entities.Dept;

import feign.Request;

@RestController
public class DeptController_Consumer {

//	private static final String RSET_URL_PREFIX = "http://localhost:8001"; 
	private static final String RSET_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT"; 
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(RSET_URL_PREFIX+"dept/add",dept , Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(RSET_URL_PREFIX+"/dept/get"+id, Dept.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery",method=RequestMethod.GET)
	public Object discovery()
	{ 
		return restTemplate.getForObject(RSET_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
